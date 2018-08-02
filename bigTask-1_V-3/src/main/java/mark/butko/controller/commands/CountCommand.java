package mark.butko.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.model.entities.providers.PowerSocket;

public class CountCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PowerSocket powerSocket = (PowerSocket) request.getServletContext().getAttribute("powerSocket");
		int totalPowerConsumption = powerSocket.powerConsumption();
		request.getSession().setAttribute("totalPowerConsumption", totalPowerConsumption);
	}

}
