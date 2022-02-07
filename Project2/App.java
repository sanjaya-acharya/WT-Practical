import javax.swing.*;

import AppFrame.*;
import SQLCommands.*;

import java.awt.event.*;

import java.sql.*;

public class App extends JFrame implements ActionListener {
	JMenuBar menuBar = MyMenuBar.create();
	JPanel IOScreen = IOResultsJPanel.create();

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

		CreateJPanel.c.addActionListener(this);
		ReadJPanel.r.addActionListener(this);
		MyUpdateForm.u.addActionListener(this);
		DeleteJPanel.d.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
			case "Add records":
				CreateJPanel.flushAllTextFields();
				IOResultsJPanel.card.show(IOScreen, "addForm");
				break;

			case "Read records":
				ReadJPanel.flushAllTextFields();
				IOResultsJPanel.card.show(IOScreen, "readForm");
				break;

			case "Update records":
				MyUpdateForm.flushAllTextFields();
				IOResultsJPanel.card.show(IOScreen, "updateForm");
				break;

			case "Delete records":
				DeleteJPanel.flushAllTextFields();
				IOResultsJPanel.card.show(IOScreen, "deleteForm");
				break;

			case "Add   Data":
				IOResultsJPanel.clearResultScreen();
				addData();
				break;

			case "Read   Data":
				IOResultsJPanel.clearResultScreen();
				readData();
				break;

			case "Update   Data":
				IOResultsJPanel.clearResultScreen();
				updateData();
				break;

			case "Delete   Data":
				IOResultsJPanel.clearResultScreen();
				deleteData();
				break;
		}
	}

	public void addData() {
		String fname = CreateJPanel.addFirstNameData.getText();
		String lname = CreateJPanel.addLastNameData.getText();
		String email = CreateJPanel.addEmailData.getText();
		Create createObject = new Create();

		int x = 0;

		if ((fname.equals("") || lname.equals("") || email.equals(""))) {
			IOResultsJPanel.results[0].setText("Fill all the fields!");
		} else {
			try {
				x = createObject.insert(fname, lname, email);
			} catch (Exception e) {
				x = 0;
			}
			IOResultsJPanel.results[0].setText(x + " rows inserted");
		}

		IOResultsJPanel.card.show(IOScreen, "resultScreen");
	}

	public void readData() {
		Read readObject = new Read();
		String fname = ReadJPanel.readFirstNameData.getText();
		String lname = ReadJPanel.readLastNameData.getText();
		String email = ReadJPanel.readEmailData.getText();
		int count = 0;
		String str1 = "", str2 = "", str3 = "";

		try {
			ResultSet x = readObject.read(fname, lname, email);

			while (x.next() && count < 10) {
				str1 = "First Name   =   " + x.getString("firstname");
				str2 = "Last Name   =   " + x.getString("lastname");
				str3 = "Email   =   " + x.getString("email");
				IOResultsJPanel.results[count].setText(str1 + "      " + str2 + "      " + str3);

				count++;
			}
		} catch (Exception e) {
		}

		if (count == 0) {
			IOResultsJPanel.results[0].setText("No records found");
		}

		IOResultsJPanel.card.show(IOScreen, "resultScreen");
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
			IOResultsJPanel.results[0].setText("Nothing to change");
			IOResultsJPanel.results[1].setText("0 rows updated!");
		} else {
			int row = 0;
			try {
				row = updateObject.update(fname, lname, email, newfname, newlname, newemail);
			} catch (Exception e) {

			}
			IOResultsJPanel.results[0].setText(row + " rows updated!");
		}

		IOResultsJPanel.card.show(IOScreen, "resultScreen");
	}

	public void deleteData() {
		Delete deleteObject = new Delete();
		String fname = DeleteJPanel.deleteFirstNameData.getText();
		String lname = DeleteJPanel.deleteLastNameData.getText();
		String email = DeleteJPanel.deleteEmailData.getText();

		int row = 0;
		try {
			row = deleteObject.delete(fname, lname, email);
		} catch (Exception e) {

		}
		IOResultsJPanel.results[0].setText(row + " rows deleted!");

		IOResultsJPanel.card.show(IOScreen, "resultScreen");
	}

	public static void main(String[] args) throws Exception {
		new App();
	}
}