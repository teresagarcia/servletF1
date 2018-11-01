package es.salesianos.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Driver;

public class Repository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/F1Database";
	ConnectionManager manager = new ConnectionH2();

	public void insert(Driver userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO USER (name,course,dateOfBirth)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, userFormulario.getName());
			preparedStatement.setString(2, userFormulario.getLastName());
			preparedStatement.setDate(3, Date.valueOf(userFormulario.getBirthDate()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	private void close(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		
	}

}
