package es.salesianos.model;

import java.util.Calendar;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Driver {
	private String name;
	private String lastName;
	private int team;
	private static final int DEFAULT_TEAM = -1;
	private LocalDate birthDate;
	private String nationality;
//	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

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
			//yyyy-MM-dd
			this.birthDate = LocalDate.parse(birthDate);
		} catch (DateTimeParseException e) {
			this.birthDate = LocalDate.of(1900, 1, 1);
			//throw new RuntimeException(e);
		}
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
