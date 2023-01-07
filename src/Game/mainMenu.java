package Game;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class mainMenu extends JFrame{
	static int score ;
	static String convert;
	static String data ;
	static String name; 
	Scanner scan;
	JFrame frame ;
	public mainMenu(){
		
	}
	public mainMenu(int score) {
		this.score = score;
		this.convert = String.valueOf(score);
	}
	public void setName(String name) {this.name = name;} 
	public void writeFile() {
		File file = new File("Score.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	  
		try {
			BufferedWriter buf = new BufferedWriter(new FileWriter(file, true)); 
			buf.append(name+"/"+convert);
			buf.newLine();
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void extremeReadFile() {
		File file = new File("Score.txt");
		JTable table = new JTable();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String[] colSetname = {"Player profile ","Play Score History"};
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setColumnIdentifiers(colSetname);
			
			Object[] tableLines = br.lines().toArray();
			for(int i=0; i<tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split("/");
				model.addRow(dataRow);
			}
		}catch(Exception e) {
			System.out.println("this extreme Error!");
		}
		JScrollPane pane = new JScrollPane(table);
		frame = new JFrame("History");
		frame.setSize(500,250);
		frame.setVisible(true);
		frame.add(pane);
	}
	public void startGame() {
		this.add(new GamePanel());
		this.setTitle("Snake");	
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	public void pageDisplay() {
        new LaunchPage();
    }
}

