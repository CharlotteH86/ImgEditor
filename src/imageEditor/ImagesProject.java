package imageEditor;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

//Här är det som körs i programmet. Utseende i form av knappar och layout.
public class ImagesProject implements Runnable {
	private JFrame frame;
	JPanel panel = new JPanel();

	public ImagesProject() {

	}

	@Override
	public void run() {
		frame = new JFrame("Picture Editor");
		frame.setPreferredSize(new Dimension(1500, 1500));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		createComponents(frame.getContentPane());

	}

	// De komponenter som ingår, Knappar och deras kopplingar the actionListerner.
	private void createComponents(Container container) {

		GridLayout layout = new GridLayout(2, 3);
		container.setLayout(layout);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("apple1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel labelWithImg = new JLabel(new ImageIcon(image));
		container.add(labelWithImg);

		JButton btnBlackNWhite = new JButton("Black & White");
		MessageListener btnBnW = new MessageListener(labelWithImg);
		btnBlackNWhite.addActionListener(btnBnW);
		container.add(btnBlackNWhite);

		JButton bright = new JButton("Brighten Image");
		brightenImage brightImg = new brightenImage(labelWithImg);
		bright.addActionListener(brightImg);
		container.add(bright);

		JButton blur = new JButton("Blur Image");
		BlurImage blurImg = new BlurImage(labelWithImg);
		blur.addActionListener(blurImg);
		container.add(blur);

		JButton original = new JButton("Original picture");
		BackToOriginal org = new BackToOriginal(labelWithImg);
		original.addActionListener(org);
		container.add(original);

	}

	public JFrame getFrame() {
		return frame;
	}

}
