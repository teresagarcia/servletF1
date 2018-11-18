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

public class DriverRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/F1Database";
	ConnectionManager manager = new ConnectionH2();

	public void insert(Driver formDriver) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO DRIVER (name,lastName,birthDate)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, formDriver.getName());
			preparedStatement.setString(2, formDriver.getLastName());
			preparedStatement.setDate(3, Date.valueOf(formDriver.getBirthDate()));
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

	public List<Driver> searchAll() {
		List<Driver> driversList = new ArrayList<Driver>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT idDriver, name, lastName, team, birthDate, nationality FROM DRIVER");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Driver driverInDatabase = new Driver();
				driverInDatabase.setName(resultSet.getString(2));
				driverInDatabase.setLastName(resultSet.getString(3));
				driverInDatabase.setTeam(resultSet.getInt(4));
				driverInDatabase.setBirthDate(resultSet.getDate(5).toLocalDate());
				driverInDatabase.setNationality(resultSet.getInt(6));
				driversList.add(driverInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return driversList;
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
}
