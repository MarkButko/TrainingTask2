package mark.butko.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.model.Colors;

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
			case "turn-on":
				PowerSocketController.turnOnDevice(request, response);
				setForwardData(request, response);
				break;
			case "count-power":
				PowerSocketController.countPowerConsumption(request, response);
				setForwardData(request, response);
				break;
			default:
			}
		} else {
			setForwardData(request, response);
		}
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

	public void setForwardData(HttpServletRequest request, HttpServletResponse response) {
		PowerSocketController.filter(request, response);
		request.getSession().setAttribute("colors", Colors.values());
	}
}
