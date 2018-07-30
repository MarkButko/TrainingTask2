package mark.butko.controller;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.controller.filters.ColorFilterChain;
import mark.butko.controller.filters.FilterChain;
import mark.butko.controller.filters.PowerFilterChain;
import mark.butko.controller.filters.WeightFilterChain;
import mark.butko.controller.filters.WireLengthFilterChain;
import mark.butko.data.DataBaseEmulator;
import mark.butko.model.ApplianceFeatures;
import mark.butko.model.entities.consumers.ElectricalAppliance;
import mark.butko.model.entities.providers.PowerSocket;

/**
 * Controlls user interaction with database and inner power socket object. Gives
 * most of methods for processing user requests and filtering data.
 * 
 * @see PowerSocket
 * @see FilterChain
 * @see ElectricalAppliance
 * @author markg
 *
 */
public class PowerSocketController {

	private static PowerSocket powerSocket = new PowerSocket();
	private static FilterChain filterChain;

	static {
		filterChain = new ColorFilterChain();
		FilterChain wireLengthFilterChain = new WireLengthFilterChain();
		FilterChain powerFilterChain = new PowerFilterChain();
		FilterChain weightFilterChain = new WeightFilterChain();

		filterChain.setNextChain(wireLengthFilterChain);
		wireLengthFilterChain.setNextChain(powerFilterChain);
		powerFilterChain.setNextChain(weightFilterChain);
	}

	/**
	 * Gives id parameter from request object and sets specified device in powered
	 * mode.
	 * 
	 * @param request
	 * @param response
	 */
	public static void turnOnDevice(HttpServletRequest request, HttpServletResponse response) {
		Long idLong = Long.parseLong(request.getParameter("id"));
		powerSocket.turnOn(DataBaseEmulator.getByID(idLong));
	}

	/**
	 * Counts total power that turned on devices consume at the moment. Sets this
	 * number as session attribute.
	 * 
	 * @param request
	 * @param response
	 */
	public static void countPowerConsumption(HttpServletRequest request, HttpServletResponse response) {
		int totalPowerConsumption = powerSocket.powerConsumption();
		request.getSession().setAttribute("totalPowerConsumption", totalPowerConsumption);
	}

	/**
	 * Runs filer chain and sorts data set. Sets data as session attribute after
	 * processing.
	 * 
	 * @param request
	 * @param response
	 */
	public static void filter(HttpServletRequest request, HttpServletResponse response) {

		Set<ElectricalAppliance> appliances = DataBaseEmulator.getData();
		Set<ElectricalAppliance> filteredAppliances = filterChain.getFiltered(appliances, request);

		String sortType = (String) request.getSession().getAttribute("sort-type");
		if (sortType == null) {
			sortType = request.getParameter("sort-type");
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
