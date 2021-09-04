package example;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class PrintCalendar {
 public static void main(String args[]){
  Scanner input = new Scanner(System.in) ;
  System.out.print("\nEnter a Year : ");
  int year = input.nextInt();
  System.out.print("Enter a Month (e.g. 2) : ");
  int month = input.nextInt();
  //for(int i = 1 ; i<= 12 ; i++){
//  if(i%2 == 0)
 // System.out.print("\t");
  printCalenderBody(month,year);
//  }
 }
 private Calendar  cal = new GregorianCalendar();
 public PrintCalendar(){ }
 public PrintCalendar(int year,int month){
   cal.set(cal.YEAR,year);
   cal.set(cal.MONTH,month);
 }
 public PrintCalendar(int year){
   cal.set(cal.YEAR,year);
 }
 
 public static void printCalenderBody(Calendar cal){
   String monthTitel = getMonthTitel(Calendar.MONTH);
   System.out.printf("\n%16s,%-2d\n",monthTitel,Calendar.YEAR);
   System.out.println("-----------------------------");
   for(int i = 0 ; i < 7 ; i++)
    System.out.printf("%4s",getWeekTitel(Calendar.DAY_OF_WEEK-1));
    System.out.println();
    int startDay = startDayOfMonth(cal);
    int dayOfMonth = getDayOfMonth(cal);
   // System.out.println(startDay);
    for(int i = 0 ; i < startDay ; i++)
    System.out.print("    ");
        for(int j = 1 ; j <= dayOfMonth ; j++){
          if((j + startDay) % 7 == 0)
           System.out.printf("%4d\n",j);
          else
           System.out.printf("%4d",j);
    }
 }
 public static  boolean isLeapYear(int year){
   return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
 }
 public static String getMonthTitel(int month){
   switch(month){
     case 1 :
      return "January";
     case 2 :
      return "February";
     case 3 :
      return "March";
     case 4 :
      return "April";
     case 5 :
      return "May";
     case 6 :
      return "June";
     case 7 :
      return "July";
     case 8 :
      return "August";
     case 9 :
      return "September";
     case 10 :
      return "October";
     case 11 :
      return "November";
     case 12 :
      return "December";
     default :
      return "Your Month Number Incorrect";
   }
 }
 public static String getWeekTitel(int weekNumber)
 {
  String str = "";
   switch(weekNumber){
     case 0 :
      str = "Sun"; break;
     case 1 :
      str = "Mon"; break ;
     case 2 :
      str = "Tue"; break ;
     case 3 :
      str = "Wed"; break ;
     case 4 :
      str = "Thu"; break ;
     case 5 :
      str = "Fri"; break ;
     case 6 :
      str = "Sat"; break ;
   }
   return str ;
 }
 public static int startDayOfMonth(int month,int year){
   final int START_DAY_OF_1800 = 3;
   int totelDay = getTotelDay(month,year);
   return ( ( totelDay + START_DAY_OF_1800 ) % 7);
 }
 public static int getDayOfMonth(int month,int year){
   int dayOfMonth = 0;
   if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
   dayOfMonth = 31 ;
   if(month == 4 || month == 6 || month == 9 || month == 11)
   dayOfMonth = 30 ;
   if(month == 2)
   dayOfMonth = isLeapYear(year) ? 29 : 28 ;
   return dayOfMonth;
 }
 public static int getTotelDay(int month,int year){
   int totel = 0 ;
   for(int i = 1800 ; i < year ; i++){
     if(isLeapYear(year))
     totel = totel + 366 ;
     else
     totel = totel + 365 ;
   }
   for(int i = 1; i < month; i++)
     totel += getDayOfMonth(i,year);
   return totel;
 }
}

