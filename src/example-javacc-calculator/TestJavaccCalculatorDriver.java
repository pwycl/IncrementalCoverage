import coverage.SubjectExecutor;

public class TestJavaccCalculatorDriver extends SubjectExecutor {
	public static void main(String[] args) {
		packagePrefix = "hirondelle.formula";
		inputFileName = args[0];
		if (args.length > 1){
			isBrief = args[1].equals("1") ? true : false;
		}
	}

	@Override
	public void execute(String input) throws Throwable {

	}
}
