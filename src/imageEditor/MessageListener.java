package imageEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Första actionListener som sker när man klickar på knappen "Black & White".
public class MessageListener implements ActionListener {

	private JLabel labelWithImg;

	public MessageListener(JLabel labelWithImg) {
		this.labelWithImg = labelWithImg;
	}

//Metoden som aktiveras vid klick på knapp.
	@Override
	public void actionPerformed(ActionEvent ae) {

		BlackNWhite();
	}

	// Funktionen BlackNWhite används för att göra bilden svar och vit.
	public void BlackNWhite() {

		try {
			// Fil hämtas.
			File input = new File("apple1.jpg");

			// Bild läggs om BufferedImage
			BufferedImage image = ImageIO.read(input);

			BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(),
					BufferedImage.TYPE_BYTE_BINARY);

			// Bilden omvandlas till svart och vit genom nedan kod.
			Graphics2D graphic = result.createGraphics();
			graphic.drawImage(image, 0, 0, Color.WHITE, null);
			graphic.dispose();

			// Ny bild läggs ut och visas i bildfältet.
			File output = new File("appleBnW.jpg");
			ImageIO.write(result, "jpg", output);

		} catch (IOException e) {
			e.printStackTrace();
		}
		String imageNew = "applebnw.jpg";
		labelWithImg.setIcon(new ImageIcon(imageNew));

	}

}
