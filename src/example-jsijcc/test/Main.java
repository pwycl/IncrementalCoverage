package test;

import javascriptInterpreter.parser.*;
import javascriptInterpreter.tree.*;
import javascriptInterpreter.visitors.*;

import java.io.*;

public class Main {
    public static void main(String args[]) {
        try{
            InputStream in = new FileInputStream("src/example-jsijcc/test/express.js");
            Javascript parser = new Javascript(in);
            SimpleNode s = parser.program();

            System.out.println("Successfully parsed the grammar");
            ExecutionVisitor v = new ExecutionVisitor();
            Context scope = new Context();
            s.jjtAccept(v, scope);
            System.out.println("Successfully executed the program");
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            System.out.println("Syntax error");
            System.out.println(e.getMessage());
        }
    }

    public static int loopTicks = 5;
}
