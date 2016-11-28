public class Element 
{
    private String nameFull;
    private String nameShort;
    private int atomicNumber;
    private double atomicWeight;
    private int elementGroup;
    private int elementPeriod;
    private String elementFamily;
	
    public Element()
    {
    	setFullName("");
    	setShortName("");
    	setAtomicNumber(0);
    	setAtmoicWeight(0);
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
    public int getElementPeriod()
    {
        return elementPeriod;
    }
    public String getElementFamily()
    {
        return elementFamily;
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
    public void setElementPeriod(int period)
    {
        elementPeriod = period;
    }
    public void setElementFamily(String family)
    {
        elementFamily = family;
    }
}
