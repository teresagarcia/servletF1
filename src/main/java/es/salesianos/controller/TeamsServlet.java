package es.salesianos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Team;
import es.salesianos.service.TeamService;

public class TeamsServlet extends HttpServlet {
	private TeamService service = new TeamService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Team> listAllTeams = service.listAllTeams();
		req.setAttribute("listAllTeams", listAllTeams);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/teamsList.jsp");
		dispatcher.forward(req, resp);
	}
}
