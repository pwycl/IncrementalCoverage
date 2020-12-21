

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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
import slice.PathSlicer;
import util.Global;

public class TestExpressionParserWithSlicing extends PropertyGuidedSEAbstractTest{

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
		Global.DEBUG = false;
		Global.experimentMode=false; // if  true, then the pruned branches can still run!
		Global.predictMode=true;
		Global.enhanced=true;
		
		if (args.length < 5) {
			args = new String[]{"1", "1", "1", "400", "0,0,3600,0","","1"};
		}
		
		initArgs(args); 
		
		String[] testArgs = createArgsExpression(null, symMethod, symMethodSig, classname, iterationNum, iterationPeriod,
				includeFile, exclusionFile, mainClassName, callStringBound, propertyGuidedSE, refineAnalysisResult);

		TestExpressionParserWithSlicing tester = new TestExpressionParserWithSlicing();
		// set config
		String Events[] = new String[]{
				"e1()V",
				"e2()V"
		};
		String mainclass="Ltest/expression/TestExpression";
		String Methods[] = new String[]{
				"test.expression.TestExpression.main([Ljava/lang/String;)V",
				"test.expression.TestExpression.start()V",
				"parseExpression",
				"parseStream",
				"org.nfunk.jep.Parser.Start()Lorg/nfunk/jep/ASTStart;",
				"backup",
				"readChar",
				"readChar1",
				"AdjustBuffSize",
				"Expression",
				//"jj_", 
				"jj_2",
				"jj_3",
				"jj_ntk",
				"jj_consume_token",
				"jj_add_error_token",
				"jj_rescan_token",
				"jj_save",
				"jj_scan_token",
				"getNextToken",
				"BeginToken",
				"jjFillToken",
				"jjMoveStringLiteralDfa",
				"jjStopAtPos",
				"jjMoveNfa",
				"jjCheckNAddTwoStates",
				"jjCheckNAdd",
				"jjCheckNAddStates",
				"jjAddStates",
				"jj_consume_token",
				"jjCanMove",
				"ArgumentList",
				"org.nfunk.jep.Parser.Function()V",
				"Identifier",
				"LValue",
				"RealConstant",
				//"ReInit",
				"org.nfunk.jep.Parser.Variable()V",
				"FillBuff",
				"ReadByte",
				"ArrayAccess",
				"AnyConstant"
		};
		String include=  "src/example-expression/Include.txt";
		String exclusion = "src/example-expression/Exclusions.txt";
		PathSlicer.config.Set(Events, mainclass,Methods,include,exclusion);
		// set end!
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
				"+fuzzing.filter.exception=LookaheadSuccess,java.io.IOException",
                "+nhandler.clean=true",
                "+native_classpath=build/example-expression",
                "+nhandler.delegateUnhandledNative=true",
                "+nhandler.resetVMState=false",
                "+nhandler.spec.delegate=java.lang.Class.getProtectionDomain",
                "+property.slicing.symbolic.execution=" + PropertyGuidedSEAbstractTest.doSlicing
//                "+nhandler.spec.delegate=com.alibaba.fastjson.JSON.toJSONString"
		};
	}

}
