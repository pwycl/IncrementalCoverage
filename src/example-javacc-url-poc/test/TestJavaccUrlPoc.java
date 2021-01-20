package test;

import gov.nasa.jpf.jdart.SymbolicString;

import java.io.IOException;
import java.io.StringReader;

import gov.nasa.jpf.jdart.Debug;
import gov.nasa.jpf.jdart.SymbolicString;
import io.mikael.poc.*;

public class TestJavaccUrlPoc {
	public static void main(String[] args){
		start();
	}
	public static void start(){
	    String s= "http://a_host:12345/a_path?k1=v1&k2=v2#/a_fragment?f1_p=f1_v&f2_p=f2_v";

	    s = SymbolicString.makeConcolicString(s);
	    StringReader sr = new StringReader(s);
		System.out.println(s);
		try {
			UrlParser.Result r = UrlParser.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
