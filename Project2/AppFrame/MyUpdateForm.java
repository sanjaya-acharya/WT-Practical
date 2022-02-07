package AppFrame;

import javax.swing.*;

public class MyUpdateForm {
    // Items of Update_Data Form
	static JPanel updateForm = new JPanel();
	static JLabel updateNote1 = new JLabel("All Fields are optional");
	static JLabel updateFirstNameLabel = new JLabel("Old First Name");
	public static JTextField updateFirstNameData = new JTextField();
	static JLabel updateLastNameLabel = new JLabel("Old Last Name");
	public static JTextField updateLastNameData = new JTextField();
	static JLabel updateEmailLabel = new JLabel("Old Email");
	public static JTextField updateEmailData = new JTextField();
	static JLabel updateNote2 = new JLabel("Leave the fields empty if you want them unchanged");
	static JLabel updateNewFirstNameLabel = new JLabel("New First Name");
	public static JTextField updateNewFirstNameData = new JTextField();
	static JLabel updateNewLastNameLabel = new JLabel("New Last Name");
	public static JTextField updateNewLastNameData = new JTextField();
	static JLabel updateNewEmailLabel = new JLabel("New Email");
	public static JTextField updateNewEmailData = new JTextField();
	public static JButton u = new JButton("Update   Data");

	public static JPanel create() {
		createUpdateForm();
		flushAllTextFields();
		return updateForm;
	}

	private static void createUpdateForm() {
		updateForm.setLayout(null);

		updateNote1.setBounds(10, 30, 200, 20);

		updateFirstNameLabel.setBounds(10, 60, 200, 20);
		updateFirstNameData.setBounds(10, 80, 200, 30);

		updateLastNameLabel.setBounds(10, 130, 200, 20);
		updateLastNameData.setBounds(10, 150, 200, 30);

		updateEmailLabel.setBounds(10, 200, 200, 20);
		updateEmailData.setBounds(10, 220, 200, 30);

		updateNote2.setBounds(10, 270, 400, 20);

		updateNewFirstNameLabel.setBounds(10, 300, 200, 20);
		updateNewFirstNameData.setBounds(10, 320, 200, 30);

		updateNewLastNameLabel.setBounds(10, 370, 200, 20);
		updateNewLastNameData.setBounds(10, 390, 200, 30);

		updateNewEmailLabel.setBounds(10, 440, 200, 20);
		updateNewEmailData.setBounds(10, 460, 200, 30);

		u.setBounds(10, 510, 140, 30);

		updateForm.add(updateNote1);
		updateForm.add(updateFirstNameLabel);
		updateForm.add(updateLastNameLabel);
		updateForm.add(updateEmailLabel);

		updateForm.add(updateNote2);
		updateForm.add(updateNewFirstNameLabel);
		updateForm.add(updateNewLastNameLabel);
		updateForm.add(updateNewEmailLabel);

		updateForm.add(u);

		updateForm.add(updateFirstNameData);
		updateForm.add(updateLastNameData);
		updateForm.add(updateEmailData);

		updateForm.add(updateNewFirstNameData);
		updateForm.add(updateNewLastNameData);
		updateForm.add(updateNewEmailData);
	}

	public static void flushAllTextFields() {
		updateFirstNameData.setText("");
		updateLastNameData.setText("");
		updateEmailData.setText("");

		updateNewFirstNameData.setText("");
		updateNewLastNameData.setText("");
		updateNewEmailData.setText("");
	}

}