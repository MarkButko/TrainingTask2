package mark.butko.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mark.butko.data.DataBaseEmulator;
import mark.butko.model.entities.consumers.ElectricalAppliance;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(urlPatterns = { "/main" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = (String) request.getParameter("operation");
		if (operation != null) {
			switch (operation) {
			case "turn_on":
				PowerSocketController.turnOnDevice(request, response);
				forwardAllData(request, response);
				break;
			case "count_power":
				PowerSocketController.countPowerConsumption(request, response);
				forwardAllData(request, response);
				break;
			case "sort":
				PowerSocketController.sort(request, response);
				break;
			default:
			}
		} else {
			forwardAllData(request, response);
			System.out.println("null");
		}

//		HttpSession session = request.getSession();
//		Set<ElectricalAppliance> appliances = DataBaseEmulator.getData();
//		request.setAttribute("appliances", appliances);
		getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void forwardAllData(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Set<ElectricalAppliance> appliances = DataBaseEmulator.getData();
		request.setAttribute("appliances", appliances);
	}
}
