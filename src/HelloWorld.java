import org.jacoco.agent.rt.internal_e6e56f0.Agent;
import org.jacoco.agent.rt.internal_e6e56f0.core.runtime.AgentOptions;
import support.coverage.CoverageReporter;
import test.TestTarget;

import java.io.IOException;

public class HelloWorld {
    private String packagePrefix = "test";
    private Agent agent = Agent.getInstance(new AgentOptions());
    private String originalFilePath = "classes";

    public static void main(String[] args) throws IOException {
        new HelloWorld().execute();
    }

    public void execute() throws IOException {

        CoverageReporter coverageReporter = new CoverageReporter(originalFilePath, packagePrefix);

        new TestTarget().run();

        coverageReporter.getCoverage();
    }

}