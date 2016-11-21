public class Element 
{
    private String nameFull;
    private String nameShort;
    private int atomicNumber;
    private double atomicWeight;
	   
	   

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
}
