package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.Nationality;
import es.salesianos.repository.NationalityRepository;

@Service
@Profile("PRO")
public class NationalityService {
	@Autowired
	NationalityRepository repository;
	
	public List<Nationality> listAllNations() {
		return repository.searchAll();
	}

}
