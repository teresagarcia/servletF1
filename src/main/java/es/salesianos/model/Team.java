package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private int idTeam;
	private String name;
	private int nationality;
	private List<Driver> drivers = new ArrayList<>();

	public int getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNationality() {
		return nationality;
	}

	public void setNationality(int nationality) {
		this.nationality = nationality;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

}
