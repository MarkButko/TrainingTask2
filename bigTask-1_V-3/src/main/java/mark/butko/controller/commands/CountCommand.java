package mark.butko.controller.commands;

import static mark.butko.constants.Attributes.POWER_SOCKET;
import static mark.butko.constants.Attributes.TOTAL_POWER_CONSUMPTION;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.model.entities.providers.PowerSocket;

public class CountCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PowerSocket powerSocket = (PowerSocket) request.getSession().getAttribute(POWER_SOCKET);
		int totalPowerConsumption = powerSocket.powerConsumption();
		request.getSession().setAttribute(TOTAL_POWER_CONSUMPTION, totalPowerConsumption);
	}

}
