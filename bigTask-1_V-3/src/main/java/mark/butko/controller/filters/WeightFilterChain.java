package mark.butko.controller.filters;

import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import mark.butko.controller.util.ControllerUtil;
import mark.butko.model.entities.consumers.ElectricalAppliance;

/**
 * Filters given data set by weight range passed as request parameter or session
 * attribute
 * 
 * @see ElectricalAppliance
 * @see FilterChain
 * @author markg
 *
 */
public class WeightFilterChain extends FilterChain {

	@Override
	public Set<ElectricalAppliance> getFiltered(Set<ElectricalAppliance> appliances, HttpServletRequest request) {

		String fromString = request.getParameter("weight_from");
		String toString = request.getParameter("weight_to");

		Integer fromAttribute;
		Integer toAttribute;

		if (fromString == null) {
			fromAttribute = (Integer) request.getSession().getAttribute("weight_from");
		} else {
			fromAttribute = ControllerUtil.parseOrZero(fromString);
		}

		if (toString == null) {
			toAttribute = (Integer) request.getSession().getAttribute("weight_to");
		} else {
			toAttribute = ControllerUtil.parseOrMax(toString);
		}

		Integer from = ControllerUtil.zeroIfNotValid(fromAttribute);
		Integer to = ControllerUtil.maxIfNotValid(toAttribute);

		request.getSession().setAttribute("weight_from", from);
		request.getSession().setAttribute("weight_to", to);

		Set<ElectricalAppliance> filteredAppliances = appliances.stream()
				.filter(device -> device.getWeight() <= to && device.getWeight() >= from).collect(Collectors.toSet());

		if (nextChain != null) {
			return nextChain.getFiltered(filteredAppliances, request);
		} else {
			return filteredAppliances;
		}
	}
}
