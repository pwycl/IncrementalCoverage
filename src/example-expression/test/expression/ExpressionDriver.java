package test.expression;

import coverage.SubjectExecutor;
import mozilla.javascript.tools.shell.Main;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;

import java.io.IOException;

public class ExpressionDriver extends SubjectExecutor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        packagePrefix = "org.nfunk";
        inputFileName = "src/example-expression/TestExpressionParser-TokenSymb-genTokenString-TokenLengthBound3.saveInput";

        new ExpressionDriver().wrapExecute();
    }

    @Override
    public void execute(String input) {
        try {
            running(input);
        }catch (Throwable e){}
    }

    void running(String s){
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
