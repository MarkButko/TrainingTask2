package mark.butko.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mark.butko.controller.commands.Command;
import mark.butko.controller.commands.CountCommand;
import mark.butko.controller.commands.FilterCommand;
import mark.butko.controller.commands.SortCommand;
import mark.butko.controller.commands.TurnOffCommand;
import mark.butko.controller.commands.TurnOnCommand;

/**
 * Servlet that controlls all interactions ofuser with main.jsp page. Implements
 * doGet method of HttpServler.
 * 
 * @author markg
 *
 */
@WebServlet(urlPatterns = { "/main", "/sort", "/filter", "/turn-on", "/turn-off", "/count-power" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> commands = new HashMap<>();

	@Override
	public void init() throws ServletException {

		commands.put("turn-on", new TurnOnCommand());
		commands.put("turn-off", new TurnOffCommand());
		commands.put("filter", new FilterCommand());
		commands.put("sort", new SortCommand());
		commands.put("count-power", new CountCommand());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getRequestURI();
		System.out.println(path);
		Command command = commands.get(path);
		command.execute(request, response);
		getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
	}

}
