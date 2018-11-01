package es.salesianos.connection;

import java.sql.Connection;

public interface ConnectionManager {

	Connection open(String jdbcurl);

	public Connection executeSql(Connection conn, String sql);

	void close(Connection conn);

}
