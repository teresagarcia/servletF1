package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Nationality;
import es.salesianos.repository.NationalityRepository;

public class NationalityService {
	NationalityRepository repository = new NationalityRepository();
	
	public List<Nationality> listAllNations() {
		return repository.searchAll();
	}

}
