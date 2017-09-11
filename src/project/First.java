package project;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.decoder.*;
import javazoom.jl.player.*;
import javax.swing.*;

public class First {
	JFrame MainFrame;
	JPanel MainPanel,FirstPanel,SecondPanel,ThirdPanel;
	CardLayout Card;
	public static int iCount=0;
	public static int i=0;
	public static int c=850;
	JButton btn1,btn2, btn3;

	
	public First(){
		MainFrame=new JFrame("즐거운 수학풀이~");
		MainPanel=new JPanel();
		Card = new CardLayout();
		MainFrame.setBounds(250,120,700,700);
		MainFrame.setResizable(false);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel.setBounds(0,0,700,700);
		MainFrame.add(MainPanel);
		MainPanel.setLayout(Card);
		
		FirstPanel = new JPanel(){ImageIcon i = new ImageIcon("img/Main.png"); 
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 695, 690, null);
		  }
		 };
		SecondPanel = new JPanel(){ImageIcon i = new ImageIcon("img/SecondPanel.jpg"); 
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 950, 700, null);
		  }
		 };
		ThirdPanel = new JPanel(){ImageIcon i = new ImageIcon("img/Panel.png"); 
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 950, 700, null);
			}
		 };
		 
		 FirstPanel.setLayout(null);
		 ThirdPanel.setLayout(null);
		 MainPanel.add(FirstPanel,"First");
		 MainPanel.add(SecondPanel,"Second");
		 MainPanel.add(ThirdPanel,"Third");
		 
		 Card.show(MainPanel, "First");
		 
		 FirstBtn();
		 
		 MainFrame.setVisible(true);
	}
	static Player p=null;
	public void Sound(){
		try{
			p = new Player(new FileInputStream("sound/상어가족.mp3"));
			p.play();
		}
		catch(Exception e){
			
		}
	}
	public void FirstBtn(){
		 btn1 = new JButton(){ImageIcon i = new ImageIcon("img/+.png"); 
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 220, 70, null);
		  }
		 };;
		 btn2 = new JButton(){ImageIcon i = new ImageIcon("img/x.png"); 
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 220, 70, null);
		  }
		 };;
		 btn3 = new JButton(){ImageIcon i = new ImageIcon("img/％.png"); 
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 220, 70, null);
		  }
		 };;
		  
		 FirstPanel.add(btn1);
		 FirstPanel.add(btn2);
		 FirstPanel.add(btn3);
		 
		 btn1.setBounds(240, 300, 220, 70);
		 btn2.setBounds(240, 400, 220, 70);
		 btn3.setBounds(240, 500, 220, 70);
		 
		 btn1.addActionListener(new EventHanlerBnt());;
		 btn2.addActionListener(new EventHanlerBnt());;
		 btn3.addActionListener(new EventHanlerBnt());;
	}
	
	public static void main(String [] args){
		 First start = new First();
		 start.Sound();
	}
	class EventHanlerBnt implements ActionListener{
		 public void actionPerformed(ActionEvent ae){
			 if(ae.getSource() == btn1){
				 Second1 sed1 = new Second1(MainPanel,SecondPanel, ThirdPanel, Card, MainFrame);
				 System.out.println("초급선택");
				 MainFrame.setBounds(150,120,950,700);
				 MainFrame.setTitle("덧셈문제를 풀어볼까요~");
				 MainPanel.setSize(950,700);
				 SecondPanel.setLayout(null);
				 
				 sed1.Create();
				 sed1.SedBtn();
				 sed1.SecondLabel();
				 sed1.PrintBtn();
				 
				 Card.show(MainPanel, "Second");
			 }
			 else if(ae.getSource() == btn2){
				 Second2 sed2 = new Second2(MainPanel,SecondPanel, ThirdPanel, Card, MainFrame);
				 System.out.println("중급선택");
				 MainFrame.setBounds(150,120,950,700);
				 MainFrame.setTitle("곱셈문제를 풀어볼까요~");
				 MainPanel.setSize(950,700);
				 SecondPanel.setLayout(null);
				 
				 sed2.Create();
				 sed2.SedBtn();
				 sed2.SecondLabel();
				 sed2.PrintBtn();
				 Card.show(MainPanel, "Second");
			 }
			 else if(ae.getSource() == btn3){
				 Second3 sed3 = new Second3(MainPanel,SecondPanel, ThirdPanel, Card, MainFrame);
				 System.out.println("고급선택");
				 MainFrame.setBounds(150,120,950,700);
				 MainFrame.setTitle("나눗셈문제를 풀어볼까요~");
				 MainPanel.setSize(950,700);
				 SecondPanel.setLayout(null);
				 
				 sed3.Create();
				 sed3.SedBtn();
				 sed3.SecondLabel();
				 sed3.PrintBtn();
				 Card.show(MainPanel, "Second");
			 }
		 }
	}

}

