package registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/greeting.jsp";

		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("inputEmail");
		String name = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");

		request.setAttribute("email", email);
		request.setAttribute("name", name);
		request.setAttribute("password", password);

		// check if email exists

		//@formatter:off
		getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		//@formatter:on

	}

}
