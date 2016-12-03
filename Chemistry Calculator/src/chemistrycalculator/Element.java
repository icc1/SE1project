package chemistrycalculator;

public class Element 
{
    private String nameFull;
    private String nameShort;
    private int atomicNumber;
    private double atomicWeight;
    private int elementGroup;
    private double elementPeriod;
    private String elementFamily;
    private String elementEtymology;
	
    public Element()
    {
    	setFullName("");
    	setShortName("");
    	setAtomicNumber(0);
    	setAtmoicWeight(0);
    	setElementGroup(0);
    	setElementPeriod(0);
    	setElementFamily("");
    	setElementEtymology("");
    }
    
    public String getFullName()
    {
        return nameFull;
    }
    public String getShortName()
    {
        return nameShort;
    }
    public int getAtomicNumber()
    {
        return atomicNumber;
    }
    public double getAtomicWeight()
    {
        return atomicWeight;
    }
    public int getElementGroup()
    {
        return elementGroup;
    }
    public double getElementPeriod()
    {
        return elementPeriod;
    }
    public String getElementFamily()
    {
        return elementFamily;
    }
    public String getElementEtymology()
    {
    	return elementEtymology;
    }
    public void setFullName(String name)
    {
        nameFull = name;
    }
    public void setShortName(String name)
    {
        nameShort = name;
    }
    public void setAtomicNumber(int number)
    {
        atomicNumber = number;
    }
    public void setAtmoicWeight(double number)
    {
        atomicWeight = number;
    }
    public void setElementGroup(int group)
    {
        elementGroup = group;
    }
    public void setElementPeriod(double period)
    {
        elementPeriod = period;
    }
    public void setElementFamily(String family)
    {
        elementFamily = family;
    }
    public void setElementEtymology(String etymology)
    {
    	elementEtymology = etymology;
    }
}
