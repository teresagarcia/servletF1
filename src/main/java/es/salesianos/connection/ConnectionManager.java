package es.salesianos.connection;

import java.sql.Connection;

public interface ConnectionManager {

	Connection open(String jdbcurl);

	void close(Connection conn);

}
