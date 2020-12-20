package coverage;

import org.jacoco.agent.rt.internal_e6e56f0.Agent;
import org.jacoco.agent.rt.internal_e6e56f0.core.runtime.AgentOptions;
import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.analysis.ICounter;
import org.jacoco.core.data.ExecutionDataReader;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CoverageReporter {
    private Agent agent = Agent.getInstance(new AgentOptions());
    private String originalFilePath = "classes";
    private String packagePrefix = "";

    public CoverageReporter(String originalFilePath, String packagePrefix) {
        this.originalFilePath = originalFilePath;
        this.packagePrefix = packagePrefix;
        agent.reset();
    }

    private Map<String, Integer> coveredCount = new HashMap<>();
    private Map<String, Integer> totalCount = new HashMap<>();
    public Map<String, Integer> getCoverage() throws IOException {
        ExecutionDataStore execStore = getExecutionDataStore();
        Collection<IClassCoverage> classes = getCoveredClasses(execStore);
        Map<String, Integer> coveredCount = new HashMap<>();
        Map<String, Integer> totalCount = new HashMap<>();
        for (final IClassCoverage cc : classes){
            if (isInPackage(cc,packagePrefix)){
//                PrintCoverage(cc);
                coveredCount = addCovered2Count(cc,coveredCount);
                totalCount = addTotal2Count(cc,totalCount);
            }
        }
        this.coveredCount = coveredCount;
        this.totalCount = totalCount;
        return this.coveredCount;
    }

    public Map<String, Integer> getTotal() throws IOException {
        this.getCoverage();
        return this.totalCount;
    }

    private Map<String, Integer> addTotal2Count(IClassCoverage cc, Map<String, Integer> count) {
        if (count == null){
            count = new HashMap<>();
        }

        int totalBranches = getBranchTotal(cc);
        addValueInMap(count, totalBranches, "Branch");

        int totalInstruments = getInstrumentTotal(cc);
        addValueInMap(count, totalInstruments, "Instrument");

        int totalLines = getLineTotal(cc);
        addValueInMap(count, totalLines, "Lines");

        return count;
    }

    private int getLineTotal(IClassCoverage cc) {
        ICounter counter = cc.getLineCounter();
        int total = counter.getTotalCount();
        return total;
    }

    private int getInstrumentTotal(IClassCoverage cc) {
        ICounter counter = cc.getInstructionCounter();
        int total = counter.getTotalCount();
        return total;
    }

    private int getBranchTotal(IClassCoverage cc) {
        ICounter counter = cc.getBranchCounter();
        int total = counter.getTotalCount();
        return total;
    }

    public Map<String, Integer> addCovered2Count(IClassCoverage cc, Map<String,Integer> count){
        if (count == null){
            count = new HashMap<>();
        }

        int coveredBranches = getBranchCoverage(cc);
        addValueInMap(count, coveredBranches, "Branch");

        int coveredInstruments = getInstrumentCoverage(cc);
        addValueInMap(count, coveredInstruments, "Instrument");

        int coveredLines = getLineCoverage(cc);
        addValueInMap(count, coveredLines, "Line");

        return count;
    }

    private void addValueInMap(Map<String, Integer> map, int value, String key) {
        if (map.containsKey(key)) {
            int addRes = map.get(key);
            addRes += value;
            map.put(key, addRes);
        } else {
            int countCoverage = value;
            map.put(key, countCoverage);
        }
    }

    private int getLineCoverage(IClassCoverage cc) {
        ICounter counter = cc.getLineCounter();
        int covered = counter.getCoveredCount();
        return covered;
    }

    private int getInstrumentCoverage(IClassCoverage cc) {
        ICounter counter = cc.getInstructionCounter();
        int covered = counter.getCoveredCount();
        return covered;
    }

    private int getBranchCoverage(IClassCoverage cc) {
        ICounter counter = cc.getBranchCounter();
        int covered = counter.getCoveredCount();
        return covered;
    }

    private void PrintCoverage(IClassCoverage cc) {
        System.out.println("Coverage of class " + cc.getName());
        int missedBranches = cc.getBranchCounter().getMissedCount();
        int totalBranches = cc.getBranchCounter().getTotalCount();
        System.out.printf("%d of %d %s miss\n", missedBranches,totalBranches,"branches");
    }

    private boolean isInPackage(IClassCoverage cc, String packagePrefix) {
        if (packagePrefix.isEmpty()){
            return true;
        }
        packagePrefix = packagePrefix.replace('.','/');
        String packageName = cc.getPackageName();
        boolean res = packageName.startsWith(packagePrefix);
        if (res == false){
            return false;
        }

        int prefixLength = packagePrefix.length();
        if (packageName.length() > prefixLength){
            res = ( packageName.charAt(prefixLength) == '/' );
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
