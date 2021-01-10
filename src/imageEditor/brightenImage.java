package imageEditor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class brightenImage implements ActionListener {

	static JLabel labelWithImg;
	private JTextArea origin;
	private JTextArea destination;
	


	public brightenImage(JLabel labelWithImg) {
		this.labelWithImg = labelWithImg;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		
		adjustBrightness();
	}
	
	  public static void adjustBrightness() {
			try {
				
				File input = new File("apple1.jpg");
				
				BufferedImage image = ImageIO.read(input);
				BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
				


		    RescaleOp op = new RescaleOp(1.8f, 0, null);
		    result = op.filter(image, null);
		    
			File output = new File("appleBright.jpg");
			ImageIO.write(result, "jpg", output);}
			catch (IOException e) {
				e.printStackTrace();
		    }		String imageNew = "appleBright.jpg";
			labelWithImg.setIcon(new ImageIcon(imageNew));
	  }

}