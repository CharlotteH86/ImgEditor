package imageEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Min class för att återgå till orgininalbilden.
public class BackToOriginal implements ActionListener {
	private JLabel labelWithImg;

	public BackToOriginal(JLabel labelWithImg) {
		this.labelWithImg = labelWithImg;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		original();
	}

	public void original() {

		String imageNew = "apple1.jpg";
		labelWithImg.setIcon(new ImageIcon(imageNew));

	}
}