package test.expression;

import gov.nasa.jpf.jdart.Debug;
import gov.nasa.jpf.jdart.SymbolicString;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;

public class TestExpression {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        try{
            driver();
            Debug.stopForBreakPoint();
        }catch (Throwable e){
            e.printStackTrace();
        }

//        if (ExpressionConfig.SYMB_FLAG && ExpressionConfig.TOKEN_SYMB)
//        if (Debug.isCharSymb() && Debug.isTokenSymb())
        {
//            Debug.splitPC();
            Debug.ProcessPC();
//            Debug.printCurrentPC();
//            Debug.ExitIfBenchmark();
        }
    }

    public static void driver() throws Exception{
        Debug.printTokenStream();
//        String s="4 + 4 + \"a\"";
        String s="1 + 1";
//        char[] in = {0, 0, 0, 0, 0, 49, 43, 124, 124, };
//        String s=String.valueOf(in);

        s = SymbolicString.makeConcolicString(s);

        System.out.println(s);
        JEP myParser = new JEP();
        myParser.addStandardConstants();
        myParser.addStandardFunctions();
        myParser.addComplex();
        myParser.setImplicitMul(true);
        myParser.setAllowAssignment(true);
        myParser.setAllowUndeclared(true);
        Node n1=myParser.parseExpression(s);
    }


}
