package mark.butko.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.data.DataBaseEmulator;
import mark.butko.model.entities.providers.PowerSocket;

public class TurnOnCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Long idLong = Long.parseLong(request.getParameter("id"));
		PowerSocket powerSocket = (PowerSocket) request.getServletContext().getAttribute("powerSocket");
		powerSocket.turnOn(DataBaseEmulator.getByID(idLong));
	}

}
