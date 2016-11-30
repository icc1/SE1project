
public class Main {
	
	public PeriodicWindow p;
	
	public static void main(String[] args){
		PeriodicTable p = new PeriodicTable();
		CalcWindow c = new CalcWindow();
		FormulaReader f = new FormulaReader();
		System.out.println(f.getEquation("Na3(Pb2H(O4)2)2"));
		System.out.println(Calculator.eval(f.getEquation("Na3(Pb2H(O4)2)2")));
	}
}
