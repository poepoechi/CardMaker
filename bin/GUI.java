package bin;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GUI extends JFrame{

	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;

	private static final String IMAGE = "Status.jpg"; 
	private ImagePanel card;
	private ImagePanel cardImage = null;

	private String cardTitle = "Title comes here";
	private String cardText = "Card text comes here";

	private JLayeredPane layeredPane;

	public GUI(){
		super("4chan card maker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		System.out.println(IMAGE);
		createLayout();
	}

	public void createLayout(){
		setLayout(new BorderLayout());

		layeredPane = new JLayeredPane();
		layeredPane.setSize(new Dimension(400, 500));

		getCard(IMAGE);

		add(layeredPane, BorderLayout.CENTER);
	}

	public void getCard(String imageString){
		card = new ImagePanel(imageString);
		redraw();
	}

	public void getCardImage(BufferedImage image){
		cardImage = new ImagePanel(image);
		redraw();
	}

	public void getCardTitle(){
		cardTitle = JOptionPane.showInputDialog("Enter card title:");
		redraw();
	}

	public void getCardText(){
		cardText = JOptionPane.showInputDialog("text: ");
		redraw();
	}

	public void changeCard(){
		card.setSize(layeredPane.getPreferredSize());
		card.setBounds(63, 50, 255, 341);
		layeredPane.add(card, JLayeredPane.DEFAULT_LAYER);
	}

	public void addCardImage(){
		cardImage.setSize(layeredPane.getPreferredSize());
		cardImage.setBounds(79, 137, 223, 150);
		cardImage.setOpaque(false);
		layeredPane.add(cardImage, JLayeredPane.PALETTE_LAYER);
	}

	public void addCardTitle(){
		JLabel text = new JLabel(cardTitle);
		text.setSize(layeredPane.getPreferredSize());
		text.setBounds(81,100,220,50);
		text.setFont(new Font("Arial", Font.BOLD, 14));
		layeredPane.add(text, JLayeredPane.MODAL_LAYER);
	}


	public void addCardText(){
		JTextArea text = new JTextArea(cardText);
		text.setBounds(81, 285, 220, 100);
		text.setLineWrap(true);
		text.setBackground(new Color(0,0,0,0));
		text.setFont(new Font("Arial", Font.BOLD, 12));
		layeredPane.add(text, JLayeredPane.POPUP_LAYER);

	}

	public void redraw(){
		layeredPane.removeAll();
		changeCard();
		if(cardImage != null){
			addCardImage();
		}
		addCardTitle();
		addCardText();
	}

	public void drawImage(){
		if(cardImage == null){
			JOptionPane.showMessageDialog(null, "Add a card image first");
			return;
		}
		String cardName = JOptionPane.showInputDialog("Enter savefile name:");
		CardPrinter cardPrinter = new CardPrinter(card.getImage(), cardImage.getImage(), cardTitle, cardText);
		cardPrinter.createCard();
		BufferedImage toSave = cardPrinter.returnCard();
		File output = new File(cardName + ".png");
		try{
			ImageIO.write(toSave, "png", output);
		} catch(IOException e) {
			System.out.println("dun goofed m8");
		}
	}

}
