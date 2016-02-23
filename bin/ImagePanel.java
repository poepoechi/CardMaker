package bin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.io.InputStream;

public class ImagePanel extends JPanel{

	private BufferedImage image;

	ImagePanel(String fileName){
		try{
			//System.out.println(ImagePanel.class.getResource("Images" + File.separator +  fileName));
			InputStream file = this.getClass().getResourceAsStream(File.separator + "Images" + File.separator + fileName);
			image = ImageIO.read(file);
		} catch(IOException ex){
			ex.printStackTrace();
			System.out.println("IO error");
		}
	}

	ImagePanel(BufferedImage card){
		image = card;
	}

	public BufferedImage getImage(){
		return image;
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
