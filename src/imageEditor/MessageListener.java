package imageEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//F�rsta actionListener som sker n�r man klickar p� knappen "Black & White".
public class MessageListener implements ActionListener {

	private JLabel labelWithImg;

	public MessageListener(JLabel labelWithImg) {
		this.labelWithImg = labelWithImg;
	}

//Metoden som aktiveras vid klick p� knapp.
	@Override
	public void actionPerformed(ActionEvent ae) {

		BlackNWhite();
	}

	// Funktionen BlackNWhite anv�nds f�r att g�ra bilden svar och vit.
	public void BlackNWhite() {

		try {
			// Fil h�mtas.
			File input = new File("apple1.jpg");

			// Bild l�ggs om BufferedImage
			BufferedImage image = ImageIO.read(input);

			BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(),
					BufferedImage.TYPE_BYTE_BINARY);

			// Bilden omvandlas till svart och vit genom nedan kod.
			Graphics2D graphic = result.createGraphics();
			graphic.drawImage(image, 0, 0, Color.WHITE, null);
			graphic.dispose();

			// Ny bild l�ggs ut och visas i bildf�ltet.
			File output = new File("appleBnW.jpg");
			ImageIO.write(result, "jpg", output);

		} catch (IOException e) {
			e.printStackTrace();
		}
		String imageNew = "applebnw.jpg";
		labelWithImg.setIcon(new ImageIcon(imageNew));

	}

}
