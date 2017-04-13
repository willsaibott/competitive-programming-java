package p1_2_3.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class ex3_example
{
  public static void main(String[] args)
      throws FileNotFoundException,
             ParseException
  {
    Scanner scanner = new Scanner(new File(args[0]));
    while (scanner.hasNext())
    {
      String dateStr = scanner.nextLine();
      System.out.println(dateStr);
      DateFormat formatter = new SimpleDateFormat("dd MMMM yyyy",
                                                  Locale.ENGLISH);
      Calendar cal = new GregorianCalendar(Locale.US);
      cal.setTime(formatter.parse(dateStr));
      DayOfWeek dow = DayOfWeek.of(cal.get(Calendar.DAY_OF_WEEK)).minus(1);
      System.out.println("WeekDay: " + dow.getDisplayName(TextStyle.FULL,
                                                          Locale.US));
    }
    scanner.close();
  }
}
