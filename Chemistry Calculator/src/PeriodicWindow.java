import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PeriodicWindow extends JFrame
{
	JButton[] elementButton;
	JLabel[] miscLabels;
	GridBagConstraints constraints;
	GridBagConstraints infoPanelConstraints;
	JPanel elementPanel;
	
	JPanel infoPanel;
	JLabel infoShortName;
	JLabel infoName;
	JLabel infoAtomicNumber;
	JLabel infoAtomicWeight;
	JLabel infoElementGroup;
	JLabel infoElementPeriod;
	JLabel infoElementFamily;
	JLabel infoEtymologyLabel;
	JTextArea infoElementEtymology;
	
	JButton infoSendToMM;
	JButton infoSendToMW;
	
	public PeriodicWindow()
	{
		super("Periodic Table");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds (455, 0, 400, 600);
		setLayout(new GridBagLayout());
		
		PeriodicListener p = new PeriodicListener();
		
		elementPanel = new JPanel();
		elementPanel.setLayout(new GridBagLayout());
		
		miscLabels = new JLabel[3];//0 = blank, 1 = "57-71", 2 = "89-103"
		miscLabels[0] = new JLabel(" ");
		miscLabels[1] = new JLabel("57-71");
		miscLabels[2] = new JLabel("89-103");
		
		elementButton = new JButton[118];
		int k = 0; //for iterating over the whole array 
		
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		
		for(int i = 0; i < 10; i++)
		{
			constraints.gridy = i;
			for(int j = 0; j < 18; j++)
			{
				constraints.gridx = j;
				if(i == 0 && j == 1)
				{
					constraints.gridwidth = 16;
					elementPanel.add(miscLabels[0], constraints);
					j += 15;
					resetConstraints();
				}
				else if(i == 1 && j == 2)
				{
					constraints.gridwidth = 10;
					elementPanel.add(miscLabels[0], constraints);
					j += 9;
					resetConstraints();
				}
				else if(i == 2 && j == 2)
				{
					constraints.gridwidth = 10;
					elementPanel.add(miscLabels[0], constraints);
					j += 9;
					resetConstraints();
				}
				else if(i == 5 && j == 2)
				{
					elementPanel.add(miscLabels[1], constraints);
				}
				else if(i == 6 && j == 2)
				{
					elementPanel.add(miscLabels[2], constraints);
				}
				else if(i == 7 && j == 0)
				{
					constraints.gridwidth = 18;
					constraints.fill = GridBagConstraints.BOTH;
					elementPanel.add(miscLabels[0], constraints);
					j += 17;
					resetConstraints();
				}
				else if(i == 8 && j == 0)
				{
					constraints.gridwidth = 3;
					elementPanel.add(miscLabels[0], constraints);
					j += 2;
					resetConstraints();
				}
				else if(i == 9 && j == 0)
				{
					constraints.gridwidth = 3;
					elementPanel.add(miscLabels[0], constraints);
					j += 2;
					resetConstraints();
				}
				else if(k < 118)
				{
					
					elementButton[k] = new JButton("<HTML>"+PeriodicTable.getElement(k).getAtomicNumber()+"<br>"+PeriodicTable.getElement(k).getShortName()+"</HTML>");
					elementButton[k].setName(""+k);
					elementButton[k].addActionListener(p);
					colorSetter(k);
					elementPanel.add(elementButton[k], constraints);
					if(k == 55)//skip conditions due to radioactive elements
					{
						k = 71;
					}
					else if(k == 87)
					{
						k = 103;
					}
					else if(k == 117)
					{
						k = 56;
					}
					else if(k == 70)
					{
						k = 88;
					}
					else
						k++;
				}
			}
		}
		
		Font font = new Font("Arial", Font.PLAIN, 24);
	    for (Component comp : elementPanel.getComponents()) {
	        if (comp instanceof JButton) {
	            ((JButton)comp).setFont(font);
	        }
	        else
	        	((JLabel)comp).setFont(font);
	    }
	    
	    constraints.gridx = 0;
		constraints.gridy = 0;
		add(elementPanel, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		infoPanelBuilder();
		add(infoPanel, constraints);
		
		infoPanelGetInfo(1);
		
		pack();
		setVisible(true);
	}
	private void resetConstraints()
	{
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.BOTH;
	}
	private void infoPanelBuilder()
	{
		infoPanelConstraints = new GridBagConstraints();
		infoPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
		
		infoPanelConstraints.gridx = 0;
		infoPanelConstraints.gridy = 0;
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridBagLayout());
		
		infoShortName = new JLabel("<HTML><b><u>  </u></b></HTML>");
		infoShortName.setFont(new Font("Arial", Font.PLAIN, 48));
		infoShortName.setPreferredSize(new Dimension(250, 50));
		
		Font infoPanelFont = new Font("Arial", Font.PLAIN, 20);
		
		infoName = new JLabel("<HTML><b>Name:</b></HTML>");
		infoName.setFont(infoPanelFont);
		
		infoAtomicNumber = new JLabel("<HTML><b>Atomic Number:</b></HTML>");
		infoAtomicNumber.setFont(infoPanelFont);
		
		infoAtomicWeight = new JLabel("<HTML><b>Atomic Weight:</b></HTML>");
		infoAtomicWeight.setFont(infoPanelFont);
		
		infoElementGroup = new JLabel("<HTML><b>Element Group:</b></HTML>");
		infoElementGroup.setFont(infoPanelFont);
		
		infoElementPeriod = new JLabel("<HTML><b>Element Period:</b></HTML>");
		infoElementPeriod.setFont(infoPanelFont);
		
		infoElementFamily = new JLabel("<HTML><b>Element Family:</b></HTML>");
		infoElementFamily.setFont(infoPanelFont);
		
		infoEtymologyLabel = new JLabel("<HTML><b>Element Etymology:</b></HTML>");
		infoEtymologyLabel.setFont(infoPanelFont);
		
		infoElementEtymology = new JTextArea(" ");
		infoElementEtymology.setPreferredSize(new Dimension(250, 200));
		infoElementEtymology.setLineWrap(true);
		infoElementEtymology.setWrapStyleWord(true);
		infoElementEtymology.setBackground(null);
		infoElementEtymology.setEditable(false);
		infoElementEtymology.setFont(infoPanelFont);
		
		infoSendToMM = new JButton("Molar Mass");
		infoSendToMM.setFont(infoPanelFont);
		infoSendToMM.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if(!Main.getMolarMassWindow().isVisible())
    				Main.getMolarMassWindow().setVisible(true);
    			Main.getMolarMassWindow().input(infoShortName.getName(), true);
    		}
    	});
		
		infoSendToMW = new JButton("Molecular Weight");
		infoSendToMW.setFont(infoPanelFont);
		infoSendToMW.addActionListener(new ActionListener()
    	{
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if(!Main.getMolecularWeightWindow().isVisible())
    				Main.getMolecularWeightWindow().setVisible(true);
    			Main.getMolecularWeightWindow().input(infoShortName.getName(), true);
    		}
    	});
		
		infoPanelConstraints.weightx = 250;
		infoPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		
		int i = 0;
		infoPanel.add(infoShortName, infoPanelConstraints);
		
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoName, infoPanelConstraints);
		
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoAtomicNumber, infoPanelConstraints);
		
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoAtomicWeight, infoPanelConstraints);
		
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoElementGroup, infoPanelConstraints);
		
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoElementPeriod, infoPanelConstraints);
		
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoElementFamily, infoPanelConstraints);
		
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoEtymologyLabel, infoPanelConstraints);
		
		infoPanelConstraints.weighty = 50;
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoElementEtymology, infoPanelConstraints);
		infoPanelConstraints.weighty = 0;
		
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoSendToMM, infoPanelConstraints);
		
		infoPanelConstraints.gridy = ++i;
		infoPanel.add(infoSendToMW, infoPanelConstraints);
		
	}
	private void infoPanelGetInfo(int i)
	{
		infoShortName.setText("<HTML><b><u>  "+ PeriodicTable.getElement(i).getShortName() +"</u></b></HTML>");
		infoShortName.setName(PeriodicTable.getElement(i).getShortName());
		infoName.setText("<HTML><b> Name:</b>" + PeriodicTable.getElement(i).getFullName() + "</HTML>");
		infoAtomicNumber.setText("<HTML><b> Atomic Number: </b><br> " + PeriodicTable.getElement(i).getAtomicNumber() + "</HTML>");
		infoAtomicWeight.setText("<HTML><b> Atomic Weight: </b><br> " + PeriodicTable.getElement(i).getAtomicWeight() + "</HTML>");
		infoElementGroup.setText("<HTML><b> Element Group: </b><br> " + PeriodicTable.getElement(i).getElementGroup() + ".0</HTML>");
		infoElementPeriod.setText("<HTML><b> Element Period: </b><br> " + PeriodicTable.getElement(i).getElementPeriod() + "</HTML>");
		infoElementFamily.setText("<HTML><b> Element Family: </b><br> " + PeriodicTable.getElement(i).getElementFamily() + "</HTML>");
		infoElementEtymology.setText(PeriodicTable.getElement(i).getElementEtymology());
		
	}
	private void colorSetter(int i)
	{
		String name = PeriodicTable.getElement(i).getElementFamily();
		if(name.equals("Non Metals"))
			elementButton[i].setBackground(new Color(204, 255, 153));
		else if(name.equals("Nobel Gases"))
			elementButton[i].setBackground(new Color(153, 204, 255));
		else if(name.equals("Alkali Metals"))
			elementButton[i].setBackground(new Color(255, 204, 0));
		else if(name.equals("Alkaline Earth Metals"))
			elementButton[i].setBackground(new Color(255, 255, 153));
		else if(name.equals("Metalloids"))
			elementButton[i].setBackground(new Color(102, 255, 204));
		else if(name.equals("Halogens"))
			elementButton[i].setBackground(new Color(153, 255, 204));
		else if(name.equals("Other Metals"))
			elementButton[i].setBackground(new Color(102, 204, 255));
		else if(name.equals("Transition Metals"))
			elementButton[i].setBackground(Color.pink);
		else if(name.equals("Rare Earth Actinide"))
			elementButton[i].setBackground(new Color(255, 204, 153));
		else if(name.equals("Rare Earth Lanthanide"))
			elementButton[i].setBackground(new Color(255, 204, 204));
	}
	private class PeriodicListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton) {
				infoPanelGetInfo((Integer.parseInt(((JButton)e.getSource()).getName())));
            }
			
		}
	}
}
