package es.salesianos.model;

import java.util.Calendar;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Driver {
	private int idDriver;
	private String name;
	private String lastName;
	private int team;
	private static final int DEFAULT_TEAM = -1;
	private static final int DEFAULT_NATION = -1;
	private LocalDate birthDate;
	private int nationality;

	public int getId() {
		return idDriver;
	}

	public void setId(int id) {
		this.idDriver = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(String team) {
		try {
			if (team != null)
				this.team = Integer.valueOf(team);
		} catch (Exception e) {
			this.team = DEFAULT_TEAM;
		}

	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		try {
			// yyyy-MM-dd
			if (birthDate != null)
				this.birthDate = LocalDate.parse(birthDate);
		} catch (DateTimeParseException e) {
			this.birthDate = LocalDate.of(1900, 1, 1);
			// throw new RuntimeException(e);
		}
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		try {
			if (nationality != null)
				this.nationality = Integer.valueOf(nationality);
		} catch (Exception e) {
			this.team = DEFAULT_NATION;
		}
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public void setNationality(int nationality) {
		this.nationality = nationality;
	}

}
