package test;

import gov.nasa.jpf.jdart.SymbolicString;

import java.io.IOException;
import java.io.StringReader;
import gov.nasa.jpf.jdart.Debug;
import gov.nasa.jpf.jdart.SymbolicString;
import com.cloudability.bling.ast.*;

public class TestBling {
	public static void main(String[] args){
		start();
	}
	public static void start(){
	    String s= "2.5e2 / 1.25e-2";

	    s = SymbolicString.makeConcolicString(s);
	    StringReader sr = new StringReader(s);
		System.out.println(s);
		BlingParser parser = new BlingParser(sr);
    	Expression e = parser.parse();
	}
}
