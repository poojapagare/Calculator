import java.awt.ActiveEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{
	    JTextField text;
	    JButton[] numberButton = new JButton[10];
	    JButton[] funcButton = new JButton[8];
	    JButton addbtn,subbtn,mulbtn,divbtn,equBtn,delbtn,clrbtn;
	    JPanel panel;
	    double num1=0,num2=0,res=0;
	    char operator;
     Calculator(){
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420,550);
    	this.setLayout(null);
    	this.pack();
    	
    	text = new JTextField();
    	text.setBounds(50, 25, 300, 50);
    	text.setEditable(true);
    	
    	addbtn = new JButton("+");
    	subbtn = new JButton("-");
    	mulbtn = new JButton("*");
    	divbtn = new JButton("/");
    	equBtn = new JButton("=");
    	delbtn = new JButton("delete");
    	clrbtn = new JButton("clear");
    	
    	funcButton[0] = addbtn;
    	funcButton[1] = subbtn;
    	funcButton[2] = mulbtn;
    	funcButton[3] = divbtn;
    	funcButton[4] = equBtn;
    	funcButton[5] = delbtn;
    	funcButton[6] = clrbtn;
    	
    	
    	
    	for(int i=0;i<7;i++) {
    		funcButton[i].addActionListener(this);
    		funcButton[i].setFocusable(false);
    	}
    	
    	for(int i=0;i<10;i++) {
    		numberButton[i] = new JButton(String.valueOf(i));
    		numberButton[i].addActionListener(this);
    		numberButton[i].setFocusable(false);
    	}
    	panel = new JPanel();
    	panel.setBounds(50, 100, 300, 300);
    	panel.setLayout(new GridLayout(4,4,10,10));
    	panel.add(numberButton[1]);
    	panel.add(numberButton[2]);
    	panel.add(numberButton[3]);
    	panel.add(addbtn);
    	panel.add(numberButton[4]);
    	panel.add(numberButton[5]);
    	panel.add(numberButton[6]);
    	panel.add(subbtn);
    	panel.add(numberButton[7]);
    	panel.add(numberButton[8]);
    	panel.add(numberButton[9]);
    	panel.add(mulbtn);
    	panel.add(divbtn);
    	panel.add(equBtn);
    	panel.add(numberButton[0]);
    	
    	delbtn.setBounds(50,430,145,50);
    	clrbtn.setBounds(205,430,145,50);
    	
    	this.add(text);
    	this.add(panel);
    	this.add(delbtn);
    	this.add(clrbtn);
    	this.setVisible(true);
    }
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButton[i]) {
				text.setText(text.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==addbtn) {
			num1 = Double.parseDouble(text.getText());
			operator = '+';
			text.setText("");
		}
		if(e.getSource()==subbtn) {
			num1 = Double.parseDouble(text.getText());
			operator = '-';
			text.setText("");
		}
		if(e.getSource()==mulbtn) {
			num1 = Double.parseDouble(text.getText());
			operator = '*';
			text.setText("");
		}
		if(e.getSource()==divbtn) {
			num1 = Double.parseDouble(text.getText());
			operator = '/';
			text.setText("");
		}
		if(e.getSource()==equBtn) {
			num2 = Double.parseDouble(text.getText());
			switch(operator) {
			case '+':
				res = num1+num2;
				break;
			case '-':
				res = num1-num2;
				break;
			case '*':
				res = num1*num2;
				break;
			case '/':
				res = num1/num2;
				break;
			}
			text.setText(String.valueOf(res));
			num1 = res;
		}
		if(e.getSource()==clrbtn) {
			text.setText("");
		}
	}
	
}
