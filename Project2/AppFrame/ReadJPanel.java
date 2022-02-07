package AppFrame;

import javax.swing.*;

public class ReadJPanel {
	// Items of Read_Data Form
	static JPanel readForm = new JPanel();
	static JLabel readNote = new JLabel("All Fields are optional");
	static JLabel readFirstNameLabel = new JLabel("First Name");
	public static JTextField readFirstNameData = new JTextField();
	static JLabel readLastNameLabel = new JLabel("Last Name");
	public static JTextField readLastNameData = new JTextField();
	static JLabel readEmailLabel = new JLabel("Email");
	public static JTextField readEmailData = new JTextField();
	public static JButton r = new JButton("Read   Data");

	public static JPanel create() {
		createReadForm();
		flushAllTextFields();
		return readForm;
	}

	private static void createReadForm() {
		readForm.setLayout(null);

		readNote.setBounds(10, 30, 200, 20);

		readFirstNameLabel.setBounds(10, 60, 100, 20);

		readFirstNameData.setBounds(10, 80, 200, 30);

		readLastNameLabel.setBounds(10, 130, 100, 20);
		readLastNameData.setBounds(10, 150, 200, 30);

		readEmailLabel.setBounds(10, 200, 100, 20);
		readEmailData.setBounds(10, 220, 200, 30);

		r.setBounds(10, 260, 120, 30);

		readForm.add(readNote);
		readForm.add(readFirstNameLabel);
		readForm.add(readLastNameLabel);
		readForm.add(readEmailLabel);
		readForm.add(r);
		readForm.add(readFirstNameData);
		readForm.add(readLastNameData);
		readForm.add(readEmailData);
	}

	public static void flushAllTextFields() {
		readFirstNameData.setText("");
		readLastNameData.setText("");
		readEmailData.setText("");
	}
}