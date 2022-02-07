package AppFrame;

import javax.swing.*;

public class MyMenuBar{
	public static JMenuBar menuBar = new JMenuBar();
	public static JMenuItem insert = new JMenuItem("Add records");
	public static JMenuItem read = new JMenuItem("Read records");
	public static JMenuItem update = new JMenuItem("Update records");
	public static JMenuItem delete = new JMenuItem("Delete records");

	public static JMenuBar create() {
		// Add menu to the menuBar
		menuBar.add(insert);
		menuBar.add(read);
		menuBar.add(update);
		menuBar.add(delete);
		
		return menuBar;
	}
}