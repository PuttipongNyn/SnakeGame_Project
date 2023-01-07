package Game;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LaunchPage extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchPage frame = new LaunchPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LaunchPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setResizable(false);
		setBounds(320, 150, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				mainMenu main = new mainMenu();
				main.startGame();
				dispose();

				
			}
		});
		btnStart.setFont(new Font("Ink Free", Font.BOLD, 30));
		btnStart.setBounds(100, 111, 202, 99);
		contentPane.add(btnStart);
		
		JButton btnHScore = new JButton("Score");
		btnHScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainMenu main = new mainMenu();
				main.extremeReadFile();
			}
		});
		btnHScore.setFont(new Font("Ink Free", Font.BOLD, 30));
		btnHScore.setBounds(100, 313, 202, 99);
		contentPane.add(btnHScore);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to exit a game?","Exit",JOptionPane.YES_NO_OPTION)== 0) {
					mainMenu mm = new mainMenu();
					mm.dispose();
					dispose();
				}
			}
		});
		btnExit.setFont(new Font("Ink Free", Font.BOLD, 30));
		btnExit.setBounds(100, 504, 202, 99);
		contentPane.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 410, 681);
		contentPane.add(panel);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBackground(Color.WHITE);
		paneMainContent.setBounds(420, 11, 834, 659);
		contentPane.add(paneMainContent);
		paneMainContent.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the funniest");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setForeground(new Color(204, 51, 51));
		lblWelcomeToThe.setFont(new Font("Ink Free", Font.BOLD, 60));
		lblWelcomeToThe.setBounds(10, -26, 814, 202);
		paneMainContent.add(lblWelcomeToThe);
		
		JLabel lblSnakeGame = new JLabel("SNAKE GAME!");
		lblSnakeGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnakeGame.setForeground(new Color(204, 51, 51));
		lblSnakeGame.setFont(new Font("Ink Free", Font.BOLD, 60));
		lblSnakeGame.setBounds(10, 61, 814, 202);
		paneMainContent.add(lblSnakeGame);
		
		JLabel lbl_PicSnake = new JLabel("");
		lbl_PicSnake.setIcon(new ImageIcon(LaunchPage.class.getResource("/PNG/picture_snake.jpg")));
		lbl_PicSnake.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PicSnake.setBounds(10, 224, 814, 424);
		paneMainContent.add(lbl_PicSnake);

	}
	

}
