package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Nationality;
import es.salesianos.service.NationalityService;

public class NationalityServlet extends HttpServlet {
	private NationalityService service = new NationalityService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Nationality> listAllNations = service.listAllNations();
		req.setAttribute("listAllNations", listAllNations);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/teamsList.jsp");
		dispatcher.forward(req, resp);
	}
}
