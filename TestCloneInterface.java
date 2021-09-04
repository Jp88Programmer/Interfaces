package example;

import example.House;
import java.util.Date;


public class TestCloneInterface {
 public static void main(String args[]){
  House h1 = new House(123,4277.344);
  System.out.println(h1.toString());
  House h2 = new House(783,6000.2214);
  System.out.println(h2.toString());
  System.out.println("-----------------------------------------");
  House h3 = (House)h2.clone();
  System.out.println(h3.toString());
  System.out.println("-----------------------------------------");
 }
}
class House implements Cloneable, Comparable<House> {
  private int id ;
  private double area ;
  private Date whenBuilt = new Date() ;
  public House(){
    this(1,20.00*30.00);
  }
  public House(int id, double area){
    this.id = id ;
    this.area = area ;
  }
  public void setId(int id){
    this.id = id;
  }
   public void setArea(double area){
    this.area = area;
  }
  public int getId(){
    return id ;
  }
  public double getArea(){
    return area ;
  }
  public Object clone(){
    try {
    House house = (House)super.clone();
    return house ;
    }
    catch (CloneNotSupportedException ex ){
    return null;
     } 
  }
 /* public Object clone() {
 try {
 // Perform a shallow copy
 /** House houseClone = (House)super.clone(); 
 // Deep copy on whenBuilt
/** houseClone.builtDate = (Date)builtDate.clone(); 
 return houseClone;
 }
 catch (CloneNotSupportedException ex) {
 return null;
  }
 } */
  public String toString(){
    return "\nHouse : " + "\nId : " + id + "\nArea : " + area + "\nBuilt Date : " + whenBuilt.toString() ;
  }
  @Override
   // Implement the compareTo method defined in Comparable
 public int compareTo(House o) {
 if (area > o.area)
  return 1;
 else if (area < o.area)
  return -1;
 else
  return 0;
 }
}
/* 
  #### protected native Object clone() throws CloneNotSupportedException; 
 * The keyword native indicates that this method is not written in Java but is implemented 
in the JVM for the native platform. The keyword protected restricts the method to be 
accessed in the same package or in a subclass. For this reason, the House class must over-
ride the method and change the visibility modifier to public so that the method can be 
used in any package. Since the clone method implemented for the native platform in the 
Object class performs the task of cloning objects, the clone method in the House class 
simply invokes super.clone(). The clone method defined in the Object class may throw 
CloneNotSupportedException.
 * The House class implements the compareTo method (lines 31–38) defined in the 
Comparable interface. The method compares the areas of two houses.
You can now create an object of the House class and create an identical copy from it, as 
follows:
  ## House house1 = new House(1, 1750.50);
  ## House house2 = (House)house1.clone();
 * house1 and house2 are two different objects with identical contents. The clone method in 
the Object class copies each field from the original object to the target object. If the field is of 
a primitive type, its value is copied. For example, the value of area (double type) is copied 
from house1 to house2. If the field is of an object, the reference of the field is copied. For 
example, the field whenBuilt is of the Date class, so its reference is copied into house2,
as shown in Figure 13.6. Therefore, house1.whenBuilt == house2.whenBuilt is true, 
although house1 == house2 is false. This is referred to as a shallow copy rather than a
 * deep copy, meaning that if the field is of an object type, the object’s reference is copied rather 
than its contents.
 * To perform a deep copy for a House object, replace the clone() method in lines 26–28 
with the following code:
 * public Object clone() throws CloneNotSupportedException {
// Perform a shallow copy
 House houseClone = (House)super.clone();
// Deep copy on whenBuilt
 houseClone.whenBuilt = (java.util.Date)(whenBuilt.clone()); 
return houseClone;
 }
or
public Object clone() {
try {
// Perform a shallow copy
 House houseClone = (House)super.clone();
// Deep copy on whenBuilt
 houseClone.whenBuilt = (java.util.Date)(whenBuilt.clone()); 
return houseClone;
}
catch (CloneNotSupportedException ex) {
return null;
 }
 }
 * Now if you clone a House object in the following code:
House house1 = new House(1, 1750.50);
House house2 = (House)house1.clone();
house1.whenBuilt == house2.whenBuilt will be false. house1 and house2 contain 
two different Date objects
 */