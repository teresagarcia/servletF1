package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Driver;
import es.salesianos.model.Team;

public class TeamRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/F1Database";
	ConnectionManager manager = new ConnectionH2();

	public void insert(Team formTeam) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO TEAM (name,nationality)" + "VALUES (?, ?)");
			preparedStatement.setString(1, formTeam.getName());
			preparedStatement.setInt(2, formTeam.getNationality());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);

	}

	private void close(PreparedStatement prepareStatement) {
		if (null != prepareStatement) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	private void close(ResultSet resultSet) {
		if (null != resultSet) {

			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public List<Team> searchAll() {
		List<Team> teamsList = new ArrayList<Team>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT t.idTeam, t.name, t.nationality, "
					+ "d.idDriver, d.name, d.lastName FROM TEAM t, DRIVER d where t.idTeam = d.team order by t.idTeam");
			resultSet = prepareStatement.executeQuery();
			Team teamInDatabase = null;
			while (resultSet.next()) {
				if (teamInDatabase!= null && (teamInDatabase.getIdTeam() == resultSet.getInt(1))) {
					Driver driver = new Driver();
					driver.setId(resultSet.getInt(4));
					driver.setName(resultSet.getString(5));
					driver.setLastName(resultSet.getString(6));
					System.out.println(teamInDatabase.getName());
					teamInDatabase.getDrivers().add(driver);
				} else {
					teamInDatabase = new Team();
					teamInDatabase.setIdTeam(resultSet.getInt(1));
					teamInDatabase.setName(resultSet.getString(2));
					teamInDatabase.setNationality(resultSet.getInt(3));
					Driver driver = new Driver();
					driver.setId(resultSet.getInt(4));
					driver.setName(resultSet.getString(5));
					driver.setLastName(resultSet.getString(6));
					teamInDatabase.getDrivers().add(driver);
					teamsList.add(teamInDatabase);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return teamsList;
	}

}
