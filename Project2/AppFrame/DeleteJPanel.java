package AppFrame;

import javax.swing.*;

public class DeleteJPanel {
	// Items of Delete_Data Form
	static JPanel deleteForm = new JPanel();
	static JLabel deleteNote = new JLabel("All Fields are optional");
	static JLabel deleteFirstNameLabel = new JLabel("First Name");
	public static JTextField deleteFirstNameData = new JTextField();
	static JLabel deleteLastNameLabel = new JLabel("Last Name");
	public static JTextField deleteLastNameData = new JTextField();
	static JLabel deleteEmailLabel = new JLabel("Email");
	public static JTextField deleteEmailData = new JTextField();
	public static JButton d = new JButton("Delete   Data");

	public static JPanel create() {
		createDeleteForm();
		flushAllTextFields();
		return deleteForm;
	}

	private static void createDeleteForm() {
		deleteForm.setLayout(null);

		deleteNote.setBounds(10, 30, 200, 20);

		deleteFirstNameLabel.setBounds(10, 60, 100, 20);
		deleteFirstNameData.setBounds(10, 80, 200, 30);

		deleteLastNameLabel.setBounds(10, 130, 100, 20);
		deleteLastNameData.setBounds(10, 150, 200, 30);

		deleteEmailLabel.setBounds(10, 200, 100, 20);
		deleteEmailData.setBounds(10, 220, 200, 30);

		d.setBounds(10, 260, 130, 30);

		deleteForm.add(deleteNote);
		deleteForm.add(deleteFirstNameLabel);
		deleteForm.add(deleteLastNameLabel);
		deleteForm.add(deleteEmailLabel);
		deleteForm.add(d);
		deleteForm.add(deleteFirstNameData);
		deleteForm.add(deleteLastNameData);
		deleteForm.add(deleteEmailData);
	}

	public static void flushAllTextFields() {
		deleteFirstNameData.setText("");
		deleteLastNameData.setText("");
		deleteEmailData.setText("");
	}
}