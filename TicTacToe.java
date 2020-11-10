package Practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame{
	
	private GridLayout layout;
	
	private Practice.TicTacToe.panel panel;
	private JPanel north, n1,n2,n3;
	private JPanel top1,top2, bot1,bot2;
	private static JButton[] buttons;
	private static JButton restart,addP1,addP2;
	
	private static ImageIcon X,O,blank;
	private static JLabel p1,p2;
	
	public static int Width;
	public static int Height;
	
	public static int mark;
	public static int p1Pts,p2Pts;
	
	
	//				******				*****			*****
	
	
	public TicTacToe() {
		super("Tac Tac Toe Game");
		this.setSize(600,600); 
		
		layout = new GridLayout(3,3,5,5);
		
		panel = new panel();
		panel.setLayout(layout);
		add(panel);
		
		north = new JPanel();
		top1 = new JPanel();
		top2 = new JPanel();
		bot1 = new JPanel();
		bot2 = new JPanel();
		n1 = new JPanel();
		n2 = new JPanel();
		n3 = new JPanel();
		north.add(n1);
		north.add(n2);
		north.add(n3);
		add(north,BorderLayout.NORTH);
		
		north.setLayout(new GridLayout(0,3));
		north.repaint();
		n1.setLayout(new GridLayout(2,0));
		n3.setLayout(new GridLayout(2,0));
		n1.add(top1);
		n1.add(bot1);
		n3.add(top2);
		n3.add(bot2);
		
		Width = this.getWidth();
		Height = this.getHeight();
		System.out.println(Width);
		
		mark = 0;
		p1Pts = 0;
		p2Pts = 0;
		
		blank = new ImageIcon(getClass().getResource("Blank.jpg"));
		O = new ImageIcon(getClass().getResource("O.jpg"));
		X = new ImageIcon(getClass().getResource("X.jpg"));
		
		buttons = new JButton[9];
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(blank);
			buttons[i].addActionListener(new Handler());
			panel.add(buttons[i]);
		}
		
		restart = new JButton("Restart");
		restart.addActionListener(new Clear());
		n2.add(restart);
		
		p1 = new JLabel("Player 1: " + p1Pts);
		p2 = new JLabel("Player 2: " + p2Pts);
		top1.add(p1);
		top2.add(p2);
		
		addP1 = new JButton("Add To P1");
		addP2 = new JButton("Add To P2");
		addP1.addActionListener(new addPts());
		addP2.addActionListener(new addPts());
		bot1.add(addP1);
		bot2.add(addP2);
	}
	
	
	
	//		****				****					******			*******
	
	
	private class panel extends JPanel{
	
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//   		||
			g.setColor(Color.PINK);
			g.fillRect(Width/3-4, 0, 5, Height);
			g.fillRect(((Width/3)*2)-4, 0, 5, Height);
			
			//			--
			g.fillRect(0, (Height/3) - 38, Width, 5);
			g.fillRect(0, ((Height/3)*2)-70, Width, 5);
			
			repaint();
			System.out.println(p1Pts);
		}
		
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mark++;
			
			if(mark>=3){
				mark = 1;
			}
			
			if(mark==1 || mark==2) {
				for(int i = 0; i < buttons.length; i++) {
					if(e.getSource()==buttons[i]) {
						checkMark(i);
					}
				}
			}
		}
		
	}
	
	private class Clear implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mark = 0;
			
			for(int i = 0; i < buttons.length; i++) {
				buttons[i].setIcon(null);
			}
			
		}
		
	}
	
	private class addPts implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==addP1) {
				p1Pts++;
				p1.setText("Player 1: " + p1Pts);
			}
			if(e.getSource()==addP2) {
				p2Pts++;
				p2.setText("Player 2: " + p2Pts);
			}
		
	}
}
	
	public static void checkMark(int i) {
		if(mark==1) {
			buttons[i].setIcon(X);
		}
		else if(mark==2) {
			buttons[i].setIcon(O);
		}
	}
}
	
