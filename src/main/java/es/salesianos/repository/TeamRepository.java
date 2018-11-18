package es.salesianos.repository;

import java.sql.Connection;
import java.sql.Date;
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
			preparedStatement = conn
					.prepareStatement("INSERT INTO TEAM (name,nationality)" + "VALUES (?, ?)");
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
			prepareStatement = conn.prepareStatement("SELECT idTeam, name, nationality FROM TEAM");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Team teamInDatabase = new Team();
				teamInDatabase.setIdTeam(resultSet.getInt(1));
				teamInDatabase.setName(resultSet.getString(2));
				teamInDatabase.setNationality(resultSet.getInt(3));
				teamsList.add(teamInDatabase);
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
