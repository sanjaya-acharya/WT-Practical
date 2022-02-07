import javax.swing.*;

import AppFrame.*;
import SQLCommands.*;

import java.awt.event.*;

import java.sql.*;

public class App extends JFrame implements ActionListener {
	JMenuBar menuBar = MyMenuBar.create();
	JPanel IOScreen = MyIOScreen.create();

	App() {
		setTitle("SQL CRUD App");
		setSize(1000, 1000);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Adding events to MenuItems and SQL CRUD buttons
		addEvents();

		// Setting menuBar in JFrame
		setJMenuBar(menuBar);

		// Adding IOScreen to JFrame
		add(IOScreen);
	}

	public void addEvents() {
		MyMenuBar.insert.addActionListener(this);
		MyMenuBar.read.addActionListener(this);
		MyMenuBar.update.addActionListener(this);
		MyMenuBar.delete.addActionListener(this);

		MyAddForm.c.addActionListener(this);
		MyReadForm.r.addActionListener(this);
		MyUpdateForm.u.addActionListener(this);
		MyDeleteForm.d.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
			case "Add records":
				MyAddForm.flushAllTextFields();
				MyIOScreen.card.show(IOScreen, "addForm");
				break;

			case "Read records":
				MyReadForm.flushAllTextFields();
				MyIOScreen.card.show(IOScreen, "readForm");
				break;

			case "Update records":
				MyUpdateForm.flushAllTextFields();
				MyIOScreen.card.show(IOScreen, "updateForm");
				break;

			case "Delete records":
				MyDeleteForm.flushAllTextFields();
				MyIOScreen.card.show(IOScreen, "deleteForm");
				break;

			case "Add   Data":
				MyIOScreen.clearResultScreen();
				addData();
				break;

			case "Read   Data":
				MyIOScreen.clearResultScreen();
				readData();
				break;

			case "Update   Data":
				MyIOScreen.clearResultScreen();
				updateData();
				break;

			case "Delete   Data":
				MyIOScreen.clearResultScreen();
				deleteData();
				break;
		}
	}

	public void addData() {
		String fname = MyAddForm.addFirstNameData.getText();
		String lname = MyAddForm.addLastNameData.getText();
		String email = MyAddForm.addEmailData.getText();
		Create createObject = new Create();

		int x = 0;

		if ((fname.equals("") || lname.equals("") || email.equals(""))) {
			MyIOScreen.results[0].setText("Fill all the fields!");
		} else {
			try {
				x = createObject.insert(fname, lname, email);
			} catch (Exception e) {
				x = 0;
			}
			MyIOScreen.results[0].setText(x + " rows inserted");
		}

		MyIOScreen.card.show(IOScreen, "resultScreen");
	}

	public void readData() {
		Read readObject = new Read();
		String fname = MyReadForm.readFirstNameData.getText();
		String lname = MyReadForm.readLastNameData.getText();
		String email = MyReadForm.readEmailData.getText();
		int count = 0;
		String str1 = "", str2 = "", str3 = "";

		try {
			ResultSet x = readObject.read(fname, lname, email);

			while (x.next() && count < 10) {
				str1 = "First Name   =   " + x.getString("firstname");
				str2 = "Last Name   =   " + x.getString("lastname");
				str3 = "Email   =   " + x.getString("email");
				MyIOScreen.results[count].setText(str1 + "      " + str2 + "      " + str3);

				count++;
			}
		} catch (Exception e) {
		}

		if (count == 0) {
			MyIOScreen.results[0].setText("No records found");
		}

		MyIOScreen.card.show(IOScreen, "resultScreen");
	}

	public void updateData() {
		Update updateObject = new Update();
		String fname = MyUpdateForm.updateFirstNameData.getText();
		String lname = MyUpdateForm.updateLastNameData.getText();
		String email = MyUpdateForm.updateEmailData.getText();
		String newfname = MyUpdateForm.updateNewFirstNameData.getText();
		String newlname = MyUpdateForm.updateNewLastNameData.getText();
		String newemail = MyUpdateForm.updateNewEmailData.getText();

		if (newfname.equals("") && newlname.equals("") && newemail.equals("")) {
			MyIOScreen.results[0].setText("Nothing to change");
			MyIOScreen.results[1].setText("0 rows updated!");
		} else {
			int row = 0;
			try {
				row = updateObject.update(fname, lname, email, newfname, newlname, newemail);
			} catch (Exception e) {

			}
			MyIOScreen.results[0].setText(row + " rows updated!");
		}

		MyIOScreen.card.show(IOScreen, "resultScreen");
	}

	public void deleteData() {
		Delete deleteObject = new Delete();
		String fname = MyDeleteForm.deleteFirstNameData.getText();
		String lname = MyDeleteForm.deleteLastNameData.getText();
		String email = MyDeleteForm.deleteEmailData.getText();

		int row = 0;
		try {
			row = deleteObject.delete(fname, lname, email);
		} catch (Exception e) {

		}
		MyIOScreen.results[0].setText(row + " rows deleted!");

		MyIOScreen.card.show(IOScreen, "resultScreen");
	}

	public static void main(String[] args) throws Exception {
		new App();
	}
}