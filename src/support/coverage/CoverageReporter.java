package support.coverage;

import org.jacoco.agent.rt.internal_e6e56f0.Agent;
import org.jacoco.agent.rt.internal_e6e56f0.core.runtime.AgentOptions;
import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.data.ExecutionDataReader;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;

public class CoverageReporter {
    private Agent agent = Agent.getInstance(new AgentOptions());
//    agent = Agent.getInstance(AgentOptions("output=none,dumponexit=false,excludes=*,includes=$packagePrefix*"))
    private String originalFilePath = "classes";
    private String packagePrefix = "";

    public CoverageReporter(String originalFilePath, String packagePrefix) {
        this.originalFilePath = originalFilePath;
        this.packagePrefix = packagePrefix;
        agent.reset();
    }

    public void getCoverage() throws IOException {
        ExecutionDataStore execStore = getExecutionDataStore();
        Collection<IClassCoverage> classes = getCoveredClasses(execStore);
        for (final IClassCoverage cc : classes){
            if (isInPackage(cc,packagePrefix)){
                System.out.println("Coverage of class " + cc.getName());
                int missedBranches = cc.getBranchCounter().getMissedCount();
                int totalBranches = cc.getBranchCounter().getTotalCount();
                System.out.printf("%d of %d %s miss\n", missedBranches,totalBranches,"branches");
            }
        }
    }

    private boolean isInPackage(IClassCoverage cc, String packagePrefix) {
        String packageName = cc.getPackageName();
        boolean res = packageName.startsWith(packagePrefix);
        if (res == false){
            return false;
        }

        int prefixLength = packagePrefix.length();
        if (packageName.length() > prefixLength){
            res = ( packageName.charAt(prefixLength-1) == '.' );
        }
        return res;
    }

    private ExecutionDataStore getExecutionDataStore() throws IOException {
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
