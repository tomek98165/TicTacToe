import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe extends JFrame implements ActionListener {
	
	Random random = new Random();
	JPanel header = new JPanel();
	JPanel leftSide = new JPanel();
	JPanel game = new JPanel();
	JButton[] button = new JButton[9];
	JButton restart = new JButton();
	JLabel leftFieldText = new JLabel();
	JLabel topFieldText = new JLabel();
	boolean xturn = true;
	
	TicTacToe(){
	//Frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setLayout(new BorderLayout());
		this.add(header,BorderLayout.NORTH);
		this.add(leftSide,BorderLayout.EAST);
		this.add(game,BorderLayout.CENTER);
		
		
	//Panels	
	
		header.setBackground(Color.green);
		header.setPreferredSize(new Dimension(100,75));
		header.add(topFieldText);
		
		
		leftSide.setBackground(Color.red);
		leftSide.setPreferredSize(new Dimension(200,700));
		leftSide.setLayout(null);
		leftSide.add(restart);
		leftSide.add(leftFieldText);
		
		
		game.setPreferredSize(new Dimension(100,100));
		game.setLayout(new GridLayout(3,3,10,10));
		
		
	//header
		topFieldText.setForeground(Color.red);
		topFieldText.setFont(new Font("Ink Free", Font.BOLD, 40));
		topFieldText.setHorizontalAlignment(JLabel.CENTER);
		
	//leftSide	
		leftFieldText.setText("X turn");
		leftFieldText.setForeground(Color.green);
		leftFieldText.setFont(new Font("Ink Free", Font.BOLD, 40));
		leftFieldText.setBounds(0,0,200,100);
		leftFieldText.setVerticalAlignment(JLabel.TOP);
		leftFieldText.setHorizontalAlignment(JLabel.CENTER);
		
		restart.setFocusable(false);
		restart.setBounds(50,100,100,40);
		restart.setText("Restart");
		restart.addActionListener(this);
	

		

	//game
		for(int i = 0; i<9; i++) {
			button[i] = new JButton();
			button[i].setFocusable(false);
			game.add(button[i]);
			button[i].addActionListener(this);
		}
		this.setVisible(true);
		
		
		firstturn(); 
	}
	
	
	/*
	 * Method to start game
	 */
	public void firstturn() {
		
		if(random.nextInt(2)==0)
			xturn=true;
		else
			xturn=false;
		if(xturn==true) {
			leftFieldText.setText("X turn");
		}else {
			leftFieldText.setText("O turn");
		}	
	}
	
	
	
	/*
	 * Method checking every turn if winning conditions has been met 
	 */
	public void check() {
		
		//winning conditions where x wins
		if(
				(button[0].getText()=="X") &&
				(button[1].getText()=="X") &&
				(button[2].getText()=="X")
		  ){
			xwins();
		}
		if(
				(button[3].getText()=="X") &&
				(button[4].getText()=="X") &&
				(button[5].getText()=="X")
		  ){
			xwins();
		}
		if(
				(button[6].getText()=="X") &&
				(button[7].getText()=="X") &&
				(button[8].getText()=="X")
		  ){
			xwins();
		}
		if(
				(button[0].getText()=="X") &&
				(button[3].getText()=="X") &&
				(button[6].getText()=="X")
		  ){
			xwins();
		}
		if(
				(button[1].getText()=="X") &&
				(button[4].getText()=="X") &&
				(button[7].getText()=="X")
		  ){
			xwins();
		}
		if(
				(button[2].getText()=="X") &&
				(button[5].getText()=="X") &&
				(button[8].getText()=="X")
		  ){
			xwins();
		}
		if(
				(button[0].getText()=="X") &&
				(button[4].getText()=="X") &&
				(button[8].getText()=="X")
		  ){
			xwins();
		}
		if(
				(button[2].getText()=="X") &&
				(button[4].getText()=="X") &&
				(button[6].getText()=="X")
		  ){
			xwins();
		}
		
		//winning conditions where o wins
		if(
				(button[0].getText()=="O") &&
				(button[1].getText()=="O") &&
				(button[2].getText()=="O")
		  ){
			owins();
		}
		if(
				(button[3].getText()=="O") &&
				(button[4].getText()=="O") &&
				(button[5].getText()=="O")
		  ){
			owins();
		}
		if(
				(button[6].getText()=="O") &&
				(button[7].getText()=="O") &&
				(button[8].getText()=="O")
		  ){
			owins();
		}
		if(
				(button[0].getText()=="O") &&
				(button[3].getText()=="O") &&
				(button[6].getText()=="O")
		  ){
			owins();
		}
		if(
				(button[1].getText()=="O") &&
				(button[4].getText()=="O") &&
				(button[7].getText()=="O")
		  ){
			owins();
		}
		if(
				(button[2].getText()=="O") &&
				(button[5].getText()=="O") &&
				(button[8].getText()=="O")
		  ){
			owins();
		}
		if(
				(button[0].getText()=="O") &&
				(button[4].getText()=="O") &&
				(button[8].getText()=="O")
		  ){
			owins();
		}
		if(
				(button[2].getText()=="O") &&
				(button[4].getText()=="O") &&
				(button[6].getText()=="O")
		  ){
			owins();
		}
	}
	
	
	/*
	 * End game methods
	 */
	public void xwins() {
		topFieldText.setText("X Win");
		for(int i=0; i<9; i++) {
			button[i].setEnabled(false);
		}
	}
	public void owins() {
		topFieldText.setText("O Win");
		for(int i=0; i<9; i++) {
			button[i].setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * ActionListerer for game buttons 
		 */
		for(int i=0; i<9; i++) {
			if(e.getSource()==button[i])
			{
				if(xturn==true) {
					button[i].setText("X");
					button[i].setFont(new Font("Ink Free", Font.BOLD, 90));
					xturn=false;
					leftFieldText.setText("O Turn");
					button[i].setEnabled(false);
					check();
				}else {
					button[i].setText("O");
					button[i].setFont(new Font("Ink Free", Font.BOLD, 90));
					xturn=true;
					leftFieldText.setText("X Turn");
					button[i].setEnabled(false);
					check();
				}
			}
		}
		
		/*
		 * ActionListener for button which start new game
		 */
		if(e.getSource()==restart) {
			firstturn();
			topFieldText.setText("Tic Tac Toe");
			for(int i=0; i<9; i++) {
				button[i].setText("");
				button[i].setEnabled(true);
			}
		}
			
	}
}