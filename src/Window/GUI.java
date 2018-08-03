/*
 * 		GUI.java
 * 		Created By: Dodo
 * 		2017. 10. 22
 */

package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Board.DrawBoard;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel contentBoard;
	private DrawBoard drawBoard;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Baduk/Omok Board - 프로그램");
		initComponents();
		createObjects();
	}
	
	public void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 680);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//contentPane.add(contentBoard);
	}
	
	public void createObjects() {
		drawBoard = new DrawBoard();
		drawBoard.setPath( System.getProperty("user.dir") );
		drawBoard.setBoardSize( 19 );
		drawBoard.createBoard();
		
		this.contentBoard =  drawBoard.getContent();
		contentPane.add(contentBoard);
		this.contentBoard.repaint();
	}
	
}
