package test;

import gov.nasa.jpf.jdart.SymbolicString;

import java.io.IOException;
import java.io.StringReader;
import gov.nasa.jpf.jdart.Debug;
import gov.nasa.jpf.jdart.SymbolicString;
import com.braxisltd.calculator.*;

public class TestJavaccCalculator {

	private ArithmeticParser parser;

	public static void main(String[] args){
		new TestJavaccCalculator().start();
	}
	public void start(){
		stage1_2();
		Debug.setValidInputTrue();
		Debug.prepareForStage3();
		stage3();
	}

	private void stage3() {
		Value v = parser.evaluate();
	}

	private void stage1_2() {
		String s= "999 + 1.0";

		s = SymbolicString.makeConcolicString(s);
		StringReader sr = new StringReader(s);
		System.out.println(s);
		parser = new ArithmeticParser(sr);
		try {
			parser.parse();
		} catch (ParseException e) {
//			e.printStackTrace();
		}
	}
}
