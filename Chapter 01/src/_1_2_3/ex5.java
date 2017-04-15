/**
 * 
 */
package _1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author willsaibott
 *
 */
public class ex5
{
  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner = new Scanner(new File(args[0]));
    List<Date> list = new ArrayList<Date>();
    while(scanner.hasNext())
    {
      int day = scanner.nextInt();
      int month = scanner.nextInt();
      int year = scanner.nextInt();
      Date date = new Date(day, month, year);
      list.add(date);
    }
    scanner.close();
    list.sort(new Comparator<Date>(){

      @Override
      public int compare(Date o1, Date o2)
      {
        return (((o1.getMonth() - o2.getMonth()) != 0)?
                 (o1.getMonth() - o2.getMonth()) : 
                 ((o1.getDay() - o2.getDay()) != 0)?
                  (o1.getDay() - o2.getDay()) :
                  (o1.getYear() - o2.getYear()));
      }
    });
    
    for (Date date : list)
    {
      date.print();
    }
  }
  
  
  public static class Date{
    private int day, month, year;

    public Date(int day, int month, int year)
    {
      setMonth(month);
      setDay(day);
      setYear(year);
    }

    public void print()
    {
      System.out.println(month + " " + day + " "  +  year);
    }

    public int getMonth()
    {
      return month;
    }

    public void setMonth(int month)
    {
      this.month = month;
    }

    public int getDay()
    {
      return day;
    }

    public void setDay(int day)
    {
      this.day = day;
    }

    public int getYear()
    {
      return year;
    }

    public void setYear(int year)
    {
      this.year = year;
    }
  }

}
