package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Team;

public class TeamAssembler {

	public static Team assembleTeamFrom(HttpServletRequest req) {
		Team team = new Team();
		String name = req.getParameter("name");
		int nationality = Integer.parseInt(req.getParameter("nationality"));
		team.setName(name);
		team.setNationality(nationality);
		return team;
	}

}
