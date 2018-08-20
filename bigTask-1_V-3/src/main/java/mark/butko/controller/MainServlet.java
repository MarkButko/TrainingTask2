package mark.butko.controller;

import static mark.butko.constants.Attributes.APPLIANCES;
import static mark.butko.constants.Attributes.COLORS;
import static mark.butko.constants.Attributes.POWER_SOCKET;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mark.butko.controller.commands.Command;
import mark.butko.controller.commands.CountCommand;
import mark.butko.controller.commands.FilterCommand;
import mark.butko.controller.commands.SortCommand;
import mark.butko.controller.commands.TurnOffCommand;
import mark.butko.controller.commands.TurnOnCommand;
import mark.butko.data.DataBaseEmulator;
import mark.butko.model.Colors;
import mark.butko.model.entities.providers.PowerSocket;

/**
 * Servlet that controlls all interactions ofuser with main.jsp page. Implements
 * doGet method of HttpServler.
 * 
 * @author markg
 *
 */
@WebServlet(urlPatterns = { "/main", "/sort", "/filter", "/turn-on", "/turn-off", "/count-power" })
public class MainServlet extends HttpServlet {
	private int i = 0;
	private static final long serialVersionUID = 1L;
	private Map<String, Command> commands = new HashMap<>();

	@Override
	public void init() throws ServletException {
		System.out.println("init servlet");
		commands.put("turn-on", new TurnOnCommand());
		commands.put("turn-off", new TurnOffCommand());
		commands.put("filter", new FilterCommand());
		commands.put("sort", new SortCommand());
		commands.put("count-power", new CountCommand());

		getServletContext().setAttribute(COLORS, Colors.avaliable);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		if (i == 0) {
			doSessionListenerWork(request, response);
			i++;
		}

		String path = request.getServletPath();
		System.out.println(request.getServletPath() + " = servlet path");
		System.out.println(request.getPathInfo() + " = path info");
		path = path.replaceAll("^/", "");
		System.out.println(path + " =  path");
		Command command = commands.get(path);
		if (command != null) {
			command.execute(request, response);
		}
		getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
	}

	private void doSessionListenerWork(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("yolo");
		HttpSession session = request.getSession();
		session.setAttribute(APPLIANCES, DataBaseEmulator.getData());
		session.setAttribute(POWER_SOCKET, new PowerSocket());
	}
}
