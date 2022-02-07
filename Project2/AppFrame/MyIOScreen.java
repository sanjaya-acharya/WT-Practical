package AppFrame;

import javax.swing.*;
import java.awt.*;

public class MyIOScreen {
	public static CardLayout card = new CardLayout();
	static JPanel IOScreen = new JPanel(card);

	static JPanel resultScreen = new JPanel();
	static JPanel[] rp = new JPanel[10];
	public static JLabel[] results = new JLabel[10];
	
	
	public static JPanel create() {
		setIOScreen();
        return IOScreen;
    }
	
	private static void setIOScreen() {
		IOScreen.setLayout(card);
		
		// Setting Results screen
		for (int i = 0; i < 10; i++) {
			rp[i] = new JPanel();
			results[i] = new JLabel();

			rp[i].add(results[i]);
			resultScreen.add(rp[i]);
		}
		IOScreen.add(resultScreen, "resultScreen");
		resultScreen.setLayout(new GridLayout(10, 1));

		// Setting Forms
		IOScreen.add(MyAddForm.create(), "addForm");
		IOScreen.add(MyReadForm.create(), "readForm");
		IOScreen.add(MyUpdateForm.create(), "updateForm");
		IOScreen.add(MyDeleteForm.create(), "deleteForm");
	}

	public static void clearResultScreen() {
		for (int i = 0; i < 10; i++) {
			results[i].setText("");
		}
	}
}
