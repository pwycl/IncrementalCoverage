package test;

import hirondelle.formula.Decimal;
import hirondelle.formula.Formula;

import java.io.StringReader;
import java.util.Map;

public class TestFormula4j {
	public static void main(String[] args){
		new TestFormula4j().start();
	}
	public void start(){
//	    String s= "(sum(3,5) + avg(10,20) - max(2,-100,50,9)) * cos(pi/2) + 1.523e-2 * (8%5) +round(pi, 2) - sqrt(sqrt(16))";

		String s = "(sum(3,5) ";

//	    s = SymbolicString.makeConcolicString(s);
	    StringReader sr = new StringReader(s);
		System.out.println(s);
		Formula formula = new Formula(s);
	    Map<String, Decimal> actual = formula.getVariableValues();
	}
}
