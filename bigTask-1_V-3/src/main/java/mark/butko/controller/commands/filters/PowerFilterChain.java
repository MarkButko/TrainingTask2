package mark.butko.controller.commands.filters;

import static mark.butko.constants.Attributes.POWER_FROM;
import static mark.butko.constants.Attributes.POWER_TO;

import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import mark.butko.controller.util.ControllerUtil;
import mark.butko.model.ApplianceFeatures;
import mark.butko.model.entities.consumers.ElectricalAppliance;

/**
 * Filters given data set by power range passed as request parameter or session
 * attribute
 * 
 * @see ElectricalAppliance
 * @see FilterChain
 * @author markg
 *
 */
public class PowerFilterChain extends FilterChain {

	@Override
	public Set<ElectricalAppliance> getFiltered(Set<ElectricalAppliance> appliances, HttpServletRequest request) {

		String fromString = request.getParameter(POWER_FROM);
		String toString = request.getParameter(POWER_TO);

		Integer fromAttribute;
		Integer toAttribute;

		if (fromString == null) {
			fromAttribute = (Integer) request.getSession().getAttribute(POWER_FROM);
		} else {
			fromAttribute = ControllerUtil.parseOrZero(fromString);
		}

		if (toString == null) {
			toAttribute = (Integer) request.getSession().getAttribute(POWER_TO);
		} else {
			toAttribute = ControllerUtil.parseOrMax(toString);
		}

		Integer from = ControllerUtil.zeroIfNotValid(fromAttribute);
		Integer to = ControllerUtil.maxIfNotValid(toAttribute, ApplianceFeatures.POWER);

		request.getSession().setAttribute(POWER_FROM, from);
		request.getSession().setAttribute(POWER_TO, to);

		Set<ElectricalAppliance> filteredAppliances = appliances.stream()
				.filter(device -> device.getPower() <= to && device.getPower() >= from).collect(Collectors.toSet());

		if (nextChain != null) {
			return nextChain.getFiltered(filteredAppliances, request);
		} else {
			return filteredAppliances;
		}
	}
}
