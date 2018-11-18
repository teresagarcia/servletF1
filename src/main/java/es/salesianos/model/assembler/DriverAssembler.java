package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Driver;

public class DriverAssembler {

	public static Driver assembleDriverFrom(HttpServletRequest req) {
		Driver driver = new Driver();
		String name = req.getParameter("name");
		String lastName = req.getParameter("lastName");
		String team = req.getParameter("team");
		String birthDate = req.getParameter("birthDate");
		String nationality = req.getParameter("nationality");
		driver.setName(name);
		driver.setLastName(lastName);
		driver.setTeam(team);
		driver.setBirthDate(birthDate);
		driver.setNationality(nationality);
		return driver;
	}

}
