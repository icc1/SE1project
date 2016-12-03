package chemistrycalculator;


public class PeriodicTable {
	
	private static Element[] elements = new Element[118];
	
	public PeriodicTable()
	{
		for(int i = 0; i < 118 ; i++)
		{
		    elements[i] = new Element();
		}
		ElementImporter e = new ElementImporter();
		e.elementArrayBuilder();
	}
	
	public static Element getElement(int i)
	{
		return elements[i];
	}
	
	public static Element findElement(String shortName)
	{
		for(int i = 0; i < 118; i++)
		{
			if(elements[i].getShortName().equals(shortName))
				return elements[i];
		}
		return null;
	}
	public static boolean hasElement(String shortName)
	{
		for(int i = 0; i < 118; i++)
		{
			if(elements[i].getShortName().equals(shortName))
				return true;
		}
		return false;
	}
}
