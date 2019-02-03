package es.salesianos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.DriverService;

public class DeleteDriverServlet extends HttpServlet {

	DriverService service = new DriverService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String answer = req.getParameter("answer");
		if (answer.equals("SI")) {
			String idDriver = req.getParameter("id");
			service.deleteDriver(Integer.parseInt(idDriver));
		}
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/driversList.jsp");
		dispatcher.forward(req, resp);
	}
}
