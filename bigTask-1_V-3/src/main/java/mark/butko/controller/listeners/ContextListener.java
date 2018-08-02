package mark.butko.controller.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import mark.butko.model.Colors;
import mark.butko.model.entities.providers.PowerSocket;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		servletContext.setAttribute("colors", Colors.values());
		servletContext.setAttribute("powerSocket", new PowerSocket());
		System.out.println("Context listener");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
