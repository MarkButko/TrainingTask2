package mark.butko.controller.commands;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.model.ApplianceFeatures;
import mark.butko.model.entities.consumers.ElectricalAppliance;

public class SortCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Set<ElectricalAppliance> filteredAppliances = (Set<ElectricalAppliance>) request.getSession()
				.getAttribute("appliances");

		String sortType = request.getParameter("sort-type");
		if (sortType == null) {
			sortType = (String) request.getSession().getAttribute("sort-type");
		}
		request.getSession().setAttribute("sort-type", sortType);

		Comparator<ElectricalAppliance> comparator;
		try {
			comparator = ApplianceFeatures.valueOf(sortType.toUpperCase()).getComparator();
		} catch (Exception ex) {
			comparator = ApplianceFeatures.POWER.getComparator();
		}
		TreeSet<ElectricalAppliance> sortedAppliances = new TreeSet<>(comparator);

		sortedAppliances.addAll(filteredAppliances);

		request.getSession().setAttribute("appliances", sortedAppliances);
	}

}
