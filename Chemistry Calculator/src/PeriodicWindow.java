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
		infoPanelConstraints.fill = GridBagConstraints.BOTH;
		
		infoPanelConstraints.gridx = 0;
		infoPanelConstraints.gridy = 0;
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridBagLayout());
		
		infoShortName = new JLabel("<HTML><b><u>  </u></b></HTML>");
		infoShortName.setFont(new Font("Arial", Font.PLAIN, 48));
		infoPanel.add(infoShortName);
		
		Font infoPanelFont = new Font("Arial", Font.PLAIN, 20);
		
		infoName = new JLabel("<HTML><b>Name:</b></HTML>");
		infoName.setFont(infoPanelFont);
		
		infoAtomicNumber = new JLabel("<HTML><b>Atomic Number:</b></HTML>");
		infoAtomicNumber.setFont(infoPanelFont);
		
		infoAtomicWeight = new JLabel("<HTML><b>Atomic Weight:</b></HTML>");
		infoAtomicWeight.setFont(infoPanelFont);
		
		infoPanel.add(infoShortName, infoPanelConstraints);
		
		infoPanelConstraints.gridy = 1;
		infoPanel.add(infoName, infoPanelConstraints);
		
		infoPanelConstraints.gridy = 2;
		infoPanel.add(infoAtomicNumber, infoPanelConstraints);
		
		infoPanelConstraints.gridy = 3;
		infoPanel.add(infoAtomicWeight, infoPanelConstraints);
	}
	private void infoPanelGetInfo(int i)
	{
		infoShortName.setText("<HTML><b><u>  "+ PeriodicTable.getElement(i).getShortName() +"</u></b></HTML>");
		infoName.setText("<HTML><b> Name:</b>" + PeriodicTable.getElement(i).getFullName() + "</HTML>");
		infoAtomicNumber.setText("<HTML><b> Atomic Number:</b>" + PeriodicTable.getElement(i).getAtomicNumber() + "</HTML>");
		infoAtomicWeight.setText("<HTML><b> Atomic Weight:</b>" + PeriodicTable.getElement(i).getAtomicWeight() + "</HTML>");
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
