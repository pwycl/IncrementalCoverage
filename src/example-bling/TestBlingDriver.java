import automata.State;
import automata.Transition;
import automata.fsa.FSATransition;
import automata.fsa.FiniteStateAutomaton;
import automata.fsa.NFAToDFA;
import gov.nasa.jpf.jdart.token.symb.SixpathToken;
import jfuzz.JFuzz;
import monitor.MonitorWithDFA;
import property.analysis.Property;
import property.analysis.PropertyAnalysis;
import property.guided.tests.PropertyGuidedSEAbstractTest;
import util.Global;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestBlingDriver extends PropertyGuidedSEAbstractTest{

	public static void main(String[] args) {
		/**args for jdart*/
		String symMethod = "test.TestBling.start()";
		String symMethodSig = "test.TestBling.start()";
		String classname = "test.TestBling";
		
		/**args for static analysis*/
		String includeFile = "src/example-sixpath/Include.txt";
		String exclusionFile = "src/example-sixpath/Exclusions.txt";

		String mainClassName = "Ltest.TestBling";
//		int callStringBound = 1;
//		boolean propertyGuidedSE = true;
//		boolean refineAnalysisResult = false;
		
		String inputFile = "";

		Global.USE_LAST_VALUE = true;
		Global.DEBUG = false;
		Global.isCharSymb = true;
		Global.isASCIItext = true;
		
		Global.isTokenSymb=true;
		Global.genTokenStringByConcolic=true;
		Global.TokenLengthBound = 3;
		Global.stage1_concolicTime = 10;
		Global.useStage3 = true;
		Global.useTokenCharConstr = true;

		Global.ParserPackage.add("com.cloudability.bling.ast");

//		if(SixpathConfig.SYMB_FLAG && SixpathConfig.TOKEN_SYMB)
		if (Global.isTokenSymb)
		{
			Global.MaxToken= 12;
			Global.MinToken=5;
//			int[] not_in_token={15,17,18,19,20,21,22};
//			for(int not_token:not_in_token){
//				Global.not_in_token.add(not_token);
//			}
		}
		
		if (args.length < 5) {
			args = new String[]{"1", "0", "0", "2000", "0,0,10,0"};
		}
		
		initArgs(args);
		
		String[] testArgs = createArgsSixpath(null, symMethod, symMethodSig, classname, iterationNum, iterationPeriod,
				includeFile, exclusionFile, mainClassName, callStringBound, propertyGuidedSE, refineAnalysisResult);
		TestBlingDriver tester = new TestBlingDriver();
		tester.startTest(testArgs);
	}

	/**
	 * a call back function, used to set the property in the PropertyAnalysis
	 * */
	@Override
	public void setProperty() {
		// now only construct a monitor by hand
		FiniteStateAutomaton dfa = getForwardFSAAntlr();
		
		MonitorWithDFA forwardMonitor = new MonitorWithDFA(dfa);
		forwardMonitor.addSensitiveEvent("Lde/fzi/XPath/Parser/XPathParser;", "e1()V");
		forwardMonitor.addMethodNameChar("e1()V", 'S');
		forwardMonitor.addSensitiveEvent("Lde/fzi/XPath/Parser/XPathParser;", "e2()V");
		forwardMonitor.addMethodNameChar("e2()V", 'E');		
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
	
	public static String[] createArgsSixpath(String inputFile, 
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
                "+classpath=build/example-bling",
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
				"+fuzzing.noDisplay.exception=java.lang.Error,TokenMgrError,ParseException",
				"+fuzzing.filter.exception=java.io.IOException,LookaheadSuccess",
                "+nhandler.clean=true",
                "+native_classpath=build/example-bling",
                "+nhandler.delegateUnhandledNative=true",
                "+nhandler.resetVMState=false",
                "+nhandler.spec.delegate=java.lang.Class.getProtectionDomain"
//                "+nhandler.spec.delegate=com.alibaba.fastjson.JSON.toJSONString"
		};
	}

}
