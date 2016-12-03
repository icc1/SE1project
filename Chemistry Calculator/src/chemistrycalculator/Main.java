package chemistrycalculator;

import javax.swing.JFrame;

public class Main {
	
	private static CalcWindow calcWindowInstance;
	private static PeriodicWindow periodicWindowInstance;
	private static MolarMassWindow molarMassWindowInstance;
	private static MolecularWeightWindow molecularWeightWindowInstance;
	
	public static void main(String[] args){
		PeriodicTable pt = new PeriodicTable();
		calcWindowInstance = new CalcWindow();
		periodicWindowInstance = new PeriodicWindow();
		molarMassWindowInstance = new MolarMassWindow();
		molecularWeightWindowInstance = new MolecularWeightWindow();
	}
	
	public static CalcWindow getCalcWindow()
	{
		return calcWindowInstance;
	}
	public static PeriodicWindow getPeriodicWindow()
	{
		return periodicWindowInstance;
	}
	public static MolarMassWindow getMolarMassWindow()
	{
		return molarMassWindowInstance;
	}
	public static MolecularWeightWindow getMolecularWeightWindow()
	{
		return molecularWeightWindowInstance;
	}
	
}
