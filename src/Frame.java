import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame{
	
	private JLabel imageLabel;
	private JTextField input;
	private JButton endButton;
	Game g;
	
	public Frame(String name) {
		this.setTitle(name);
		this.setSize(200, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		g = new Game();
		
		imageLabel = new JLabel();
		String letter = g.getLetterPath();
		ImageIcon image = new ImageIcon(letter);
		imageLabel.setIcon(image);
		this.add(imageLabel, BorderLayout.NORTH);
		
		input = new JTextField();
		input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				g.checkLetter(input.getText());
				input.setText("");
				String letter = g.getLetterPath();
				ImageIcon image = new ImageIcon(letter);
				imageLabel.setIcon(image);
				repaint();
				
			}
		});
		this.add(input, BorderLayout.CENTER);
		
		endButton = new JButton("End");
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				g.endGame();
				System.exit(0);	
			}
		});
		this.add(endButton, BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}
	
}
