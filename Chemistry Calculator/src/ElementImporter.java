import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ElementImporter {
	public static Element[] elementArrayBuilder()
	{
		Element[] elements = new Element[118];
		for(int i = 0; i < 118 ; i++)
		{
		    elements[i] = new Element();
		}
		try 
		{
			FileInputStream fin = new FileInputStream("elements.txt");
			Scanner fread = new Scanner(fin);
			for(int i = 0; i < 118; i++)
			{
				elements[i].setShortName(fread.next());
				elements[i].setFullName(fread.next());
				elements[i].setAtomicNumber(Integer.parseInt(fread.next()));
				elements[i].setAtmoicWeight(Double.parseDouble(fread.nextLine()));
			}
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return elements;
	}
}
