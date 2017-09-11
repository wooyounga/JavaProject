package project;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.FileInputStream;

import javax.swing.*;

import javazoom.jl.player.Player;

public class Second1 implements SecondInt {
	JPanel ClockPanel,MainPanel,SecondPanel, ThirdPanel;
	JLabel Count,Qna;
	JFrame MainFrame;
	CardLayout Card;

	TreeMap ht= new TreeMap();
	
	JButton btn1 = new JButton();
	JButton btn2 = new JButton();
	JButton btn3 = new JButton();
	JButton btn4 = new JButton();
	
	String qna = null;
	
	public Second1(JPanel argP,JPanel argP1, JPanel argP2, CardLayout argL,JFrame argF) {
		this.MainPanel = argP;
		this.SecondPanel = argP1;
		this.ThirdPanel = argP2;
		this.Card = argL;
		this.MainFrame = argF;
	}
	public void Create(){
		Count = new JLabel();
		Qna = new JLabel();
		
		ht.put("7 + 3 = ?",10);
		ht.put("2 + 3 = ?",5);
		ht.put("1 + 6 = ?",7);
		ht.put("5 + 3 = ?",8);
		ht.put("6 + 5 = ?",11);
		
		ClockPanel=new JPanel(){ImageIcon i = new ImageIcon("img/Bar.png"); 
		  public void paintComponent(Graphics g) {
			   g.drawImage(i.getImage(), 0, 0,840, 35, null);
			  }
			 };
		ClockPanel.setBounds(53, 604, 850, 40);
		Count.setBounds(850,15,50,100);
		Qna.setBounds(170,150,650,200);
	
		Count.setFont(new Font("배달의민족 한나는 열한살", 0, 30));
		Qna.setFont(new Font("배달의민족 한나는 열한살", 0, 160));
		btn1.setFont(new Font("배달의민족 한나는 열한살", 0, 80));
		btn2.setFont(new Font("배달의민족 한나는 열한살", 0, 80));
		btn3.setFont(new Font("배달의민족 한나는 열한살", 0, 80));
		btn4.setFont(new Font("배달의민족 한나는 열한살", 0, 80));
		
		SecondPanel.add(ClockPanel); 
		SecondPanel.add(Count);
		SecondPanel.add(Qna);
		
		ClockThread thr = new ClockThread();
		Thread t= new Thread(thr);
		t.start();
	}
	public void SedBtn(){
		SecondPanel.add(btn1);
		SecondPanel.add(btn2);
		SecondPanel.add(btn3);
		SecondPanel.add(btn4);
		  
		btn1.setBounds(100, 400, 150, 150);
		btn2.setBounds(300, 400, 150, 150);
		btn3.setBounds(500, 400, 150, 150);
		btn4.setBounds(700, 400, 150, 150);

		btn1.addActionListener(new EventHanlerBtn());
		btn2.addActionListener(new EventHanlerBtn());
		btn3.addActionListener(new EventHanlerBtn());
		btn4.addActionListener(new EventHanlerBtn());
	}
	public void PrintBtn(){
		int btnqna=(int) ht.get(qna);
		
		if(qna.equals("7 + 3 = ?")){
			btn1.setIcon(new ImageIcon("img/"+btnqna+".png"));
			btn2.setIcon(new ImageIcon("img/"+(btnqna+2)+".png"));
			btn3.setIcon(new ImageIcon("img/"+(btnqna+1)+".png"));
			btn4.setIcon(new ImageIcon("img/"+(btnqna-2)+".png"));
		}
		else if(qna.equals("2 + 3 = ?")){
			btn1.setIcon(new ImageIcon("img/"+(btnqna+1)+".png"));
			btn2.setIcon(new ImageIcon("img/"+btnqna+".png"));
			btn3.setIcon(new ImageIcon("img/"+(btnqna+3)+".png"));
			btn4.setIcon(new ImageIcon("img/"+(btnqna-2)+".png"));
		}
		else if(qna.equals("1 + 6 = ?")){
			btn1.setIcon(new ImageIcon("img/"+(btnqna-1)+".png"));
			btn2.setIcon(new ImageIcon("img/"+(btnqna+2)+".png"));
			btn3.setIcon(new ImageIcon("img/"+(btnqna-2)+".png"));
			btn4.setIcon(new ImageIcon("img/"+btnqna+".png"));
		}
		else if(qna.equals("5 + 3 = ?")){
			btn1.setIcon(new ImageIcon("img/"+btnqna+".png"));
			btn2.setIcon(new ImageIcon("img/"+(btnqna-3)+".png"));
			btn3.setIcon(new ImageIcon("img/"+(btnqna+1)+".png"));
			btn4.setIcon(new ImageIcon("img/"+(btnqna-1)+".png"));
	}
		else if(qna.equals("6 + 5 = ?")){
			btn1.setIcon(new ImageIcon("img/"+(btnqna+1)+".png"));
			btn2.setIcon(new ImageIcon("img/"+(btnqna-1)+".png"));
			btn3.setIcon(new ImageIcon("img/"+btnqna+".png"));
			btn4.setIcon(new ImageIcon("img/"+(btnqna+3)+".png"));
	}
	}
	public void SecondLabel(){
		Set keyset = ht.keySet();
		Object[] hashkeys = keyset.toArray();
		
		Count.setText(First.iCount+"/5");
		if(First.i<5){
		qna=(String)hashkeys[First.i];
		  }
		Qna.setText(qna);
	}
	 public void NextPaenl(){
		 Third thd = new Third();
		 thd.Create(ThirdPanel,MainPanel,Card,MainFrame);
		  thd.ThirdPanel();
		  Card.show(MainPanel, "Third");
	 }
	 class EventHanlerBtn implements ActionListener{
	 public void actionPerformed(ActionEvent ae){		 
		 if(ae.getSource() == btn1){
			 if(First.i<5){
				 First.i++;
				 if(qna.equals("7 + 3 = ?")){
					 First.iCount++;
					 First.c+=80;
				 }
				 else if(qna.equals("5 + 3 = ?")){
					 First.iCount++;
					 First.c+=80;
				 }
				 else{
					 First.c-=80;
				 }
				 SecondLabel();
				 PrintBtn();
			 }
		 }
		 else if(ae.getSource() == btn2){
			 if(First.i<5){
				 First.i++;
				 if(qna.equals("2 + 3 = ?")){
					 First.iCount++;
					 First.c+=80;
				 }
				 else{
					 First.c-=80;
				 }
				 SecondLabel();
				 PrintBtn();
			 }
		 }
		 
		 else if(ae.getSource() == btn3){
			 if(First.i<5){
				 First.i++;
				 if(qna.equals("6 + 5 = ?")){
					 First.iCount++;
					 First.c+=80;
				 }
				 else{
					 First.c-=80;
				 }
				 SecondLabel();
				 PrintBtn();
			 }
		 }
		 
		 else if(ae.getSource() == btn4){
			 if(First.i<5){
				 First.i++;
				 if(qna.equals("1 + 6 = ?")){
					 First.iCount++;
					 First.c+=80;
				 }
				 else{
					 First.c-=80;
				 }
				 SecondLabel();
				 PrintBtn();
			 }
		 }
			 
			 
		 if(First.i==5){
			 System.out.println(First.iCount);
			 SecondLabel();
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Count.setText("");
			Qna.setText("");
			NextPaenl();
		 }	
	 }
	}
	public class ClockThread implements Runnable {	
		public void run() {
			while(true){
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ClockPanel.setSize(First.c,45);
			First.c-=2.1;
			if(First.c<10||First.i==5){
				NextPaenl();
				break;
			}
			}
			}
		
	}
}