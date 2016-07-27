package bin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRetriever extends JPanel{

	private static JFileChooser fileChooser;
	private static BufferedImage image;
	private static Image image2;

	ImageRetriever(){
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

		int value = fileChooser.showOpenDialog(this);
		if(value == JFileChooser.APPROVE_OPTION){
			try {
				image = ImageIO.read(fileChooser.getSelectedFile());
			} catch (IOException e) {
				System.out.println("IO Error");
			}
		}
	}

	public static BufferedImage toBufferedImage(Image img){

    // Create a buffered image with transparency
    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    // Return the buffered image
    return bimage;
}

	public static BufferedImage getImage(){
		if(image.getHeight() != 223 && image.getWidth() != 150){
			image2 = image.getScaledInstance(223,150,Image.SCALE_SMOOTH);
			image = toBufferedImage(image2);
		}
		return image;
	}
}
