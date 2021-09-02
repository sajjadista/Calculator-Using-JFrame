import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class represents the frame of the calculator and its components and all
 * its logic.
 * 
 * @author Sajjad Ahmed
 */
public class calculatorWindow extends JFrame implements ActionListener {

	/**
	 * This section is to declare all the needed components for the calculator
	 */
	private double firstNum, secondNum, result;

	private Font f1 = new Font("Arial", Font.BOLD, 25);
	private Font f2 = new Font("Arial", Font.ITALIC, 15);

	private JList<String> history;
	private DefaultListModel<String> dlmHistory;

	private String operator;

	private JLabel historylbl;

	private JTextField display;

	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, add, subtract, multiply, divide,
			clearAll, delete, period, equal;

	private JPanel calculator, keyPad, utilities, list;

	/**
	 * This is the constructor method to assign all the default values of the
	 * components.
	 */
	public calculatorWindow() {

		// Setting the frame window values
		setTitle("Calculater");
		setBounds(350, 175, 650, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));

		// Creating the panels needed in the calculator
		calculator = new JPanel();
		calculator.setLayout(new FlowLayout());
		keyPad = new JPanel();
		keyPad.setLayout(new GridLayout(4, 4, 5, 5));
		utilities = new JPanel();
		utilities.setLayout(new GridLayout(1, 2, 5, 5));
		list = new JPanel();

		// Simple panels adjustments
		calculator.setBackground(Color.darkGray);
		list.setBackground(Color.white);

		// creating the components and assigning them to the variables
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn0 = new JButton("0");
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("×");
		divide = new JButton("÷");
		clearAll = new JButton("Clear");
		delete = new JButton("delete");
		period = new JButton(".");
		equal = new JButton("=");
		display = new JTextField(13);

		historylbl = new JLabel("History : ------------------------------------------");

		dlmHistory = new DefaultListModel<String>();
		history = new JList<String>(dlmHistory);

		// Adding the components to the panels
		calculator.add(display);
		calculator.add(utilities);
		calculator.add(keyPad);

		utilities.add(clearAll);
		utilities.add(delete);

		keyPad.add(btn7);
		keyPad.add(btn8);
		keyPad.add(btn9);
		keyPad.add(multiply);
		keyPad.add(btn4);
		keyPad.add(btn5);
		keyPad.add(btn6);
		keyPad.add(divide);
		keyPad.add(btn1);
		keyPad.add(btn2);
		keyPad.add(btn3);
		keyPad.add(add);
		keyPad.add(period);
		keyPad.add(btn0);
		keyPad.add(equal);
		keyPad.add(subtract);

		list.add(historylbl);
		list.add(history);

		// Adding the panels to the main frame
		add(calculator);
		add(list);

		// Adding ActionListeners to the components
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn0.addActionListener(this);
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		period.addActionListener(this);
		equal.addActionListener(this);
		clearAll.addActionListener(this);
		delete.addActionListener(this);

		// Setting Fonts
		btn1.setFont(f1);
		btn2.setFont(f1);
		btn3.setFont(f1);
		btn4.setFont(f1);
		btn5.setFont(f1);
		btn6.setFont(f1);
		btn7.setFont(f1);
		btn8.setFont(f1);
		btn9.setFont(f1);
		btn0.setFont(f1);
		add.setFont(f1);
		subtract.setFont(f1);
		divide.setFont(f1);
		multiply.setFont(f1);
		equal.setFont(f1);
		period.setFont(f1);
		clearAll.setFont(f1);
		delete.setFont(f1);
		display.setFont(f1);
		history.setFont(f2);
		historylbl.setFont(f2);

	}

	/*
	 * The main method
	 */

	public static void main(String[] args) {
		// create a window object and make it visible
		new calculatorWindow().setVisible(true);
	}

	/**
	 * This method is define how the action listeners will behave when an event
	 * occurs.
	 * 
	 * @param e is the event that occurs.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String dsplyTxt = display.getText();

		// This logic is to check which number got pressed and display it on the
		// calculator.
		if (e.getSource() == btn0)
			display.setText(dsplyTxt + "0");
		else if (e.getSource() == btn1)
			display.setText(dsplyTxt + "1");
		else if (e.getSource() == btn2)
			display.setText(dsplyTxt + "2");
		else if (e.getSource() == btn3)
			display.setText(dsplyTxt + "3");
		else if (e.getSource() == btn4)
			display.setText(dsplyTxt + "4");
		else if (e.getSource() == btn5)
			display.setText(dsplyTxt + "5");
		else if (e.getSource() == btn6)
			display.setText(dsplyTxt + "6");
		else if (e.getSource() == btn7)
			display.setText(dsplyTxt + "7");
		else if (e.getSource() == btn8)
			display.setText(dsplyTxt + "8");
		else if (e.getSource() == btn9)
			display.setText(dsplyTxt + "9");

		// This logic is to check which operator is selected
		if (e.getSource() == add) {
			firstNum = Double.parseDouble(display.getText());
			operator = "+";
			display.setText("");
		}

		else if (e.getSource() == subtract) {

			/*
			 * This logic is to handle the subtract button as negative sign or as an
			 * operator
			 */
			if (dsplyTxt.equals("")) {
				display.setText("-");
			} else {
				firstNum = Double.parseDouble(display.getText());
				operator = "-";
				display.setText("");
			}
		} else if (e.getSource() == multiply) {

			firstNum = Double.parseDouble(display.getText());
			operator = "*";
			display.setText("");

		} else if (e.getSource() == divide) {

			firstNum = Double.parseDouble(display.getText());
			operator = "/";
			display.setText("");

		}
		/*
		 * Display a dot on the calculator
		 */
		else if (e.getSource() == period) {

			display.setText(dsplyTxt + ".");
		}
		/*
		 * Clears out everything on the calculator display when the "clear" button is
		 * pressed
		 */
		else if (e.getSource() == clearAll) {

			display.setText("");
		}
		/*
		 * Deletes one digit from the calculator display when the "delete" button is
		 * pressed
		 */
		else if (e.getSource() == delete) {
			if (display.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "The calculator is already empty!");

			} else {
				display.setText(dsplyTxt.substring(0, dsplyTxt.length() - 1));
			}

		}
		/*
		 * Perform the operation and display the result when the "=" is pressed
		 */
		else if (e.getSource() == equal) {

			secondNum = Double.parseDouble(display.getText());

			/*
			 * This switch case is used to check what operator has been chosen and perform
			 * the operation based on it.
			 */
			switch (operator) {
			case "+":
				result = firstNum + secondNum;
				break;
			case "-":
				result = firstNum - secondNum;
				break;
			case "*":
				result = firstNum * secondNum;
				break;
			case "/":
				result = firstNum / secondNum;
				break;
			}

			/*
			 * Display the result on the calculator and add it to the history
			 * section.
			 */
			display.setText("" + result);
			dlmHistory.addElement(firstNum + " " + operator + " " + secondNum + " = " + result);
			firstNum = 0;
			secondNum = 0;

		}

	}

}
