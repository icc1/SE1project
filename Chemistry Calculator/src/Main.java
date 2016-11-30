
public class Main {
	
	public PeriodicWindow p;
	
	public static void main(String[] args){
		PeriodicTable p = new PeriodicTable();
		CalcWindow c = new CalcWindow();
		FormulaReader f = new FormulaReader();
		System.out.println(f.getEquation("H2O"));
	}
}
