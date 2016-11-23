import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PeriodicWindow extends JFrame
{
	JButton[] elementButton;
	JLabel[] miscLabels;
	GridBagConstraints constraints;
	JPanel elementPanel;
	JPanel infoPanel;
	
	public PeriodicWindow()
	{
		super("Periodic Table");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Element[] element = ElementImporter.elementArrayBuilder();
		
		elementPanel = new JPanel();
		elementPanel.setLayout(new GridBagLayout());
		
		miscLabels = new JLabel[3];//0 = blank, 1 = "57-71", 2 = "89-103"
		miscLabels[0].setText("");
		miscLabels[1].setText("57-71");
		miscLabels[2].setText("89-103");
		
		elementButton = new JButton[118];
		int k = 0; //for iterating over the whole array 
		
		constraints = new GridBagConstraints();
		
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
					resetConstraints();
				}
				else if(i == 1 && j == 2)
				{
					constraints.gridwidth = 10;
					elementPanel.add(miscLabels[0], constraints);
					resetConstraints();
				}
				else if(i == 2 && j == 2)
				{
					constraints.gridwidth = 10;
					elementPanel.add(miscLabels[0], constraints);
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
					elementPanel.add(miscLabels[0], constraints);
					resetConstraints();
				}
				else if(i == 8 && j == 0)
				{
					constraints.gridwidth = 3;
					elementPanel.add(miscLabels[0], constraints);
					resetConstraints();
				}
				else if(i == 9 && j == 0)
				{
					constraints.gridwidth = 3;
					elementPanel.add(miscLabels[0], constraints);
					resetConstraints();
				}
				else
				{
					elementButton[k].setText(String.format("%d\n%s\n%f", element[k].getAtomicNumber() 
							,element[k].getShortName(), element[k].getAtomicWeight()));
					elementPanel.add(elementButton[k], constraints);
				}
			}
			
			
			
		}
	}
	private void resetConstraints()
	{
		constraints.gridwidth = 1;
	}
}
