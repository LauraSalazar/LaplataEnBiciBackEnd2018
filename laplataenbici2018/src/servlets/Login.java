package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = "/Login", initParams={
		@WebInitParam(name="nombreUsuario", value="Juan"),
		@WebInitParam(name="passwordUsuario", value="javayapl"),
		@WebInitParam(name="nombreAdmin", value="Admin"),
		@WebInitParam(name="passwordAdmin", value="owner")
}
)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("nombre").equals(getInitParameter("nombreUsuario")) && request.getParameter("password").equals(getInitParameter("passwordUsuario"))) {
			response.sendRedirect("/LaPlataEnBici/usuarioView.html");
		} else if (request.getParameter("nombre").equals(getInitParameter("nombreAdmin")) && request.getParameter("password").equals(getInitParameter("passwordAdmin"))) {
			response.sendRedirect("/LaPlataEnBici/administradorView.html");
		} else {
			response.sendRedirect("/LaPlataEnBici/index.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}