import javax.swing.JFrame;

public class Main {
	
	private static CalcWindow cw;
	private static PeriodicWindow pw;
	private static MolarMassWindow mm;
	
	public static void main(String[] args){
		PeriodicTable pt = new PeriodicTable();
		cw = new CalcWindow();
		pw = new PeriodicWindow();
		mm = new MolarMassWindow();
	}
	
	public static CalcWindow getCalcWindow()
	{
		return cw;
	}
	public static PeriodicWindow getPeriodicWindow()
	{
		return pw;
	}
	public static MolarMassWindow getMolarMassWindow()
	{
		return mm;
	}
	
}
