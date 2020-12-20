package test;

import com.alibaba.fastjson.JSON;
import coverage.SubjectExecutor;

import java.io.IOException;
import java.util.ArrayList;

public class FastjsonDriver extends SubjectExecutor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        packagePrefix = "com.alibaba.fastjson";
//        inputList = new ArrayList<>();
//        inputList.add("{,,[}");
//        inputList.add("[ true , false ]");

        inputFileName = "src/example-fastjson-dev/.saveInput";

        new FastjsonDriver().wrapExecute();
    }

    static String json = "{,,[}";

    @Override
    public void execute(String input) {
        try {
            JSON.toJSONString(JSON.parseObject(input, Object.class));
        }catch (Exception e){}

//        json = "[ true , false ]";
//        try {
//            JSON.toJSONString(JSON.parseObject(json, Object.class));
//        }catch (Exception e){}
    }
}
