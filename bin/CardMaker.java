package bin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//Picture should be 223*150

public class CardMaker{

	private GUI gui;

	CardMaker(){
		gui = new GUI();
	}

	public void start(){
		gui.add(createButtons(), BorderLayout.PAGE_END);
		gui.setJMenuBar(createBar());
		gui.setVisible(true);
	}

	public JPanel createButtons(){
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,4));

		JButton button1 = new JButton("add image");
		button1.addActionListener(new ImageAdder());
		JButton button2 = new JButton("add title");
		button2.addActionListener(new TitleAdder());
		JButton button3 = new JButton("add text");
		button3.addActionListener(new TextAdder());
		JButton button4 = new JButton("save");
		button4.addActionListener(new Saver());

		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);

		return buttonPanel;
	}

	public JMenuBar createBar(){
		JMenuBar result = new JMenuBar();
		JMenu templateMenu = new JMenu("Choose Layout");

		JMenuItem action = new JMenuItem("Action card");
		action.addActionListener(new ActionEar());
		templateMenu.add(action);

		JMenuItem mandatory = new JMenuItem("Mandatory card");
		mandatory.addActionListener(new MandatoryEar());
		templateMenu.add(mandatory);

		JMenuItem status = new JMenuItem("status card");
		status.addActionListener(new StatusEar());
		templateMenu.add(status);

		JMenuItem instant = new JMenuItem("instant card");
		instant.addActionListener(new InstantEar());
		templateMenu.add(instant);

		result.add(templateMenu);
		return result;
	}

	public class ImageAdder implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new ImageRetriever();
			gui.getCardImage(ImageRetriever.getImage());
		}
	}

	public class TitleAdder implements ActionListener{

		public void actionPerformed(ActionEvent e){
			gui.getCardTitle();
		}
	}

	public class TextAdder implements ActionListener{

		public void actionPerformed(ActionEvent e){
			gui.getCardText();
		}
	}

	public class Saver implements ActionListener{

		public void actionPerformed(ActionEvent e){
			gui.drawImage();
		}
	}

	public class ActionEar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			gui.getCard(System.getProperty("user.dir") + File.separator + "bin" + File.separator + "Images" + File.separator + "Action template.jpg");
		}
	}

	public class MandatoryEar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			gui.getCard(System.getProperty("user.dir") + File.separator + "bin" + File.separator + "Images" + File.separator + "Mandatory template.jpg");
		}
	}

	public class StatusEar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			gui.getCard(System.getProperty("user.dir") + File.separator + "bin" + File.separator + "Images" + File.separator + "Status template.jpg");
		}
	}

	public class InstantEar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			gui.getCard(System.getProperty("user.dir") + File.separator + "bin" + File.separator + "Images" + File.separator + "Instant template.jpg");
		}
	}

	public static void main(String[] args){
		new CardMaker().start();
	}
}
