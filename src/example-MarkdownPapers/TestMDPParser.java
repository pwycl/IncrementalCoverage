

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import gov.nasa.jpf.jdart.Debug;
import gov.nasa.jpf.jdart.token.symb.MarkdownPapersToken;
import jfuzz.JFuzz;
import monitor.MonitorWithDFA;
import automata.State;
import automata.Transition;
import automata.fsa.FSATransition;
import automata.fsa.FiniteStateAutomaton;
import automata.fsa.NFAToDFA;
import property.analysis.Property;
import property.analysis.PropertyAnalysis;
import property.guided.tests.PropertyGuidedSEAbstractTest;
import property.guidedSE.JDartPropertyGuidedSE;
import util.Global;


public class TestMDPParser extends PropertyGuidedSEAbstractTest{
	public static String parserName="MarkdownPapers";
	public static String TestName="TestMarkdownPapers";
	public static void main(String[] args) {
		/**args for jdart*/
		String symMethod = "test."+TestName+".start()";
		String symMethodSig = "test."+TestName+".start()";
		String classname = "test."+TestName;
		
		/**args for static analysis*/
		
		
		String includeFile = "src/example-"+parserName+"/Include.txt";
		String exclusionFile = "src/example-"+parserName+"/Exclusions.txt";

		String mainClassName = "Ltest/"+TestName;

		Global.USE_LAST_VALUE = true;
		Global.DEBUG = false;
		Global.isTokenSymb=false;
		Global.isCharSymb = true;
		Global.genTokenStringByConcolic=true;
		Global.TokenLengthBound = 3;
		Global.isASCIItext = true;
		Global.ParserPackage.add("org.tautua.markdownpapers");

//		if(MarkdownPapersConfig.SYMB_FLAG && MarkdownPapersConfig.TOKEN_SYMB)
		if (Global.isTokenSymb)
		{
			Global.MaxToken= MarkdownPapersToken.tokenImage.length-1;
			Global.MinToken=1;
		}

		if (args.length < 5) {
			args = new String[]{"1", "0", "0", "10000", "0,0,10,0"};
		}
		
		initArgs(args);

		String[] testArgs = createArgsFastJSON(null, symMethod, symMethodSig, classname, iterationNum, iterationPeriod,
				includeFile, exclusionFile, mainClassName, callStringBound, propertyGuidedSE, refineAnalysisResult);

		TestMDPParser tester = new TestMDPParser();
		
		Runtime currRuntime = Runtime.getRuntime ();
		int nFreeMemory = ( int ) (currRuntime.freeMemory() / 1024 / 1024);
		int nTotalMemory = ( int ) (currRuntime.totalMemory() / 1024 / 1024);
		System.out.println( nFreeMemory + "M/" + nTotalMemory +"M(free/total)") ;
		
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
		forwardMonitor.addSensitiveEvent("Ltest/fastjson/TestFastJSON;", "s()V");
		forwardMonitor.addMethodNameChar("s()V", 'S');
		forwardMonitor.addSensitiveEvent("Ltest/fastjson/TestFastJSON;", "e()V");
		forwardMonitor.addMethodNameChar("e()V", 'E');
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
	
	public static String[] createArgsFastJSON(String inputFile, 
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
                "+classpath=build/example-"+parserName,
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
                "+native_classpath=build/example-"+parserName,
                "+nhandler.delegateUnhandledNative=true",
                "+nhandler.resetVMState=false",
				"+fuzzing.filter.exception=Parser$LookaheadSuccess,IOException",
				"+fuzzing.noDisplay.exception=org.tautua.markdownpapers.parser.ParseException",
                "+nhandler.spec.delegate=java.lang.Class.getProtectionDomain"
		};
	}
}
