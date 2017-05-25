package paopackage;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {

	JPanel windowContent;
	private JTextField displayField;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton buttonPoint;
	JButton buttonEqual;
	JButton buttonPlus;
	JButton buttonMinus;
	JButton buttonMult;
	JButton buttonDiv;
	JPanel p1;

    public void setDisplayValue(String val) {
        displayField.setText(val);
    }
    
    public String getDisplayValue() {
        return displayField.getText();
    }
    
    Calculator() {
    	//JPanel
    	windowContent = new JPanel();
    	BorderLayout bl = new BorderLayout(); 
    	windowContent.setLayout(bl);
    	displayField = new JTextField(30);
    	windowContent.add("North",displayField);

		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonPoint = new JButton(".");
		buttonEqual = new JButton("=");
		buttonPlus = new JButton("+");
		buttonMinus = new JButton("-");
		buttonMult = new JButton("*");
		buttonDiv = new JButton("/");

		p1 = new JPanel();
		GridLayout gl = new GridLayout(4,4); 
		p1.setLayout(gl);

		//Add buttons
		p1.add(button7);
		p1.add(button8);
		p1.add(button9);
		p1.add(buttonMult);
		p1.add(button4);
		p1.add(button5);
		p1.add(button6);
		p1.add(buttonMinus);
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(buttonPlus);
		p1.add(buttonDiv);
		p1.add(button0);
		p1.add(buttonPoint);
		p1.add(buttonEqual);
		
		CalculatorEngine calcEngine = new CalculatorEngine(this);
		button0.addActionListener(calcEngine);
		button1.addActionListener(calcEngine);
		button2.addActionListener(calcEngine);
		button3.addActionListener(calcEngine);
		button4.addActionListener(calcEngine);
		button5.addActionListener(calcEngine);
		button6.addActionListener(calcEngine);
		button7.addActionListener(calcEngine);
		button8.addActionListener(calcEngine);
		button9.addActionListener(calcEngine);
		buttonPoint.addActionListener(calcEngine);
		buttonEqual.addActionListener(calcEngine);
		buttonPlus.addActionListener(calcEngine);
		buttonMinus.addActionListener(calcEngine);
		buttonMult.addActionListener(calcEngine);
		buttonDiv.addActionListener(calcEngine);
			          
		windowContent.add("Center",p1);
        
		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(windowContent);
		//Seteaza automat dimensiunea 
		frame.pack();
		
		frame.setVisible(true);
    }

    public static void main(String[] args) {
    	new Calculator();
    }
}
