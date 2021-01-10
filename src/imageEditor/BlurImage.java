package imageEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Som tidigare använder jag samma sätt att implementera ActionListener.
public class BlurImage implements ActionListener {
	private JLabel labelWithImg;

	public BlurImage(JLabel labelWithImg) {
		this.labelWithImg = labelWithImg;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		blur();
	}

	public void blur() {
		try {
			// Fil hämtas igen, som tidigare. Med viss variation på kod.
			File input = new File("apple1.jpg");

			BufferedImage image = ImageIO.read(input);
			BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(),
					BufferedImage.TYPE_BYTE_INDEXED);

			// Bild görs om till suddig(blurry).
			Kernel kernel = new Kernel(3, 3,
					new float[] { 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f });
			BufferedImageOp op = new ConvolveOp(kernel);
			result = op.filter(image, null);

			// Samma procedur där jag skriver ut den nya bilden.
			File output = new File("appleblur.jpg");
			ImageIO.write(result, "jpg", output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String imageNew = "appleblur.jpg";
		labelWithImg.setIcon(new ImageIcon(imageNew));

	}

}
