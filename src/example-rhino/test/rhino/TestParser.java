package test.rhino;

import mozilla.javascript.*;

import java.io.StringReader;


public class TestParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestParser().start();
	}

	/**
	 * method for pinpointing the bug
	 */

//	static String src = "[1,2]";
	static String src = " ( /./    . $$$ /./";

	public void start(){
		System.out.println(src);


		StringReader sr = new StringReader(src);
		//StringReader sr = new StringReader("{1:2}");
		TokenStream ts = new TokenStream(sr, null, 1);

		try {
			//Context.enter();
			IRFactory irf = new IRFactory(ts);
			Parser p = new Parser(irf);
//            Object o = p.parse(ts);
			Object o = p.primaryExpr(ts, new Source());
//            Iterator i = null;
//            String s = ((Node)o).toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * The method for pinpointing the bug in toString of Node
	 *
	 */
	public void start1(){
		StringReader sr = new StringReader("[1,2]");
		TokenStream ts = new TokenStream(sr, null, 1);

		try {
			//Context.enter();
			IRFactory irf = new IRFactory(ts);
			Parser p = new Parser(irf);
			//Object o = p.parse(ts);
			Object o = p.primaryExpr(ts, new Source());
//            Iterator i = null;
			String s = ((Node)o).toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
