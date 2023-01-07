package Game;


import java.awt.BorderLayout;
import javax.swing.JFrame;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.tools.javac.Main;

import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ExitPanel extends JFrame {
	

	static int score;
	private JPanel contentPane;
	static mainMenu restart = new mainMenu(); 

	public void setScocre(int score){
		this.score = score;
	}
	
	public  ExitPanel() {
		setUndecorated(true);	
		setBounds(510, 200, 834, 659);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		
		JButton btnExit = new JButton("Exit\r\n");
		btnExit.addActionListener(e -> {
			JFrame frame = new JFrame("EXIT");
			if(JOptionPane.showConfirmDialog(frame,"Confirm if you want Exit","EXIT",
					JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
			{
				System.exit(0);
			}
		});
		
		JButton btnBackToMenu = new JButton("Back To Menu\r\n");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LaunchPage lp = new LaunchPage();
				lp.show();
				setVisible(false);
				 				 					
			}
		});
		
		JButton btnRestart = new JButton("Restart \r\n");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				restart.startGame();
				setVisible(false);
				
			}
			
		});
		
		JLabel lblTextGameover = new JLabel("Game Over");
		lblTextGameover.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextGameover.setForeground(Color.RED);
		lblTextGameover.setFont(new Font("Ink Free", Font.BOLD, 99));
		
		JLabel lblScore = new JLabel("Score : "+score);
		
		lblScore.setForeground(Color.RED);
		lblScore.setFont(new Font("Ink Free", Font.BOLD, 80));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(btnBackToMenu, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(152)
					.addComponent(btnRestart, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTextGameover, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblScore, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(159, Short.MAX_VALUE)
					.addComponent(lblScore)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTextGameover, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBackToMenu, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRestart, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

}

