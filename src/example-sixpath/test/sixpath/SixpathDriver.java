package test.sixpath;

import coverage.SubjectExecutor;
import de.fzi.XPath.Parser.ParseException;
import de.fzi.XPath.Parser.XPathParser;
import test.MarkdownPapersDriver;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class SixpathDriver extends SubjectExecutor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        packagePrefix = "de.fzi.XPath";
        inputFileName = args[0];
        new SixpathDriver().wrapExecute();

//        inputFileName = "src/example-sixpath/TestSixpathParser-TokenSymb-genTokenString-TokenLengthBound3.saveInput";
//        new SixpathDriver().wrapExecute();
    }

    @Override
    public void execute(String input) throws Throwable{
        Reader stream = new StringReader(input);
        XPathParser xpp = new XPathParser(stream);
        xpp.temp(); // can generate constraints! contained sensitive e1!
        xpp.disable_tracing();

        try
        {
            xpp.XPath(); // can generate constraints! contained sensitive e2!
            //System.out.println("Parsed expression: " + expr);
        }
        catch (ParseException e) {
        }
    }
}
