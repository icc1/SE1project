
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class CalcWindow extends JFrame
{
	private JMenuBar chemBar;
	private JMenu chemMenu;
	
	private JMenuItem periodicItem;
	private JMenuItem molarMassItem;
	private JMenuItem molecularWeightItem;
	
	private JPanel screenPanel;
	private JTextField calcScreen;
	private JTextField resultArea;
	private double result = 0.0;
	
	private JPanel buttonPanel;
	GenericListener basic = new GenericListener();
	FunctionListener func = new FunctionListener();
	
	//Row 1
	private JButton functionExpBttn;
	private JButton functionSinBttn;
	private JButton functionCosBttn;
	private JButton functionTanBttn;
	private JButton undoButton;
	private String prevString;
	
	//Row 2
	private JButton functionRootBttn;
	private JButton inputParLBttn;
	private JButton inputParRBttn;
	private JButton utilBackspaceBttn;
	private JButton utilClearBttn;
	
	//Row 3
	private JButton functionLogBttn;
	private JButton num7Bttn;
	private JButton num8Bttn;
	private JButton num9Bttn;
	private JButton operatorDivideBttn;
	
	//Row 4
	private JButton functionNaturalLogBttn;
	private JButton num4Bttn;
	private JButton num5Bttn;
	private JButton num6Bttn;
	private JButton operatorMultiplyBttn;
	
	//Row 5
	private JButton utilMemStoreBttn;
	private double mem;
	private JButton num1Bttn;
	private JButton num2Bttn;
	private JButton num3Bttn;
	private JButton operatorSubtractBttn;
	
	//Row 6
	private JButton utilMemRecallBttn;
	private JButton num0Bttn;
	private JButton inputDecBttn;
	private JButton utilEqualsBttn;
	private JButton operatorAddBttn;

	public CalcWindow()
	{
		super("Calculator");
		
		//This method is organized so that the calculator items are initialized
		//and added in the order that they appear from the top down.
		
		//Setting up the main calculator frame
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(400,600); 
	    setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    //Initializing the chemistry menu bar
	    chemBar = new JMenuBar();
	    
	    //Initializing the chemistry menu and adding it to the menu bar
	    chemMenu = new JMenu("Chemistry");
	    chemBar.add(chemMenu);
	      
	    //Initializing the chemistry menu items, adding their events and adding them to the menu
	    periodicItem = new JMenuItem("Periodic Table");
	    periodicItem.addActionListener(new ActionListener()
	    	{
	    		@Override
	    		public void actionPerformed(ActionEvent e) {
	    			if(!Main.getMolarMassWindow().isVisible())
	    				Main.getMolarMassWindow().setVisible(true);
	    		}
	    	});
	    molarMassItem = new JMenuItem("Molar Mass Calculator");
	    molarMassItem.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if(!Main.getPeriodicWindow().isVisible())
    				Main.getPeriodicWindow().setVisible(true);
    		}
    	});
	    molecularWeightItem = new JMenuItem("Molecular Weight Calculator");
	    molecularWeightItem.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			//launch mw
    		}
    	});
	    chemMenu.add(periodicItem);
	    chemMenu.add(molarMassItem);
	    chemMenu.add(molecularWeightItem);
	    
	    c.gridy = 0;
	    c.fill = GridBagConstraints.BOTH;
	    add(chemBar, c);
	    //Moving down from the menu bar
	     
	    screenPanel = new JPanel();
	    screenPanel.setLayout(new GridBagLayout());
	    
	    calcScreen = new JTextField("");
	    calcScreen.setPreferredSize(new Dimension(400, 70));
	    calcScreen.setFont(new Font("SansSerif", Font.BOLD, 25));
	    calcScreen.addKeyListener(new KeyAdapter() {
	    	   public void keyTyped(KeyEvent e) {
	    		      char c = e.getKeyChar();
	    		      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
	    		    	  && (c != '*') && (c != '/') && (c != '+') && (c != '-') 
	    		    	  && (c != '.') && (c != '(') && (c != ')')){
	    		         e.consume();  // ignore event
	    		      }
	    		   }
	    		});
	    c.gridy = 0;
	    screenPanel.add(calcScreen, c);
	    
	    resultArea = new JTextField(" = ");
	    resultArea.setEditable(false);
	    resultArea.setBackground(null);
	    resultArea.setBorder(null);
	    resultArea.setFont(new Font("SansSerif", Font.BOLD, 20));
	    resultArea.setPreferredSize(new Dimension(400, 30));
	    c.gridy = 1;
	    screenPanel.add(resultArea, c);
	    
	    //screenPanel.setPreferredSize(new Dimension(400, 200));
	    add(screenPanel, c);
	    
	    buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(6, 5));
	    buttonPanel.setPreferredSize(new Dimension(450,378));
	    createKeyRows();
	    
	    c.gridy = 2;
	    add(buttonPanel, c);
	    pack();
	    setVisible(true);
	}
	
	private void createKeyRows()
	{
		createKeyRow1();
	    createKeyRow2();
	    createKeyRow3();
	    createKeyRow4();
	    createKeyRow5();
	    createKeyRow6();
	    
	    Font font = new Font("Arial", Font.PLAIN, 24);
	    for (Component comp : buttonPanel.getComponents()) {
	        if (comp instanceof JButton) {
	            ((JButton)comp).setFont(font);
	        }
	    }
	}
	private void createKeyRow1()
	{
		//creating the buttons for the first row
	    functionExpBttn = new JButton("^");
	    functionExpBttn.addActionListener(basic);
	    functionSinBttn = new JButton("sin");
	    functionSinBttn.addActionListener(func);
	    functionCosBttn = new JButton("cos");
	    functionCosBttn.addActionListener(func);
	    functionTanBttn = new JButton("tan");
	    functionTanBttn.addActionListener(func);
	    undoButton = new JButton("undo");
	    undoButton.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			calcScreen.setText(prevString);
    		}
    	});
	    buttonPanel.add(functionExpBttn);
	    buttonPanel.add(functionSinBttn);
	    buttonPanel.add(functionCosBttn);
	    buttonPanel.add(functionTanBttn);
	    buttonPanel.add(undoButton);
	}
	private void createKeyRow2()
	{
		functionRootBttn = new JButton("sqrt");
	    functionRootBttn.addActionListener(func);
	    inputParLBttn = new JButton("(");
	    inputParLBttn.addActionListener(basic);
	    inputParRBttn = new JButton(")");
	    inputParRBttn.addActionListener(basic);
	    utilBackspaceBttn = new JButton("bksp");
	    utilBackspaceBttn.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			String s = calcScreen.getText();
    			if (s.length() != 0) {
    			      s = s.substring(0, s.length()-1);
    			      calcScreen.setText(s);
    			    }
    		}
    	});
	    utilClearBttn = new JButton("C");
	    utilClearBttn.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			calcScreen.setText("");
    		}
    	});
	    buttonPanel.add(functionRootBttn);
	    buttonPanel.add(inputParLBttn);
	    buttonPanel.add(inputParRBttn);
	    buttonPanel.add(utilBackspaceBttn);
	    buttonPanel.add(utilClearBttn);
	}
	private void createKeyRow3(){
		functionLogBttn = new JButton("log");
		functionLogBttn.addActionListener(func);
		num7Bttn = new JButton("7");
		num7Bttn.addActionListener(basic);
		num8Bttn = new JButton("8");
		num8Bttn.addActionListener(basic);
		num9Bttn = new JButton("9");
		num9Bttn.addActionListener(basic);
		operatorDivideBttn = new JButton("/");
		operatorDivideBttn.addActionListener(basic);
	    buttonPanel.add(functionLogBttn);
	    buttonPanel.add(num7Bttn);
	    buttonPanel.add(num8Bttn);
	    buttonPanel.add(num9Bttn);
	    buttonPanel.add(operatorDivideBttn);
	}
	private void createKeyRow4(){
		functionNaturalLogBttn = new JButton("ln");
		functionNaturalLogBttn.addActionListener(func);
		num4Bttn = new JButton("4");
		num4Bttn.addActionListener(basic);
		num5Bttn = new JButton("5");
		num5Bttn.addActionListener(basic);
		num6Bttn = new JButton("6");
		num6Bttn.addActionListener(basic);
		operatorMultiplyBttn = new JButton("*");
		operatorMultiplyBttn.addActionListener(basic);
	    buttonPanel.add(functionNaturalLogBttn);
	    buttonPanel.add(num4Bttn);
	    buttonPanel.add(num5Bttn);
	    buttonPanel.add(num6Bttn);
	    buttonPanel.add(operatorMultiplyBttn);
	}
	private void createKeyRow5(){
		utilMemStoreBttn = new JButton("M");
		utilMemStoreBttn.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			//mem store
    		}
    	});
		num1Bttn = new JButton("1");
		num1Bttn.addActionListener(basic);
		num2Bttn = new JButton("2");
		num2Bttn.addActionListener(basic);
		num3Bttn = new JButton("3");
		num3Bttn.addActionListener(basic);
		operatorSubtractBttn = new JButton("-");
		operatorSubtractBttn.addActionListener(basic);
	    buttonPanel.add(utilMemStoreBttn);
	    buttonPanel.add(num1Bttn);
	    buttonPanel.add(num2Bttn);
	    buttonPanel.add(num3Bttn);
	    buttonPanel.add(operatorSubtractBttn);
	}
	private void createKeyRow6(){
		utilMemRecallBttn = new JButton("MR");
		utilMemRecallBttn.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			//recall memory
    		}
    	});
		inputDecBttn = new JButton(".");
		inputDecBttn.addActionListener(basic);
		num0Bttn = new JButton("0");
		num0Bttn.addActionListener(basic);
		utilEqualsBttn = new JButton("=");
		utilEqualsBttn.setBackground(Color.YELLOW);
		utilEqualsBttn.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			resultArea.setText(String.format(" = %1$.4f", Calculator.eval(calcScreen.getText())));
    		}
    	});
		operatorAddBttn = new JButton("+");
		operatorAddBttn.addActionListener(basic);
	    buttonPanel.add(utilMemRecallBttn);
	    buttonPanel.add(num0Bttn);
	    buttonPanel.add(inputDecBttn);
	    buttonPanel.add(utilEqualsBttn);
	    buttonPanel.add(operatorAddBttn);
	}
	
	private String append(String base, String add)
	{
		return base + add;
	}
	
	public void input(String in, String destination)
	{
		if(destination.equals("screen"))
		{
			prevString = calcScreen.getText();
			calcScreen.setText(append(calcScreen.getText(), in));
		}
		else if(destination.equals("result"))
			resultArea.setText(append("= ", in));
	}
	
	private class GenericListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton) {
				input(((JButton)e.getSource()).getText(), "screen");
            }
			
		}
	}
	private class FunctionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton) {
				prevString = calcScreen.getText();
    			calcScreen.setText(append(calcScreen.getText(), ((JButton)e.getSource()).getText()));
    			calcScreen.setText(append(calcScreen.getText(), "("));
            }
			
		}
	}
	
}


