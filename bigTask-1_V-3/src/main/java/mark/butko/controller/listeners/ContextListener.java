package mark.butko.controller.listeners;

import static mark.butko.constants.Attributes.COLORS;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import mark.butko.model.Colors;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Context loaded");
		ServletContext servletContext = event.getServletContext();
		servletContext.setAttribute(COLORS, Colors.avaliable);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
