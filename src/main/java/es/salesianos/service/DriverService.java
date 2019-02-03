package es.salesianos.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.Driver;
import es.salesianos.repository.DriverRepository;

@Service
@Profile("PRO")
public class DriverService {
	@Autowired
	private DriverRepository repository;

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

	public void deleteDriver(int id) {
		repository.deleteDriver(id);
		
	}

}
