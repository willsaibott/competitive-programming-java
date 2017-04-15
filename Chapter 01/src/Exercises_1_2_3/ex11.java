/**
 * 
 */
package Exercises_1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author willsaibott
 *
 */
public class ex11
{

  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner = new Scanner(new File(args[0]));
    
    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      System.out.println(Parser.eval(line));
    }
    scanner.close();
  }

  public static class Parser
  {
    public static double eval(final String str)
    {
      return new Object(){
        int pos = - 1, ch;
        
        void nextChar()
        {
          ch = (++pos < str.length())? str.charAt(pos): - 1;
        }
        
        boolean eat(int charToEat)
        {
          while (ch == ' ') nextChar();
          if (ch == charToEat)
          {
            nextChar();
            return true;
          }
          return false;
        }
        
        // Grammar:
        // expression = term | expression `+` term | expression `-` term
        // term = factor | term `*` factor | term `/` factor
        // factor = `+` factor | `-` factor | `(` expression `)`
        //        | number | functionName factor | factor `^` factor
        
        double parse()
        {
          nextChar();
          double x = parseExpression();
          if (pos < str.length()) 
            throw new RuntimeException("Unexpected: " + (char)ch);
          return x;
        }
        
        double parseExpression() 
        {
          double x = parseTerm();
          for (;;)
          {
            if (eat('+'))  
              x += parseTerm();
            else if (eat('-')) 
              x -= parseTerm();
            else return x;
          }
        }
        
        double parseTerm() 
        {
          double x = parseFactor();
          for (;;)
          {
            if (eat('*'))
              x *= parseFactor();
            else if (eat('/'))
              x /= parseFactor();
            else
              return x;
          }
        }
        
        double parseFactor() 
        {
          if (eat('+')) return parseFactor();
          if (eat('-')) return -parseFactor();
          
          double x;
          int startPos = this.pos;
          if (eat('('))
          {
            x = parseExpression();
            eat(')');
          } else if ((ch >= '0' && ch <= '9') || ch == '.')
          {
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            x = Double.parseDouble(str.substring(startPos, this.pos));
          } else if (ch >= 'a' && ch <= 'z') 
          {
            while (ch >= 'a' && ch <= 'z') nextChar();

            String func = str.substring(startPos, this.pos);
            x = parseFactor();
            if (func.equals("sqrt")) 
              x = Math.sin(Math.toRadians(x));
            else if (func.equals("sin"))
              x = Math.sin(Math.toRadians(x));
            else if (func.equals("cos"))
              x = Math.cos(Math.toRadians(x));
            else if (func.equals("tan"))
              x = Math.tan(Math.toRadians(x));
            else 
              throw new RuntimeException("Unknown function: " + func);
          } else {
            throw new RuntimeException("Unknown function: " + (char)ch);
          }
          
          if (eat('^'))
            x = Math.pow(x, parseFactor());
          
          return x;
        }
      }.parse();
    }
  }
}
