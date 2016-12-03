package chemistrycalculator;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MolecularWeightWindow extends JFrame
{
	private JLabel inputLabel;
	private JLabel resultLabel;
	
	private JTextField inputField;
	private JTextField resultField;
	
	private JButton sendButton;
	private JButton computeButton;
	
	private FormulaReader formulaReader;
	private double result;
	
	public MolecularWeightWindow()
	{
		super("Molecular Weight Calculator");
		
		Font f = new Font("SansSerif", Font.PLAIN, 20);
		formulaReader = new FormulaReader();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds (0, 720, 400, 600);
	    setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    //the next 4 groups of code set up the molar mass calculator labels and input/result areas
	    inputLabel = new JLabel("Formula:");
	    inputLabel.setPreferredSize(new Dimension(225, 40));
	    inputLabel.setFont(f);
	    add(inputLabel);
	    
	    resultLabel = new JLabel("Molecular Weight:");
	    resultLabel.setPreferredSize(new Dimension(225, 40));
	    resultLabel.setFont(f);
	    c.gridx = 1;
	    add(resultLabel,c);
	    
	    inputField = new JTextField();
	    inputField.setPreferredSize(new Dimension(225, 40));
	    inputField.setFont(f);
	    c.gridy = 1;
	    c.gridx = 0;
	    add(inputField, c);
	    
	    resultField = new JTextField();
	    resultField.setEditable(false);
	    resultField.setBackground(null);
	    resultField.setBorder(null);
	    resultField.setText("=");
	    resultField.setPreferredSize(new Dimension(225, 40));
	    resultField.setFont(f);
	    c.gridx = 1;
	    add(resultField, c);
	    
	    //the next two groups of code set up the molar mass calculator's buttons
	    sendButton = new JButton("send to calculator");
	    sendButton.setPreferredSize(new Dimension(225, 40));
	    sendButton.setFont(f);
	    sendButton.addActionListener(new ActionListener()//send to calculator button listener
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			Main.getCalcWindow().input(String.format("%1$.4f", result), "screen");
    		}
    	});
	    c.gridy = 2;
	    c.gridx = 0;
	    add(sendButton, c);
	    
	    computeButton = new JButton("compute");
	    computeButton.setPreferredSize(new Dimension(225, 40));
	    computeButton.setFont(f);
	    computeButton.addActionListener(new ActionListener()//compute button listener
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			compute();
    		}
    	});
	    c.gridx = 1;
	    add(computeButton, c);
	    
	    pack();
	}
	public void input(String in, boolean shouldCompute)//if shouldCompute is true, the input field is evaluated after new string is added
	{
		inputField.setText(inputField.getText()+in);
		if(shouldCompute)
			compute();
	}
	private void compute()//sends formula, gets double result
	{
		String equation = formulaReader.getEquation(inputField.getText());//gets equation from molecule formula
		if(equation.equals("Error"))//checks for error
			resultField.setText("Error");
		else
			result = Calculator.eval(equation);//sends equation to calculator for evaluation
			resultField.setText(String.format("= %1$.4f AMU", result));
	}
}
