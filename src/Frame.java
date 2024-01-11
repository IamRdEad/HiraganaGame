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
	private JButton checkButton;
	private JButton endButton;
	private JPanel buttonPanel;
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
		this.add(input, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		checkButton = new JButton("Check");
		checkButton.addActionListener(new ActionListener() {
			
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
		buttonPanel.add(checkButton);
		endButton = new JButton("End");
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				g.endGame();
				System.exit(0);	
			}
		});
		buttonPanel.add(endButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
}
