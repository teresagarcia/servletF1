package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Driver;
import es.salesianos.service.DriverService;

public class EditDriverServlet extends HttpServlet {

	DriverService service = new DriverService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idDriver = req.getParameter("id");
		Driver formDriver = new Driver();
		formDriver.setId(Integer.parseInt(idDriver));
		Driver driverFromDatabase = service.search(formDriver.getId());
		System.out.println(driverFromDatabase.getLastName());
		req.setAttribute("driver", driverFromDatabase);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editDriver.jsp");
		dispatcher.forward(req, resp);
	}
}
