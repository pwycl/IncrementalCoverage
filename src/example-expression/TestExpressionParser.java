

import gov.nasa.jpf.jdart.token.symb.ExpressionToken;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jfuzz.JFuzz;
import monitor.MonitorWithDFA;
import property.analysis.Property;
import property.analysis.PropertyAnalysis;
import property.guided.tests.PropertyGuidedSEAbstractTest;
import test.expression.ExpressionConfig;
import util.Global;
import automata.State;
import automata.Transition;
import automata.fsa.FSATransition;
import automata.fsa.FiniteStateAutomaton;
import automata.fsa.NFAToDFA;

public class TestExpressionParser extends PropertyGuidedSEAbstractTest{

	public static String parseName="expression";
	
	public static void main(String[] args) {
		/**args for jdart*/
		String symMethod = "test.expression.TestExpression.start()";
		String symMethodSig = "test.expression.TestExpression.start()";
		String classname = "test.expression.TestExpression";
		
		/**args for static analysis*/
		String includeFile = "src/example-expression/Include.txt";
		String exclusionFile = "src/example-expression/Exclusions.txt";

		String mainClassName = "Ltest/expression/TestExpression";
		
		Global.USE_LAST_VALUE = false;
		Global.DEBUG = true;
		Global.isTokenSymb=true;
		Global.isCharSymb = true;
		Global.isASCIItext = true;
		Global.genTokenStringByConcolic=true;
		Global.TokenLengthBound = 3;
		Global.stage1_concolicTime = 5;
		
//		Global.ParserPackage.add("org.lsmp");
		Global.ParserPackage.add("org.nfunk");
		
		try {
			Global.CoveredInstr=new PrintStream(parseName+"_Cover"+".log");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Redirect output to a file
//		try {
//			PrintStream print=new PrintStream(parseName+".log");
//			System.setOut(print);
//		} catch (FileNotFoundException e) {}
		
//		if(ExpressionConfig.SYMB_FLAG && ExpressionConfig.TOKEN_SYMB)
		if(Global.isTokenSymb)
		{
			Global.MaxToken=ExpressionToken.tokenImage.length-1;
			Global.MinToken=7;
			Integer[] not_in_token = {8, 10, 13, 14, 15, 16, 17};
			Global.not_in_token.addAll(Arrays.asList(not_in_token));
			Global.undef_length_tokens.addAll(Arrays.asList(new Integer[]{7}));
		}
		
		File file=new File(parseName+".input");
		file.delete();
		
		if (args.length < 5) {
			args = new String[]{"0", "0", "0", "10000", "0,0,10,0"};
		}
		
		initArgs(args);
		
		String[] testArgs = createArgsExpression(null, symMethod, symMethodSig, classname, iterationNum, iterationPeriod,
				includeFile, exclusionFile, mainClassName, callStringBound, propertyGuidedSE, refineAnalysisResult);

		TestExpressionParser tester = new TestExpressionParser();
		tester.startTest(testArgs);
	}

	/**
	 * a call back function, used to set the property in the PropertyAnalysis
	 * */
	@Override
	public void setProperty() {
		// now only construct a monitor by hand
		FiniteStateAutomaton dfa = getForwardFSAAntlr();
		
		MonitorWithDFA forwardMonitor = new MonitorWithDFA(dfa);//com.alibaba.fastjson.parser
		//forwardMonitor.addSensitiveEvent("Lcom/alibaba/fastjson/parser/DefaultJSONParser;", "start()V");
		forwardMonitor.addSensitiveEvent("Lorg/nfunk/jep/Parser;", "e1()V");
		forwardMonitor.addMethodNameChar("e1()V", 'S');
		//forwardMonitor.addSensitiveEvent("Lcom/alibaba/fastjson/parser/DefaultJSONParser;", "end()V");
		forwardMonitor.addSensitiveEvent("Lorg/nfunk/jep/Parser;", "e2()V");
		forwardMonitor.addMethodNameChar("e2()V", 'E');
		//important		
		PropertyAnalysis.property = new Property(forwardMonitor);
	}
	
	public static FiniteStateAutomaton getForwardFSAAntlr() {
		//create a FSA
		FiniteStateAutomaton nfa = new FiniteStateAutomaton();
		State s0 = nfa.createState(new Point(0,0)); // start
		s0.setLabel("0");
		nfa.setInitialState(s0);
		State s1 = nfa.createState(new Point(0,0));
		s1.setLabel("1");
		State s2 = nfa.createState(new Point(0,0));
		s2.setLabel("2");
		nfa.addFinalState(s2);

		List<Transition> trans = new ArrayList<Transition>();
		
		trans.add(new FSATransition(s0, s1, "S"));
		trans.add(new FSATransition(s1, s2, "E"));

		for(Transition t : trans) {
			nfa.addTransition(t);
		}

		//deterministic
		NFAToDFA to = new NFAToDFA();
				
		FiniteStateAutomaton dfa = to.convertToDFA(nfa);
				
		Global.shortestPathLength.put(s0.getID(), 2);
		Global.shortestPathLength.put(s1.getID(), 1);
		Global.shortestPathLength.put(s2.getID(), 0);
				
		return dfa;

	}
	
	public static String[] createArgsExpression(String inputFile, 
			String symMethod,
			String symMethodSig, 
			String className, 
			int numExec,
			String period,
			String analysisInputFile, 
			String analysisExclusionFile,
			String mainClassname, 
			int callStringBound, 
			boolean propertyGuidedSE,
			boolean refineAnalysisResult) {
		return new String[] {"+" + JFuzz.JFUZZ_INPUT_PROP + "=" + inputFile, 
				"+jpf.basedir=../jpf-core",
				"+symbolic.dp=z3bitvec",
                "+classpath=build/example-expression",
				"+vm.insn_factory.class=gov.nasa.jpf.jdart.ConcolicInstructionFactory",
				"+listener=jfuzz.ConcolicListener,monitor.MonitorListener,gov.nasa.jpf.vm.JVMForwarder",
				"+symbolic.method="  + symMethod,
				"+search.class=gov.nasa.jpf.search.Simulation",
				"+jpf.report.console.finished=",
				numExec != -1? "+" + JFuzz.JFUZZ_NUM_EXEC + "=" + numExec:
				"+" + JFuzz.JFUZZ_TIME_EXEC + "=" + period,
				"+" + JFuzz.JFUZZ_NO_DEL + "=",
				"+" + "perturb.params=bar",
				"+" + "perturb.bar.method=" + symMethodSig,
				"+" + "perturb.class=" + "jfuzz.Producer",
				"+target=" + className, 
				"+target_args=" + inputFile,
				"+include.file=" + analysisInputFile,
				"+exclusion.file=" + analysisExclusionFile,
				"+main.class.name=" + mainClassname,
				"+call.string.bound=" + callStringBound,
				"+property.guided.symbolic.execution=" + propertyGuidedSE,
				"+refine.analysis.result=" + refineAnalysisResult,
				
                "+nhandler.clean=true",
                "+native_classpath=build/example-expression",
                "+nhandler.delegateUnhandledNative=true",
                "+nhandler.resetVMState=false",
                "+nhandler.spec.delegate=java.lang.Class.getProtectionDomain",
				"+fuzzing.filter.exception=lang.Error,TokenMgrError,ParseException,LookaheadSuccess,java.io.IOException", //ParseException
//                "+fuzzing.noDisplay.exception=org.nfunk.jep.ParseException", //org.nfunk.jep.TokenMgrError",
//                "+nhandler.spec.delegate=com.alibaba.fastjson.JSON.toJSONString"
		};
	}

}
