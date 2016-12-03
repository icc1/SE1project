package chemistrycalculator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ElementImporter {
	public void elementArrayBuilder()
	{
		try 
		{
			FileInputStream fin = new FileInputStream("elementsAll.txt");
			Scanner fread = new Scanner(fin);
			for(int i = 0; i < 118; i++)
			{
				PeriodicTable.getElement(i).setShortName(fread.next());
				PeriodicTable.getElement(i).setFullName(fread.next());
				PeriodicTable.getElement(i).setAtomicNumber(Integer.parseInt(fread.next()));
				PeriodicTable.getElement(i).setAtmoicWeight(Double.parseDouble(fread.next()));
				PeriodicTable.getElement(i).setElementGroup(Integer.parseInt(fread.next()));
				PeriodicTable.getElement(i).setElementPeriod(Double.parseDouble(fread.next()));
				PeriodicTable.getElement(i).setElementFamily(fread.next().replace('-', ' '));
				PeriodicTable.getElement(i).setElementEtymology(fread.nextLine());
			}
			fread.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
