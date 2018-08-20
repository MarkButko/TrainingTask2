package mark.butko.controller.listeners;

import static mark.butko.constants.Attributes.APPLIANCES;
import static mark.butko.constants.Attributes.POWER_SOCKET;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import mark.butko.data.DataBaseEmulator;
import mark.butko.model.entities.providers.PowerSocket;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session init");
		HttpSession session = se.getSession();
		session.setAttribute(APPLIANCES, DataBaseEmulator.getData());
		session.setAttribute(POWER_SOCKET, new PowerSocket());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
