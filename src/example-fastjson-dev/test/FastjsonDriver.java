package test;

import com.alibaba.fastjson.JSON;
import coverage.SubjectExecutor;

import java.io.IOException;

public class FastjsonDriver extends SubjectExecutor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        packagePrefix = "com.alibaba.fastjson";
        inputFileName = args[0];

        new FastjsonDriver().wrapExecute();
    }

    static String json = "{,,[}";

    @Override
    public void execute(String input) {
        try {
            JSON.toJSONString(JSON.parseObject(input, Object.class));
        }catch (Exception e){}

    }
}
