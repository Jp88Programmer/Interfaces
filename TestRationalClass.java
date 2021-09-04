package example;

import example.Rational;


/* 
   #### Case Study of Rational Class #####
 -------------------------------------------
                  Rational
 -------------------------------------------
-numerator: long
-denominator: long
+Rational()
+Rantional(numerator : long ,denominator : long);
+getNumerator(): long
+getDenominator(): long
+add(secondRational: Rational):
 Rational
+subtract(secondRational:
 Rational): Rational
+multiply(secondRational:
 Rational): Rational
+divide(secondRational:
 Rational): Rational
+toString(): String
-gcd(n: long, d: long): long 
 */
public class TestRationalClass {

  public static void main(String[] args) {
    Rational r1 = new Rational(4,3);
    Rational r2 = new Rational(9,3);   
    System.out.println(r1 + " + " + r2  + " = "  + r1.add(r2));
  
    System.out.println(r1 + " - " + r2  + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2  + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2  + " = " + r1.divide(r2));
    System.out.println("Double value of " + r1 + " is " + r1.doubleValue());
     System.out.println("Long  value of " + r1 + " is "  + r1.longValue());
    System.out.println("int value of " + r1 + " is "  + r1.intValue());
    System.out.println("Float value of " + r1 + " is "  + r1.floatValue());
    System.out.println("-------------------------------------------");
 System.out.println("Double value of " + r2 + " is " + r2.doubleValue());
     System.out.println("Long  value of " + r2 + " is "  + r2.longValue());
    System.out.println("int value of " + r2 + " is "  + r2.intValue());
    System.out.println("Float value of " + r2 + " is "  + r2.floatValue());
   
  }

}
/* Rationl is extends from Number and use Comparable interface 
 */
class Rational extends Number implements Comparable<Rational>{
/* numbrator of Rational number */
private long numerator; 
/* denominator of Rational number */
private long denominator;
/** Find GCD of two numbers */
private static long gcd(long n, long d) {
  long n1 = Math.abs(n);
  long n2 = Math.abs(d);
  int gcd = 1;
  for (int k = 1; k <= n1 && k <= n2; k++) {
   if (n1 % k == 0 && n2 % k == 0)
     gcd = k;
   }
   return gcd;
 }
/* default Constrator */  
public Rational(){
  this(0,1);
}
/* parameter constrator */
public Rational(long numerator,long denominator){
    this.numerator = numerator ;
    this.denominator = denominator ;
}
/* getter Methods */
/* The getter methods for the properties numerator and denominator are provided 
in the Rational class, but the setter methods are not provided, so, once a 
Rational object is created, its contents cannot be changed. The Rational class 
is immutable. The String class and the wrapper classes for primitive type values 
are also immutable.
 */
public long getNumerator(){
  return numerator ;
}
public long getDenominator(){
  return denominator ;
}
/* add two Rational number */
public Rational add(Rational secondRational ){
  long n = numerator * secondRational.getDenominator() + denominator * secondRational.getNumerator() ;
  long d = denominator * secondRational.getDenominator() ;
  return new Rational(n,d);
}
/* Subtract  two Rational number */
public Rational subtract(Rational secondRational){
  long n = numerator * secondRational.getDenominator() - denominator * secondRational.getNumerator() ;
  long d = denominator * secondRational.getDenominator() ;
  return new Rational(n,d);
}
/* Multply two Rational number */
public Rational multiply(Rational secondRational){
   return new Rational(numerator * secondRational.getNumerator(),denominator * secondRational.getDenominator());   
 }
 /* Divided two Rational number */
public Rational divide(Rational secondRational){
   return new Rational(numerator * secondRational.getDenominator(),denominator * secondRational.getNumerator());   
 }
 @Override
 /* Override the Method in Object class */
 public String toString(){
  if(denominator == 1)
   return  numerator + "" ;
  return numerator + "/" + denominator ; 
}
@Override 
/* Override the Method in Object class */
public boolean equals(Object o){
  return  this.subtract((Rational)o).getNumerator() == 0 ;
}
@Override
/* Override the Method Comparable interface */
public int compareTo(Rational r){
  if(this.subtract(r).getNumerator() > 0)
   return 1 ;
  else if(this.subtract(r).getNumerator() < 0)
   return -1 ;
  else 
   return 0 ;  
 }
 @Override
 /* Override the Method from the Number class */
 public int intValue(){
   return  (int)doubleValue();
 }
 @Override
 /* Override the Method from the Number class */
 public long longValue(){
   return  (long)doubleValue();
 }
 @Override
 /* Override the Method from the Number class */
 public float floatValue(){
   return  (float)doubleValue();
 }
 @Override
 /* Override the Method from the Number class */
 public double  doubleValue(){
   return numerator * 1.0 / denominator ;
 } 
}