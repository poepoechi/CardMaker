package bin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//string length 33;

public class CardPrinter{

  BufferedImage background;
  BufferedImage image;
  String title;
  String text;
  int textLocation;

  CardPrinter(BufferedImage background, BufferedImage cardImage, String title, String cardText){
    this.background = background;
    image = cardImage;
    this.title = title;
    text = cardText;
    textLocation = 254;
  }

  public void createCard(){
    Graphics2D card = background.createGraphics();
    card.setPaint(Color.BLACK);
    card.setFont(new Font("Arial", Font.BOLD, 14));
    card.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    card.drawString(title, 20, 75);
    card.drawImage(image, 16, 87, null);
    card.setFont(new Font("Arial", Font.PLAIN, 13));
    for(int i=0; i<text.length(); i+=35){
      if(i+35 > text.length()){
        card.drawString(text.substring(i, text.length()), 17, textLocation);
        System.out.println("if test");
      }else{
        card.drawString(text.substring(i, i+35), 17, textLocation);
        System.out.println("else test");
      }
      textLocation += 13;
    }
    card.dispose();
  }

  public BufferedImage returnCard(){
    return background;
  }
}
