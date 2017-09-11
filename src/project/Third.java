package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Third {
	JLabel result,resultCount;
	JPanel ThirdPanel,MainPanel;
	JFrame MainFrame;
	CardLayout Card;
	public JButton btn1, btn2;
	
	public void Create(JPanel argP, JPanel argP2 ,CardLayout argL,JFrame argF){
		this.ThirdPanel=argP;
		this.MainPanel=argP2;
		this.Card=argL;
		this.MainFrame=argF;
	}
	public void ThirdPanel(){
		result=new JLabel();
		resultCount=new JLabel();
		btn1 = new JButton("종료하기"){ImageIcon i = new ImageIcon("img/End.png"); 
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 220, 70, null);
			}
		};;
	 	btn2 = new JButton("재시작"){ImageIcon i = new ImageIcon("img/Retry.png"); 
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 220, 70, null);
		}
	 	};;
		
		result.setFont(new Font("배달의민족 한나는 열한살", 0, 80));
		resultCount.setFont(new Font("배달의민족 한나는 열한살", 0, 80));
		
		resultCount.setBounds(100,300,850,100);
		btn1.setBounds(200, 500, 220, 70);
		btn2.setBounds(500, 500, 220, 70);
		
		if(First.iCount<=2){
			result.setText("조금 더 분발해봐요!");
			result.setBounds(150,150,900,100);
		}
		else if(First.iCount>2&&First.iCount<4){
			result.setText("잘 했어요!");
			result.setBounds(300,150,900,100);
		}
		else if(First.iCount==4){
			result.setText("참 잘했어요!");
			result.setBounds(290,150,900,100);
		}
		else{
			result.setText("만점이네요!");
			result.setBounds(290,150,900,100);
		}
		ThirdPanel.add(btn1);
		ThirdPanel.add(btn2);
		resultCount.setText("5개 중 "+First.iCount+"개를 맞았어요!");
		ThirdPanel.add(resultCount);
		ThirdPanel.add(result);
		
		btn1.addActionListener(new EventHanlerBnt());;
		btn2.addActionListener(new EventHanlerBnt());;
	}
	class EventHanlerBnt implements ActionListener{
		 public void actionPerformed(ActionEvent ae){	 
			 if(ae.getSource() == btn1){
				 System.exit(0);
			 }
			 else if(ae.getSource() == btn2){
				 First.iCount=0;
				 First.i=0;
				 First.c=850;
				 result.setText("");
				 resultCount.setText("");
				 
				 MainFrame.dispose();
				 
				 new First();
				 
				 Card.show(MainPanel,"First");
			 }
		 }
	}
}