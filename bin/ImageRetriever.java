package CardMaker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRetriever extends JPanel{
	
	private static JFileChooser fileChooser;
	private static BufferedImage image;

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

	public static BufferedImage getImage(){
		return image;
	}

}
