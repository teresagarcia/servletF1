package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Nationality;

@org.springframework.stereotype.Repository
public class NationalityRepository extends Repository {
	private static final String jdbcUrl = getJdbcUrl();
	AbstractConnection manager = getManager();

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

	public List<Nationality> searchAll() {
		List<Nationality> nationsList = new ArrayList<Nationality>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT idNation, name FROM NATIONALITY");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Nationality nationInDatabase = new Nationality();
				nationInDatabase.setIdNation(resultSet.getInt(1));
				nationInDatabase.setName(resultSet.getString(2));
				nationsList.add(nationInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}
		return nationsList;
	}
}
