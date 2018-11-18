package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Driver;
import es.salesianos.service.DriverService;

public class NewDriverServlet extends HttpServlet {

	private DriverService service = new DriverService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Driver driver = service.assembleDriverFromRequest(req);
		service.insert(driver);
		service.calculateAgeAndAddIntoRequest(req, driver.getBirthDate());
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/finish.jsp");
		dispatcher.forward(req, resp);
	}

	public DriverService getService() {
		return service;
	}

	public void setService(DriverService service) {
		this.service = service;
	}
}
