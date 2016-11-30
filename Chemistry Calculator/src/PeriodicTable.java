
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
			if(elements[i].getShortName() == shortName)
				return elements[i];
		}
		return null;
	}
}
