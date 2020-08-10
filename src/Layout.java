
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Layout extends JFrame{
	
	public Layout(String title) {
		super(title);
		this.setSize(700, 300);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel imgLabel = new JLabel(new ImageIcon("C:\\Users\\Faizan\\Pictures"));
		
		JButton buttonH = new JButton("Home");
		JButton button1 = new JButton("Check In");
		JButton button2 = new JButton("Calculate Fees");
		JButton button5 = new JButton("Search Member");
		JButton button6 = new JButton("See All Members");
		JButton button7 = new JButton("Add");
		JButton button8 = new JButton("Remove");

		
		Container mainContainer = this.getContentPane();
		mainContainer.setLayout(new BorderLayout(8,6));
		mainContainer.setBackground(Color.YELLOW);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,  Color.GREEN));
		
		//Panel Top
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(Color.BLACK, 3));
		topPanel.setBackground(Color.ORANGE);
		topPanel.setLayout(new FlowLayout(5));
		
		topPanel.add(button1);
		topPanel.add(button2);

		mainContainer.add(topPanel, BorderLayout.NORTH);
		
		//middle panel
		JPanel middlePanel = new JPanel();
		middlePanel.setBorder(new LineBorder(Color.BLACK,3));
		middlePanel.setLayout(new FlowLayout(4,4,4));
		middlePanel.setBackground(Color.CYAN);
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(4,1,5,5));
		gridPanel.setBorder(new LineBorder(Color.BLACK, 3));
		gridPanel.setBackground(Color.RED);
		
		gridPanel.add(button5);
		gridPanel.add(button6);
		gridPanel.add(button7);
		gridPanel.add(button8);
		
		JLabel label = new JLabel("Center Box", SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBorder(new LineBorder(Color.BLACK, 3));
		
		middlePanel.add(gridPanel);
		mainContainer.add(label);
		mainContainer.add(middlePanel, BorderLayout.WEST);
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Layout mylayout = new Layout("My Custom Layout");
		mylayout.setVisible(true);
	}

}
