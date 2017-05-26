package paopackage;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator{

	JPanel windowContent;
	private JLabel displayString;
	JButton buttons[];
	JPanel p1;

    public void setDisplayString(String s){
    	displayString.setText(s);
	}
    public String getDisplayString(){
        return displayString.getText();
    }
    Calculator(){
    	//JPanel
    	windowContent = new JPanel();
    	BorderLayout bl = new BorderLayout(); 
    	windowContent.setLayout(bl);
    	displayString = new JLabel("0");
    	windowContent.add("North",displayString);
    	
    	buttons = new JButton[16];
    	for (int i=0; i<=9; i++){
    		buttons[i] = new JButton(String.valueOf(i));
    	}
    	buttons[10] = new JButton(".");
		buttons[11] = new JButton("=");
		buttons[12] = new JButton("+");
		buttons[13] = new JButton("-");
		buttons[14] = new JButton("*");
		buttons[15] = new JButton("/");

		p1 = new JPanel();
		GridLayout gl = new GridLayout(4,4); 
		p1.setLayout(gl);

		p1.add(buttons[7]);
		p1.add(buttons[8]);
		p1.add(buttons[9]);
		p1.add(buttons[14]);
		p1.add(buttons[4]);
		p1.add(buttons[5]);
		p1.add(buttons[6]);
		p1.add(buttons[13]);
		p1.add(buttons[1]);
		p1.add(buttons[2]);
		p1.add(buttons[3]);
		p1.add(buttons[12]);
		p1.add(buttons[15]);
		p1.add(buttons[0]);
		p1.add(buttons[10]);
		p1.add(buttons[11]);
		
		CalculatorEngine calcEngine = new CalculatorEngine(this);
		for (int i=0; i<buttons.length; i++){
			buttons[i].addActionListener(calcEngine);
		}			          
		windowContent.add("Center",p1);
        
		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(windowContent);
		//Seteaza automat dimensiunea 
		frame.pack();
		frame.setVisible(true);
    }

    public static void main(String[] args){
    	new Calculator();
    }
}
