
public class PeriodicTable {
	
	private static Element[] elements = new Element[118];
	
	public PeriodicTable()
	{
		for(int i = 0; i < 118 ; i++)
		{
		    elements[i] = new Element();
		}
		ElementImporter.elementArrayBuilder();
	}
	
	public static Element getElement(int i)
	{
		return elements[i];
	}
	
}
