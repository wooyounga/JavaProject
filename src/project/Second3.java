package project;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Second3 implements SecondInt {
	JPanel ClockPanel,SecondPanel,MainPanel,ThirdPanel;
	JLabel Count,Qna;
	JFrame MainFrame;
	CardLayout Card;

	TreeMap ht= new TreeMap();
	
	JButton btn1 = new JButton();
	JButton btn2 = new JButton();
	JButton btn3 = new JButton();
	JButton btn4 = new JButton();
	
	String qna = null;
	
	public Second3(JPanel argP,JPanel argP1, JPanel argP2, CardLayout argL,JFrame argF) {
		this.MainPanel = argP;
		this.SecondPanel = argP1;
		this.ThirdPanel = argP2;
		this.Card = argL;
		this.MainFrame = argF;
	}
	
	public void Create(){
		Count = new JLabel();
		Qna = new JLabel();
		
		ht.put("8 / 2 = ?",4);
		ht.put("9 / 3 = ?",3);
		ht.put("6 / 3 = ?",2);
		ht.put("1 / 1 = ?",1);
		ht.put("8 / 4 = ?",2);
		
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
		
		if(qna.equals("8 / 2 = ?")){
			btn1.setIcon(new ImageIcon("img/"+(btnqna-2)+".png"));
			btn2.setIcon(new ImageIcon("img/"+(btnqna+2)+".png"));
			btn3.setIcon(new ImageIcon("img/"+(btnqna+1)+".png"));
			btn4.setIcon(new ImageIcon("img/"+(btnqna)+".png"));
		}
		else if(qna.equals("9 / 3 = ?")){
			btn1.setIcon(new ImageIcon("img/"+(btnqna+1)+".png"));
			btn2.setIcon(new ImageIcon("img/"+(btnqna)+".png"));
			btn3.setIcon(new ImageIcon("img/"+(btnqna+3)+".png"));
			btn4.setIcon(new ImageIcon("img/"+(btnqna-2)+".png"));
		}
		else if(qna.equals("6 / 3 = ?")){
			btn1.setIcon(new ImageIcon("img/"+(btnqna)+".png"));
			btn2.setIcon(new ImageIcon("img/"+(btnqna+2)+".png"));
			btn3.setIcon(new ImageIcon("img/"+(btnqna-2)+".png"));
			btn4.setIcon(new ImageIcon("img/"+(btnqna-1)+".png"));
		}
		else if(qna.equals("1 / 1 = ?")){
			btn1.setIcon(new ImageIcon("img/"+(btnqna+1)+".png"));
			btn2.setIcon(new ImageIcon("img/"+(btnqna+2)+".png"));
			btn3.setIcon(new ImageIcon("img/"+(btnqna)+".png"));
			btn4.setIcon(new ImageIcon("img/"+(btnqna-1)+".png"));
	}
	else if(qna.equals("8 / 4 = ?")){
		btn1.setIcon(new ImageIcon("img/"+(btnqna+1)+".png"));
		btn2.setIcon(new ImageIcon("img/"+(btnqna)+".png"));
		btn3.setIcon(new ImageIcon("img/"+(btnqna-1)+".png"));
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
				 if(qna.equals("6 / 3 = ?")){
					 ++First.iCount;
					 First.c+=30;
				 }
				 else{
					 First.c-=30;
				 }
				 SecondLabel();
				 PrintBtn();
			 }
		 }
		 else if(ae.getSource() == btn2){
			 if(First.i<5){
				 First.i++;
				 if(qna.equals("8 / 4 = ?")){
					 ++First.iCount;
					 First.c+=30;
				 }
				 else if(qna.equals("9 / 3 = ?")){
					 ++First.iCount;
					 First.c+=30;
				 }
				 else{
					 First.c-=30;
				 }
				 SecondLabel();
				 PrintBtn();
			 }
		 }
		 
		 else if(ae.getSource() == btn3){
			 if(First.i<5){
				 First.i++;
				 if(qna.equals("1 / 1 = ?")){
					 ++First.iCount;
					 First.c+=30;
				 }
				 else{
					 First.c-=30;
				 }
				 SecondLabel();
				 PrintBtn();
			 }
		 }
		 
		 else if(ae.getSource() == btn4){
			 if(First.i<5){
				 First.i++;
				 if(qna.equals("8 / 2 = ?")){
					 ++First.iCount;
					 First.c+=30;
				 }
				 else{
					 First.c-=30;
				 }
				 SecondLabel();
				 PrintBtn();
			 }
		 }
		 if(First.i==5){
			 System.out.println(First.iCount);
			 SecondLabel();
			 Third thd = new Third();			 
			 try {
					Thread.sleep(100);
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
				Thread.sleep(65);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ClockPanel.setSize(First.c,45);
			First.c-=1.5;
			if(First.c<10||First.i==5){
				NextPaenl();
				break;
			}
			}
			}
		
	}
}