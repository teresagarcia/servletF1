package es.salesianos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Driver;
import es.salesianos.service.DriverService;

public class DriversServlet extends HttpServlet {

	private DriverService service = new DriverService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Driver> listAllDrivers = service.listAllDrivers();
		req.setAttribute("listAllDrivers", listAllDrivers);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/driversList.jsp");
		dispatcher.forward(req, resp);
	}
}
