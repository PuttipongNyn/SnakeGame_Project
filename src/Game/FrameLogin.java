package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Button;

public class FrameLogin extends JFrame {

	//private Image img_Logo = new ImageIcon(FrameLogin.class.getResource("PNG/Snake.png")).getImage().getScaledInstance(600,700, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtName;
	private JLabel lblStart;
	private JLabel lblX;
	private JLabel lblLogo;
	private JLabel lblMes;
	private JLabel lbl_IconStart;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(152, 187, 295, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtName.getText().equals("Name")) {
					txtName.setText("");
				}
				else {
					txtName.selectAll();
				}
			}
		});
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("Ink Free", Font.BOLD, 26));
		txtName.setText("Name");
		txtName.setBounds(10, 11, 275, 52);
		panel.add(txtName);
		txtName.setColumns(10);
		
		lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblX.setBounds(573, 11, 17, 14);
		contentPane.add(lblX);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(152, 33, 295, 141);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(FrameLogin.class.getResource("/PNG/Snake3.png")));
		
		lblMes = new JLabel("");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setBounds(162, 272, 285, 25);
		contentPane.add(lblMes);
		
		lblStart = new JLabel("Start");
		lblStart.setBounds(216, 308, 164, 59);
		contentPane.add(lblStart);
		
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setFont(new Font("Ink Free", Font.BOLD, 26));
		
		lbl_IconStart = new JLabel("");
		lbl_IconStart.setIcon(new ImageIcon("C:\\Users\\Atlentia\\Desktop\\Start.png"));
		lbl_IconStart.setBounds(216, 309, 164, 58);
		contentPane.add(lbl_IconStart);
		lblStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtName.getText().equals("")) {
					lblMes.setText("Plese input you name");
				}else {
					String name = txtName.getText();

					LaunchPage lp = new LaunchPage();
					
					mainMenu wr = new mainMenu();
					wr.setName(name);
					
					lp.show();
					dispose();
				}
			}		
		});
		lblStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtName.getText().equals("")) {
					JOptionPane.showConfirmDialog(null, "Plese input you name", "", JOptionPane.DEFAULT_OPTION);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblStart.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				lblStart.setForeground(Color.BLACK);
			}
		});
		
		setLocationRelativeTo(null);
	}
}
