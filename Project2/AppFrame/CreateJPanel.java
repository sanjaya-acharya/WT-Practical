package AppFrame;

import javax.swing.*;

public class CreateJPanel {
	// Items of Create_New_Record Form
	static JPanel addForm = new JPanel();
	static JLabel addNote = new JLabel("All Fields are mandatory");
	public static JTextField addFirstNameData = new JTextField();
	static JLabel addFirstNameLabel = new JLabel("First Name");
	public static JTextField addLastNameData = new JTextField();
	static JLabel addLastNameLabel = new JLabel("Last Name");
	public static JTextField addEmailData = new JTextField();
	static JLabel addEmailLabel = new JLabel("Email");
	public static JButton c = new JButton("Add   Data");

	public static JPanel create() {
		createAddForm();
		flushAllTextFields();
		return addForm;
	}

	private static void createAddForm() {
		addForm.setLayout(null);

		addNote.setBounds(10, 30, 200, 20);

		addFirstNameLabel.setBounds(10, 60, 100, 20);

		addFirstNameData.setBounds(10, 80, 200, 30);

		addLastNameLabel.setBounds(10, 130, 100, 20);
		addLastNameData.setBounds(10, 150, 200, 30);

		addEmailLabel.setBounds(10, 200, 100, 20);
		addEmailData.setBounds(10, 220, 200, 30);

		c.setBounds(10, 260, 120, 30);

		addForm.add(addNote);
		addForm.add(addFirstNameLabel);
		addForm.add(addLastNameLabel);
		addForm.add(addEmailLabel);
		addForm.add(c);
		addForm.add(addFirstNameData);
		addForm.add(addLastNameData);
		addForm.add(addEmailData);
	}

	public static void flushAllTextFields() {
		addFirstNameData.setText("");
		addLastNameData.setText("");
		addEmailData.setText("");
	}
}