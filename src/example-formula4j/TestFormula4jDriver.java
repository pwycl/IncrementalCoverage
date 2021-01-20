import coverage.SubjectExecutor;
import hirondelle.formula.Decimal;
import hirondelle.formula.Formula;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

public class TestFormula4jDriver extends SubjectExecutor{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		packagePrefix = "hirondelle.formula";
		inputFileName = args[0];
		if (args.length > 1){
			isBrief = args[1].equals("1") ? true : false;
		}
		new TestFormula4jDriver().wrapExecute();
	}
	@Override
	public void execute(String input) throws Throwable {
		try {
			stage1_2(input);
		}catch (Throwable e){}
	}

	void stage1_2(String s) {

		StringReader sr = new StringReader(s);
//		System.out.println(s);
		Formula formula = new Formula(s);
		Map<String, Decimal> actual = formula.getVariableValues();
	}
}
