package mark.butko.controller.filters;

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
		String color = request.getParameter("color_filter");
		if (color == null) {
			colorFilter = (String) request.getSession().getAttribute("color_filter");
		} else {
			colorFilter = color;
		}

		Set<ElectricalAppliance> filteredAppliances = appliances;

		try {
			if (!colorFilter.equalsIgnoreCase("all")) {
				Colors.valueOf(colorFilter.toUpperCase());

				request.getSession().setAttribute("color_filter", colorFilter);
				filteredAppliances = appliances.stream()
						.filter(device -> device.getColor().equalsIgnoreCase(colorFilter)).collect(Collectors.toSet());
			}
		} catch (Exception ex) {
			// nothing here if parameter is not valid color
		}

		if (nextChain != null) {
			return nextChain.getFiltered(filteredAppliances, request);
		} else {
			return filteredAppliances;
		}
	}
}
