package es.salesianos.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Driver;

@Repository
public class DriverRepository extends es.salesianos.repository.Repository {
	private static final String jdbcUrl = getJdbcUrl();
	AbstractConnection manager = getManager();

	public void insert(Driver formDriver) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO DRIVER (name,lastName,team, birthDate, nationality)" + "VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, formDriver.getName());
			preparedStatement.setString(2, formDriver.getLastName());
			preparedStatement.setInt(3, formDriver.getTeam());
			preparedStatement.setDate(4, Date.valueOf(formDriver.getBirthDate()));
			preparedStatement.setInt(5, formDriver.getNationality());
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
				driverInDatabase.setId(resultSet.getInt(1));
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

	public Driver searchByDriverId(int id) {
		Driver driverInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM DRIVER WHERE idDriver = ?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				driverInDatabase = new Driver();
				driverInDatabase.setId(resultSet.getInt(1));
				driverInDatabase.setName(resultSet.getString(2));
				driverInDatabase.setLastName(resultSet.getString(3));
				driverInDatabase.setTeam(resultSet.getString(4));
				driverInDatabase.setBirthDate(resultSet.getString(5));
				driverInDatabase.setNationality(resultSet.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return driverInDatabase;
	}

	public void update(Driver formDriver) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE DRIVER SET name = ?, lastName = ?, team = ?, birthDate = ?, nationality = ? WHERE idDriver = ?");
			preparedStatement.setString(1, formDriver.getName());
			preparedStatement.setString(2, formDriver.getLastName());
			preparedStatement.setInt(3, formDriver.getTeam());
			preparedStatement.setDate(4, Date.valueOf(formDriver.getBirthDate()));
			preparedStatement.setInt(5, formDriver.getNationality());
			System.out.println("ID del piloto: " + formDriver.getId());
			preparedStatement.setInt(6, formDriver.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}

	public void deleteDriver(int id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM DRIVER WHERE idDriver = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		
	}
}
