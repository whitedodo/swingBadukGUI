/*
 * 		DrawBoard.java
 * 		Created By: Dodo(Rabbit.white@daum.net)
 * 		2017. 10. 22
 */

package Board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawBoard implements ActionListener {
	
	private int x;
	private int y;
	
	public final int STD_19 = 19;
	public final int STD_13 = 13;
	public final int STD_9 = 9;
	
	public final int ETC_17 = 17;
	public final int ETC_15 = 15;
	public final int ETC_11 = 11;
	public final int ETC_7 = 7;
	public final int ETC_4 = 4;
	
	private Dimension dim;

	private int size;
	private JButton[][] btnBaduk;
	private boolean[][] baduk;
	private BadukType type;
	private JPanel contentBoard;
	private String path;
	
	public DrawBoard( ) {
		
		dim = new Dimension();
		contentBoard = new JPanel();
		contentBoard.setBackground(Color.ORANGE);
		contentBoard.setBounds(10, 35, 0, 0);
		contentBoard.setLayout(null);
		
		this.type = BadukType.WHITE;
		this.size = 0;
		
	}
	
	public void setBoardSize( int size ) {
		
		switch ( size )
		{
			case STD_19:
				dim.setSize(560, 560);
				break;
				
			case STD_13:
				dim.setSize(400, 400);
				break;
				
			case STD_9:
				dim.setSize(290, 290);
				break;
				
			case ETC_17:
				dim.setSize(510, 510);
				break;
				
			case ETC_15:
				dim.setSize(455, 455);
				break;
				
			case ETC_11:
				dim.setSize(345, 345);
				break;
				
			case ETC_7:
				dim.setSize(235, 235);
				break;
				
			case ETC_4:
				dim.setSize(155, 155);
				break;
		}
		
		this.size = size;
		
	}
	
	public int getBoardSize() {
		return this.size;
	}
	
	public void createBoard() {
		
		btnBaduk = new JButton[ (int) ( getBoardSize() + 1) ] [ (int) ( getBoardSize() + 1) ];
		baduk = new boolean[ (int) ( getBoardSize() + 1) ] [ (int) ( getBoardSize() + 1) ];
		
		for ( int i = 0; i <= getBoardSize(); i++) {
			
			for ( int j = 0; j <= getBoardSize(); j++) {
				
				// 바둑알 놓기
				btnBaduk[i][j] = new JButton("");
				btnBaduk[i][j].setBounds( 23 + ( i * 27 ), 19 + ( j * 27 ), 5, 5 );
				btnBaduk[i][j].setBackground(new Color(153, 51, 0));
				btnBaduk[i][j].setBorderPainted(false);
				//btnBaduk[i][j].setContentAreaFilled(false);
				//btnBaduk[i][j].setFocusPainted(false);
				//btnBaduk[i][j].setOpaque(false);
				btnBaduk[i][j].setActionCommand( i + "," + j );
				btnBaduk[i][j].addActionListener( this );
				
				contentBoard.add(btnBaduk[i][j]);
				
				baduk[i][j] = false;
				
				if ( i < getBoardSize() && j < getBoardSize() )
				{
					JLabel baduk = new JLabel("");
					baduk.setBounds( 23 + ( i * 27 ), 16 + ( j * 27 ), 40, 40 );
					baduk.setIcon(new ImageIcon( getPath() + "\\BoardBlank.png"));
					contentBoard.add(baduk);
				} // end of if
				
			} // end of for
			
		} // end of for
		
		contentBoard.setBounds(12, 63, (int)dim.getWidth(), (int)dim.getHeight() );
		
	}
	
	public JPanel getContent() {
		return this.contentBoard;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		String tmp = arg0.getActionCommand();
		
		int x = Integer.parseInt( tmp.substring(0, tmp.indexOf(",") ) );
		int y = Integer.parseInt( tmp.substring( tmp.indexOf(",") + 1, tmp.length() ) );
		
		// 바둑알이 놓여졌을 때, 
		if ( baduk[x][y] ) {

			JOptionPane.showMessageDialog(null, "이미 바둑알이 놓여져 있습니다.");
			return;
		}
		
		// 바둑알 지정
		if ( type == BadukType.WHITE ) {
			btnBaduk[x][y].setIcon(new ImageIcon( getPath() + "\\BoardWhite.png"));
			type = BadukType.BLACK;
		}
		else {
			btnBaduk[x][y].setIcon(new ImageIcon( getPath() + "\\BoardBlack.png"));
			type = BadukType.WHITE;
		}
		
		// 바둑알 위치
		btnBaduk[x][y].setBounds( btnBaduk[x][y].getX() - 13, btnBaduk[x][y].getY() - 13, 30, 30);

		// 바둑알 이동 - 비활성화
		baduk[x][y] = true;
		
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
}
