package mark.butko.controller.commands;

import static mark.butko.constants.Attributes.APPLIANCES;
import static mark.butko.constants.Attributes.SORT_TYPE;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.model.ApplianceFeatures;
import mark.butko.model.entities.consumers.ElectricalAppliance;

public class SortCommand implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Set<ElectricalAppliance> filteredAppliances = (Set<ElectricalAppliance>) request.getSession()
				.getAttribute(APPLIANCES);

		String sortType = request.getParameter(SORT_TYPE);
		if (sortType == null) {
			sortType = (String) request.getSession().getAttribute(SORT_TYPE);
		}
		request.getSession().setAttribute(SORT_TYPE, sortType);

		Comparator<ElectricalAppliance> comparator;
		try {
			comparator = ApplianceFeatures.valueOf(sortType.toUpperCase()).getComparator();
		} catch (Exception ex) {
			comparator = ApplianceFeatures.POWER.getComparator();
		}
		TreeSet<ElectricalAppliance> sortedAppliances = new TreeSet<>(comparator);

		sortedAppliances.addAll(filteredAppliances);

		request.getSession().setAttribute(APPLIANCES, sortedAppliances);
	}

}
