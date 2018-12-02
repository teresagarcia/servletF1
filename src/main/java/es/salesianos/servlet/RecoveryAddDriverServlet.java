package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Team;
import es.salesianos.service.TeamService;

public class RecoveryAddDriverServlet extends HttpServlet {
	TeamService service = new TeamService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idTeam = req.getParameter("id");
		Team formTeam= new Team();
		formTeam.setIdTeam(Integer.parseInt(idTeam));
		////Owner ownerFromDatabase = service.search(ownerFormulario.getCodOwner());
		req.setAttribute("team", formTeam);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addDriverToTeam.jsp");
		dispatcher.forward(req,resp);
	}
	
}
