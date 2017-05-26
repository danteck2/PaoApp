package paopackage;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener{
	
	Calculator parent;
	boolean display;
	boolean clear;
	double lastNumber;
	String lastOperator;
	
	CalculatorEngine(Calculator parent){
		this.parent = parent;
		parent.setDisplayString("0");
		lastOperator = "0";
		lastNumber = 0;
		display = false;
		clear = true;
	}
	public void actionPerformed(ActionEvent e){
		JButton button =  (JButton) e.getSource();
		String buttonText = button.getText();
		switch(buttonText){
			case "0":
				addDigit(0);
				break;
			case "1":
				addDigit(1);
				break;
			case "2":
				addDigit(2);
				break;
			case "3":
				addDigit(3);
				break;
			case "4":
				addDigit(4);
				break;
			case "5":
				addDigit(5);
				break;
			case "6":
				addDigit(6);
				break;
			case "7":
				addDigit(7);
				break;
			case "8":
				addDigit(8);
				break;
			case "9":
				addDigit(9);
				break;
			case ".":
				addPoint();
				break;
			case "=":
				processEqual();
				break;
			case "+":
				processOperator("+");
				break;
			case "-":
				processOperator("-");
				break;
			case "*":
				processOperator("*");
				break;
			case "/":
				processOperator("/");
				break;
		}
	}
	void addDigit(int x){
		if (clear)
			parent.setDisplayString("");

		String input = parent.getDisplayString();
		
		if (input.indexOf("0") == 0)
			input = input.substring(1);
		if ((!input.equals("0") || x > 0)  && input.length() < 20)
			parent.setDisplayString(input + x);

		display = false;
		clear = false;
	}
	void addPoint(){
		display = false;

		if (clear)
			parent.setDisplayString("");

		String input = parent.getDisplayString();
		
		if (input.indexOf(".") < 0)
			parent.setDisplayString(new String(input + "."));
	}
	
	double getNumber(){
		String input = parent.getDisplayString();
		return Double.parseDouble(input);
	}
	
	void processOperator(String op) {
		if (display == false || display == true){
			double number = getNumber();

			if (!lastOperator.equals("0")) {
				double result = processLastOperator();
				displayResult(result);
				lastNumber = result;
			}
			else lastNumber = number;
			
			clear = true;
			lastOperator = op;
		}
	}
	void processEqual(){
		double result = 0;
		result = processLastOperator();
		displayResult(result);
		lastOperator = "0";
	}
	double processLastOperator(){
		double result = 0;
		double number = getNumber();
	
		if (lastOperator.equals("/"))
			result = lastNumber / number;
		if (lastOperator.equals("*"))
			result = lastNumber * number;
		if (lastOperator.equals("-"))
			result = lastNumber - number;
		if (lastOperator.equals("+"))
			result = lastNumber + number;
		return result;
	}
	void displayResult(double result){
		parent.setDisplayString(Double.toString(result));
		lastNumber = result;
		display = true;
		clear = true;
	}
}
