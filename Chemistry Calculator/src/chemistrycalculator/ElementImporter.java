package chemistrycalculator;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import javax.annotation.Resource;

public class ElementImporter {
	public void elementArrayBuilder()
	{
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("ElementsAll.txt");//reads file, assigns values to element array
		Scanner fread = new Scanner(is);
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
}
