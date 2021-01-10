package imageEditor;

import javax.swing.SwingUtilities;

//Startar upp programmet
public class Main {

	public static void main(String[] args) {
		ImagesProject ui = new ImagesProject();
		SwingUtilities.invokeLater((Runnable) ui);

	}

}