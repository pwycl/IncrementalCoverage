package coverage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SubjectExecutor {
    protected static String packagePrefix = "";
    protected static String originalFilePath = "classes";
    protected static Map<String, Double> inputWithTime = new HashMap<>();
    protected static String inputFileName = "";

    public void wrapExecute() throws IOException, ClassNotFoundException {
        assert (!originalFilePath.isEmpty());
        assert (!inputWithTime.isEmpty() || !inputFileName.isEmpty());

        if (inputWithTime.isEmpty()){
            try {
                inputWithTime = ReadFromFile(inputFileName);
            } catch (ClassNotFoundException e) {
                System.err.println("input file must be generated by ObjectOutputStream");
                throw e;
            }
        }

        String coverageFile = new File(inputFileName).getPath() + ".csv";
        CoverageReporter coverageReporter = new CoverageReporter(originalFilePath, packagePrefix, coverageFile);

        ignoreExecOutputGenInputListCoverage(inputWithTime, coverageReporter);
        coverageReporter.close();
    }

    private void ignoreExecOutputGenInputListCoverage(Map<String, Double> inputWithTime, CoverageReporter coverageReporter) throws IOException {
        PrintStream coverageStream = System.out;
        System.setOut(new PrintStream(new NullOutputStream()));
        genInputListCoverage(inputWithTime, coverageReporter, coverageStream);
        System.setOut(coverageStream);
    }

    private void genInputListCoverage(Map<String, Double> inputWithTime, CoverageReporter coverageReporter, PrintStream coverageStream) throws IOException {
        int i = 0;
        int total = inputWithTime.size();
//        for (String input : inputWithTime)
        for (Map.Entry<String, Double> entry : inputWithTime.entrySet())
        {
            String input = entry.getKey();
            double time = entry.getValue();
            try {
                execute(input);
            }catch (Throwable e){}
            i++;
            coverageStream.printf("%d of %d inputs, " + coverageReporter.getCoverage(time) + "\n", i, total);
        }
        coverageStream.println(coverageReporter.getTotal());
    }

    public abstract void execute(String input) throws Throwable;

    public Map<String, Double> ReadFromFile(String fileName) throws IOException, ClassNotFoundException {
        Map<String, Double> inputWithTime= new HashMap<>();
        File file=new File(fileName);
        if(file.exists()){
            ObjectInputStream osi=new ObjectInputStream(new FileInputStream(file));
            inputWithTime=(Map<String, Double>) osi.readObject();
            osi.close();
        }else {
            throw new FileNotFoundException(fileName + " not found! ");
        }

        return inputWithTime;
    }

}
