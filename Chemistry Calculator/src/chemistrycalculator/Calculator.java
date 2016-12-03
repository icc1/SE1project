package chemistrycalculator;

import java.lang.Math;

public class Calculator 
{
	public static double eval(final String str)//this function is licensed under the CC0 license, original function from Boann @ stackoverflow, modifications made by Ian Connolly
	{ 
	    return new Object() 
	    {
	        int pos = -1, ch;

	        void nextChar() 
	        {
	            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	        }

	        boolean eat(int charToEat) 
	        {
	            while (ch == ' ') nextChar();
	            if (ch == charToEat) 
	            {
	                nextChar();
	                return true;
	            }
	            return false;
	        }

	        double parse() 
	        {
	            nextChar();
	            double x = parseExpression();
	            if (pos < str.length())
	            {
	            	return 0;
	            }
	            return x;
	        }

	        // Grammar:
	        // expression = term | expression `+` term | expression `-` term
	        // term = factor | term `*` factor | term `/` factor
	        // factor = `+` factor | `-` factor | `(` expression `)`
	        //        | number | functionName factor | factor `^` factor

	        double parseExpression() 
	        {
	            double x = parseTerm();
	            for (;;) 
	            {
	                if      (eat('+')) x += parseTerm(); // addition
	                else if (eat('-')) x -= parseTerm(); // subtraction
	                else return x;
	            }
	        }

	        double parseTerm() 
	        {
	            double x = parseFactor();
	            for (;;) 
	            {
	                if      (eat('*')) x *= parseFactor(); // multiplication
	                else if (eat('/')) x /= parseFactor(); // division
	                else return x;
	            }
	        }

	        double parseFactor() 
	        {
	            if (eat('+')) return parseFactor(); // unary plus
	            if (eat('-')) return -parseFactor(); // unary minus

	            double x;
	            int startPos = this.pos;
	            if (eat('(')) { // parentheses
	                x = parseExpression();
	                eat(')');
	            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
	                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
	                x = Double.parseDouble(str.substring(startPos, this.pos));
	            } else if (ch >= 'a' && ch <= 'z') { // functions
	                while (ch >= 'a' && ch <= 'z') nextChar();
	                String func = str.substring(startPos, this.pos);
	                x = parseFactor();
	                if (func.equals("sin")) x = sin(x);
	                else if (func.equals("cos")) x = cos(x);
	                else if (func.equals("tan")) x = tan(x);
	                else if (func.equals("ln")) x = log(x);
	                else if (func.equals("log")) x = log10(x);
	                else throw new RuntimeException("Unknown function: " + func);
	            } else {
	                throw new RuntimeException("Unexpected: " + (char)ch);
	            }

	            if (eat('^')) x = exp(x, parseFactor()); // exponentiation

	            return x;
	        }
	    }.parse();
	}
	
    public static double cos(double a)
    {
        return Math.cos(a);
    }
    
    public static double tan(double a)
    {
        return Math.tan(a);
    }
    
    public static double sin(double a)
    {
        return Math.sin(a);
    }
    
    public static double log(double a)
    {
        return Math.log(a);
    }
    
    public static double log10(double a)
    {
        return Math.log10(a);
    }
    
    public static double exp(double base, double power)
    {
        return Math.pow(base, power);
    }
}
