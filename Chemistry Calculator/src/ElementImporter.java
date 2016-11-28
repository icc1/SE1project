import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ElementImporter {
	public static void elementArrayBuilder()
	{
		try 
		{
			FileInputStream fin = new FileInputStream("elements.txt");
			Scanner fread = new Scanner(fin);
			for(int i = 0; i < 118; i++)
			{
				PeriodicTable.getElement(i).setShortName(fread.next());
				PeriodicTable.getElement(i).setFullName(fread.next());
				PeriodicTable.getElement(i).setAtomicNumber(Integer.parseInt(fread.next()));
				PeriodicTable.getElement(i).setAtmoicWeight(Double.parseDouble(fread.nextLine()));
			}
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
