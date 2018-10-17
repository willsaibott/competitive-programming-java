package _1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ex11_example
{

  public static void main(String[] args)
      throws FileNotFoundException,
             ScriptException
  {
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
    Scanner scanner = new Scanner(new File(args[0]));
    while (scanner.hasNext())
    {
      String line = scanner.nextLine();
      String result = String.valueOf(jsEngine.eval(line));
      System.out.println("Input: " + line + "\nOutput: " + result);
    }
    scanner.close();
  }

}
