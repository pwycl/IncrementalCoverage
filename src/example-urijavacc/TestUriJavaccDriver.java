import coverage.SubjectExecutor;
import uri.Parser;
import uri.Program;

import java.io.IOException;
import java.io.StringReader;

public class TestUriJavaccDriver extends SubjectExecutor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        packagePrefix = "uri";
        inputFileName = args[0];
        new TestUriJavaccDriver().wrapExecute();
    }

    @Override
    public void execute(String input) throws Throwable {
        try {
            stage1_2(input);
        }catch (Throwable e){}
    }

    void stage1_2(String s) {
        //		s = SymbolicString.makeConcolicString(s);
        StringReader reader = new StringReader(s);

        try {
            Program p = new Parser(reader).translationUnit();
        } catch (uri.ParseException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
        }
    }
}
