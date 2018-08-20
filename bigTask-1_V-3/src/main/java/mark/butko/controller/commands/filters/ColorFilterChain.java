package mark.butko.controller.commands.filters;

import static mark.butko.constants.Attributes.COLOR_FILTER;

import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import mark.butko.model.Colors;
import mark.butko.model.entities.consumers.ElectricalAppliance;

/**
 * Filters given data set by color passed as request parameter or session
 * attribute
 * 
 * @see ElectricalAppliance
 * @see FilterChain
 * @author markg
 *
 */
public class ColorFilterChain extends FilterChain {

	@Override
	public Set<ElectricalAppliance> getFiltered(Set<ElectricalAppliance> appliances, HttpServletRequest request) {

		String colorFilter;
		String color = request.getParameter(COLOR_FILTER);
		if (color == null) {
			colorFilter = (String) request.getSession().getAttribute(COLOR_FILTER);
		} else {
			colorFilter = color;
		}

		Set<ElectricalAppliance> filteredAppliances = appliances;

		if (Colors.avaliable.contains(colorFilter.toLowerCase())) {

			request.getSession().setAttribute(COLOR_FILTER, colorFilter);
			if (!colorFilter.equalsIgnoreCase("any")) {
				filteredAppliances = appliances.stream()
						.filter(device -> device.getColor().equalsIgnoreCase(colorFilter)).collect(Collectors.toSet());
			}
		}
		if (nextChain != null) {
			return nextChain.getFiltered(filteredAppliances, request);
		} else {
			return filteredAppliances;
		}
	}
}
