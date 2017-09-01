package database;

import java.sql.SQLException;

import javax.activation.DataSource;
import javax.naming.InitialContext;

import com.mysql.jdbc.Connection;

public class ConnectionPool {
	private static ConnectionPool pool = null;
	private static DataSource dataSource = null;

	private ConnectionPool() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/cs532db");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}

	public Connection getConnection() {
		return ((ConnectionPool) dataSource).getConnection();
	}

	public void freeConnection(java.sql.Connection connection) {
		try {
			connection.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}