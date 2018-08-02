package mark.butko.controller.filters;

import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import mark.butko.controller.util.ControllerUtil;
import mark.butko.model.ApplianceFeatures;
import mark.butko.model.entities.consumers.ElectricalAppliance;

/**
 * Filters given data set by wire length range passed as request parameter or
 * session attribute
 * 
 * @see ElectricalAppliance
 * @see FilterChain
 * @author markg
 *
 */
public class WireLengthFilterChain extends FilterChain {

	@Override
	public Set<ElectricalAppliance> getFiltered(Set<ElectricalAppliance> appliances, HttpServletRequest request) {

		String fromString = request.getParameter("wire_length_from");
		String toString = request.getParameter("wire_length_to");

		Integer fromAttribute;
		Integer toAttribute;

		if (fromString == null) {
			fromAttribute = (Integer) request.getSession().getAttribute("wire_length_from");
		} else {
			fromAttribute = ControllerUtil.parseOrZero(fromString);
		}

		if (toString == null) {
			toAttribute = (Integer) request.getSession().getAttribute("wire_length_to");
		} else {
			toAttribute = ControllerUtil.parseOrMax(toString);
		}

		Integer from = ControllerUtil.zeroIfNotValid(fromAttribute);
		Integer to = ControllerUtil.maxIfNotValid(toAttribute, ApplianceFeatures.WIRE_LENGTH);

		request.getSession().setAttribute("wire_length_from", from);
		request.getSession().setAttribute("wire_length_to", to);

		Set<ElectricalAppliance> filteredAppliances = appliances.stream()
				.filter(device -> device.getWireLength() <= to && device.getWireLength() >= from)
				.collect(Collectors.toSet());

		if (nextChain != null) {
			return nextChain.getFiltered(filteredAppliances, request);
		} else {
			return filteredAppliances;
		}
	}
}
