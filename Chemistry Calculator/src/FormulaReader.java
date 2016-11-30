import java.io.StringReader;

public class FormulaReader 
{
	public String getEquation(String formula)
	{
		StringBuilder equation = new StringBuilder();
		StringBuilder element = new StringBuilder();
		
		for(int i = 0; i < formula.length(); i++)
		{
			if(Character.isUpperCase(formula.charAt(i)))
			{
				element.append(Character.toString(formula.charAt(i)));
				if(i < formula.length()-1) i++;
				while(!Character.isDigit(formula.charAt(i)) && !Character.isUpperCase(formula.charAt(i)) && i < formula.length() && formula.charAt(i) != '(')
				{
					element.append(Character.toString(formula.charAt(i)));
					i++;
				}
				
				//equation.append(PeriodicTable.findElement(element.toString()).getAtomicWeight());
				element.delete(0, element.length()-1);
				if(!Character.isDigit(formula.charAt(i))) equation.append("+");
			}
			else if(Character.isDigit(formula.charAt(i)))
			{
				equation.append("(");
				equation.append(formula.charAt(i));
				if(i < formula.length()-1) i++;
				while(Character.isDigit(formula.charAt(i)) && i < formula.length())
				{
					equation.append(formula.charAt(i));
					i++;
				}
				equation.append(")+");
			}
			else if(formula.charAt(i) == '(')
			{
				equation.append("(");
				i++;;
			}
			else if(formula.charAt(i) == ')')
			{
				equation.append(")");
				if(i < formula.length()-1) i++;
			}
		}
		
		return equation.toString();
	}
}
