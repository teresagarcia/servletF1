package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.Team;
import es.salesianos.repository.TeamRepository;

@Service("teamService")
@Profile("PRO")
public class TeamService {
	@Autowired
	private TeamRepository repository;

	public void insert(Team team) {
		repository.insert(team);
	}

	public List<Team> listAllTeams() {
		return repository.searchAll();
	}

}
