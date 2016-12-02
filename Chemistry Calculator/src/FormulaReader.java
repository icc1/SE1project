import java.io.StringReader;

public class FormulaReader 
{
	public String getEquation(String formula)
	{
		StringBuilder equation = new StringBuilder();
		StringBuilder element = new StringBuilder();
		
		for(int i = 0; i < formula.length();)
		{
			if(i < formula.length() && Character.isUpperCase(formula.charAt(i)))
			{
				element.append(Character.toString(formula.charAt(i)));
				if(i < formula.length()) 
					i++;
				while(i < formula.length() && Character.isLowerCase(formula.charAt(i)))
				{
					element.append(Character.toString(formula.charAt(i)));
					i++;
				}
				if(isError(element.toString()))
					return "Error";
				else
				{
					equation.append(PeriodicTable.findElement(element.toString()).getAtomicWeight());
					//equation.append(element.toString());
					element.setLength(0);
					if(i != formula.length() && !Character.isDigit(formula.charAt(i)) && formula.charAt(i) != ')') 
						equation.append("+");
					else if(i < formula.length() && Character.isDigit(formula.charAt(i)))
						equation.append("*");
				}
			}
			if(i < formula.length() && Character.isDigit(formula.charAt(i)))
			{
				equation.append("(");
				equation.append(formula.charAt(i));
				if(i < formula.length()) 
					i++;
				while(i < formula.length() && Character.isDigit(formula.charAt(i)))
				{
					equation.append(formula.charAt(i));
					i++;
				}
				equation.append(")");
				if(i != formula.length() && formula.charAt(i) != ')') 
					equation.append("+"); 
			}
			if(i < formula.length() && formula.charAt(i) == '(')
			{
				equation.append("(");
				if(i < formula.length()) 
					i++;
			}
			if(i < formula.length() && formula.charAt(i) == ')')
			{
				equation.append(")");
				if(i < formula.length()) 
					i++;
				if(Character.isDigit(formula.charAt(i)))
					equation.append("*");
			}
			if(i < formula.length() && Character.isLowerCase(formula.charAt(i)))
				return "Error";
		}
		
		return equation.toString();
	}
	private boolean isError(String shortName)
	{
		if(PeriodicTable.hasElement(shortName))
			return false;
		else return true;
	}
}
