package es.salesianos.model;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Driver {
	private String name;
	private String lastName;
	private int team;
	private static final int DEFAULT_TEAM = -1;
	private Calendar birthDate;
	private String nationality;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

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

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = Calendar.getInstance();
		try {
			//yyyy-MM-dd
			this.birthDate.setTime(sdf.parse(birthDate));
		} catch (ParseException e) {
			this.birthDate.set(Calendar.YEAR, 1900);
			this.birthDate.set(Calendar.MONTH, 1);
			this.birthDate.set(Calendar.DAY_OF_MONTH, 1);
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
