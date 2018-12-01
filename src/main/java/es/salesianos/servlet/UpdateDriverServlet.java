package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Driver;
import es.salesianos.model.assembler.DriverAssembler;
import es.salesianos.service.DriverService;

public class UpdateDriverServlet extends HttpServlet {
	DriverService service = new DriverService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Driver driver = DriverAssembler.assembleDriverFrom(req);
		service.update(driver);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/driversList.jsp");
		dispatcher.forward(req, resp);
	}
}
