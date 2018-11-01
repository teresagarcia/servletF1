package es.salesianos.service;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Driver;
import es.salesianos.model.assembler.DriverAssembler;

public class Service {

	public Driver assembleDriverFromRequest(HttpServletRequest req) {
		return DriverAssembler.assembleUserFrom(req);
	}

	public void insert(Driver driver) {
		// TODO Auto-generated method stub
		
	}

	public void calculateAgeAndAddIntoRequest(HttpServletRequest req, Calendar calendar) {
		// TODO Auto-generated method stub
		
	}

}
