package es.salesianos.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Driver;
import es.salesianos.model.assembler.DriverAssembler;
import es.salesianos.repository.DriverRepository;

public class DriverService {
	private DriverRepository repository = new DriverRepository();

	public Driver assembleDriverFromRequest(HttpServletRequest req) {
		return DriverAssembler.assembleDriverFrom(req);
	}

	public void insert(Driver driver) {
		repository.insert(driver);
	}

	public void calculateAgeAndAddIntoRequest(HttpServletRequest req, LocalDate localDate) {
		// TODO Auto-generated method stub
	}

	public List<Driver> listAllDrivers() {
		return repository.searchAll();
	}

	public Driver search(int id) {
		return repository.searchByDriverId(id);
	}

	public void update(Driver driver) {
		repository.update(driver);
	}

}
