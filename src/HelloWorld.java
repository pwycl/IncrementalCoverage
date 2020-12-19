import org.jacoco.agent.rt.internal_e6e56f0.Agent;
import org.jacoco.agent.rt.internal_e6e56f0.core.runtime.AgentOptions;
import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.data.ExecutionDataReader;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;
import test.TestTarget;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class HelloWorld {
    private Agent agent = Agent.getInstance(new AgentOptions());
    private String originalFilePath = "classes";

    public static void main(String[] args) throws IOException {
        new HelloWorld().execute();
    }

    public void execute() throws IOException {

        agent.reset();

        new TestTarget().run();

        ExecutionDataStore execStore = getExecutionDataStore();
        Collection<IClassCoverage> classes = getCoveredClasses(execStore);
        for (final IClassCoverage cc : classes){
            System.out.println("Coverage of class " + cc.getName());
            int missedBranches = cc.getBranchCounter().getMissedCount();
            int totalBranches = cc.getBranchCounter().getTotalCount();
            System.out.printf("%d of %d %s miss\n", missedBranches,totalBranches,"branches");
        }
    }

    private ExecutionDataStore getExecutionDataStore() throws IOException{
        byte[] executionData = agent.getExecutionData(false);
        ExecutionDataReader executionDataReader = new ExecutionDataReader(new ByteArrayInputStream(executionData));
        ExecutionDataStore execStore = new ExecutionDataStore();
        SessionInfoStore sessionInfos = new SessionInfoStore();
        executionDataReader.setExecutionDataVisitor(execStore);
        executionDataReader.setSessionInfoVisitor(sessionInfos);
        executionDataReader.read();
        return execStore;
    }

    private Collection<IClassCoverage> getCoveredClasses(ExecutionDataStore execStore) throws IOException {
        CoverageBuilder coverageBuilder = new CoverageBuilder();
        Analyzer analyzer = new Analyzer(execStore, coverageBuilder);
        analyzer.analyzeAll(originalFilePath,null); // relative path
        return coverageBuilder.getClasses();
    }
}