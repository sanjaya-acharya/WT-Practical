package SQLCommands;

import java.sql.*;

public class Update {
	public int update(String fname, String lname, String email, String newfname, String newlname, String newemail) throws Exception {

		Read readObject = new Read();

		ResultSet results = readObject.read(fname, lname, email);

		String query;
		int result = 0;
		String f, l, e;
		String tempf = newfname, templ = newlname, tempe = newemail;

		while (results.next()) {
			f = results.getString("firstname");
			l = results.getString("lastname");
			e = results.getString("email");

			if (newfname.equals(""))
			tempf = f;
			if (newlname.equals(""))
			templ = l;
			if (newemail.equals(""))
			tempe = e;
			
			query = "UPDATE Java SET " +
			"firstname = ?, " +
			"lastname = ?, " +
			"email = ? " +
			" WHERE " +
			"firstname = ? AND " +
			"lastname = ? AND " +
			"email = ?" +
			";";
			
			readObject.SQL.p = readObject.SQL.c.prepareStatement(query);
			
			readObject.SQL.p.setString(1, tempf);
			readObject.SQL.p.setString(2, templ);
			readObject.SQL.p.setString(3, tempe);
			readObject.SQL.p.setString(4, f);			
			readObject.SQL.p.setString(5, l);
			readObject.SQL.p.setString(6, e);
			
			try {
				readObject.SQL.p.executeUpdate();
				result++;
			}
			catch (Exception e1) {
				return result;
			}
		}
		return result;
	}
}