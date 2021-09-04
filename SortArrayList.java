package example;

import java.util.ArrayList;
import java.util.Scanner;


public class SortArrayList implements Comparable<Number>{

  public static void main(String[] args) {

   ArrayList<Number> list = new ArrayList<>() ;
   
   System.out.print("Enter a number utill not type Zero ");
   
   Scanner scan = new Scanner(System.in) ;
   
   
   while(true) {
   
     int num = scan.nextInt();

     list.add(new Integer(num));
    
     if(num == 0)
      break ;
     
    }
    
    for( int i = 0 ; i < list.size() ; i++)
     System.out.print(list.get(i) + " ");
     
    sort(list);
    
    System.out.println();
    
    for( int i = 0 ; i < list.size() ; i++)
     System.out.print(list.get(i) + " ");
     
  }
 public static void sort(ArrayList<Number> list)  {
   for(int i = 1 ; i < list.size() ; i++){
     for(int j = 0 ; j < list.size() - i ; j++){
       if(list.get(j).compareTo(list.get(j+1))){
         Number temp = list.get(j) ;
         list.set(j,list.get(j+1));
         list.set(j+1,temp);
       }
     }
   }
 }
}
