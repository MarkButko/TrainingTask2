package mark.butko.controller.commands;

import static mark.butko.constants.Attributes.ID;
import static mark.butko.constants.Attributes.POWER_SOCKET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.data.DataBaseEmulator;
import mark.butko.model.entities.providers.PowerSocket;

public class TurnOnCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Long idLong = Long.parseLong(request.getParameter(ID));
		PowerSocket powerSocket = (PowerSocket) request.getSession().getAttribute(POWER_SOCKET);
		powerSocket.turnOn(DataBaseEmulator.getByID(idLong));
	}

}
