import coverage.SubjectExecutor;
import de.dominicscheurer.fol.model.Formula;
import de.dominicscheurer.fol.model.Term;
import de.dominicscheurer.fol.parser.FOLParser;
import de.dominicscheurer.fol.parser.ParseException;

import java.io.IOException;

public class TestFirstOrderParser extends SubjectExecutor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        packagePrefix = "de.dominicscheurer.fol";
        inputFileName = args[0];
        new TestFirstOrderParser().wrapExecute();
    }

    @Override
    public void execute(String input) throws Throwable {
        try {
            stage1_2(input);
        }catch (Throwable throwable){}
    }

    void stage1_2(String s) throws ParseException {
        Formula formula = FOLParser.parse(s);
        formula.substitute(new Term("d"), new Term("Y"));
    }
}
