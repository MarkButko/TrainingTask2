package mark.butko.controller;

import java.util.Comparator;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.data.DataBaseEmulator;
import mark.butko.model.entities.consumers.ElectricalAppliance;
import mark.butko.model.entities.providers.PowerSocket;

public class PowerSocketController {

	private static PowerSocket powerSocket = new PowerSocket();

	public static void turnOnDevice(HttpServletRequest request, HttpServletResponse response) {
		Long idLong = Long.parseLong(request.getParameter("id"));
		powerSocket.turnOn(DataBaseEmulator.getByID(idLong));
	}

	public static void countPowerConsumption(HttpServletRequest request, HttpServletResponse response) {
		int totalPowerConsumption = powerSocket.powerConsumption();
		request
//		.getSession()
				.setAttribute("totalPowerConsumption", totalPowerConsumption);
	}

	public static void sort(HttpServletRequest request, HttpServletResponse response) {
		String sortType = request.getParameter("sort_type");
		Comparator<ElectricalAppliance> comparator = SortType.valueOf(sortType.toUpperCase()).getComparator();

		TreeSet<ElectricalAppliance> sortedAppliances = new TreeSet<>(comparator);
		sortedAppliances.addAll(DataBaseEmulator.getData());

		request
//		.getSession()
				.setAttribute("appliances", sortedAppliances);
	}

	enum SortType {
		POWER {
			public Comparator<ElectricalAppliance> getComparator() {
				return new ElectricalAppliance.PowerComparator().thenComparing(new ElectricalAppliance.IDComparator());
			}
		},
		COLOR {
			public Comparator<ElectricalAppliance> getComparator() {
				return new ElectricalAppliance.ColorComparator().thenComparing(new ElectricalAppliance.IDComparator());
			}
		};
		public Comparator<ElectricalAppliance> getComparator() {
			return null;
		}
	}
}
