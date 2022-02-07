package SQLCommands;

import java.sql.*;

class Config {
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String dbUrl = "jdbc:mysql://localhost/gces";
	static final String dbUsername = "root";
	static final String dbPassword = "root";

	public Connection c;
	public Statement s;
	public PreparedStatement p;

	public void connect() throws Exception {
		// Loading driver...
		Class.forName(driver);

		// creating connection...
		c = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		// Creating preparedStatement
		p = c.prepareStatement("sql");
	}
}