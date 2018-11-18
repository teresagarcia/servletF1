package es.salesianos.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Team;
import es.salesianos.model.assembler.TeamAssembler;
import es.salesianos.repository.TeamRepository;

public class TeamService {
	private TeamRepository repository = new TeamRepository();

	public Team assembleTeamFromRequest(HttpServletRequest req) {
		return TeamAssembler.assembleTeamFrom(req);
	}

	public void insert(Team team) {
		repository.insert(team);
	}

	public List<Team> listAllTeams() {
		return repository.searchAll();
	}

}
