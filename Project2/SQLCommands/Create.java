package SQLCommands;

public class Create {
	Config SQL = new Config();

	public int insert(String fname, String lname, String email) throws Exception {
		String query = "INSERT INTO Java (`firstname`,`lastname`,`email`) VALUES (?, ?, ?);";

		SQL.connect();
		SQL.p = SQL.c.prepareStatement(query);

		SQL.p.setString(1, fname);
		SQL.p.setString(2, lname);
		SQL.p.setString(3, email);

		return SQL.p.executeUpdate();
	}
}