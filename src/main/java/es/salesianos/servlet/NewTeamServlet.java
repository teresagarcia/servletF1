package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Driver;
import es.salesianos.model.Team;
import es.salesianos.service.DriverService;
import es.salesianos.service.TeamService;

public class NewTeamServlet extends HttpServlet {
	private TeamService service = new TeamService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Team team = service.assembleTeamFromRequest(req);
		service.insert(team);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/finish.jsp");
		dispatcher.forward(req, resp);
	}

	public TeamService getService() {
		return service;
	}

	public void setService(TeamService service) {
		this.service = service;
	}
}
