
public class Main {
	
	public PeriodicWindow p;
	
	public static void main(String[] args){
		PeriodicTable p = new PeriodicTable();
		CalcWindow c = new CalcWindow();
		FormulaReader f = new FormulaReader();
		System.out.println(f.getEquation("CH3CONHC6H4OC2H5"));
		System.out.println(Calculator.eval(f.getEquation("CH3CONHC6H4OC2H5")));
	}
}
