package test.mxparser;

import coverage.SubjectExecutor;
import org.mariuszgromada.math.mxparser.Expression;

import java.io.IOException;

public class mXparserDriver extends SubjectExecutor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        packagePrefix = "org.mariuszgromada.math.mxparser";
//        inputFileName = "src/example-javaparser/TestJavaparserParser-TokenSymb-genTokenString-TokenLengthBound3.saveInput";
        inputFileName = args[0];
        new mXparserDriver().wrapExecute();

//        inputFileName = "src/example-javaparser/TestJavaparserParser.saveInput";
//        new JavaparserDriver().wrapExecute();
    }

    @Override
    public void execute(String input) throws Throwable {
        try {
            running(input);
        }catch (Throwable e){}
    }

    private void running(String input) {
        Expression e1;
        e1 = new Expression(input);
        e1.getBeforeCal();
        e1.remainCal();
    }
}
