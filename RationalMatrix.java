package example;
import example.Rational;
public class RationalMatrix extends GenericMatrix<Rational>{
 @Override
 protected Rational add(Rational r1,Rational r2){
   return r1.add(r2);
 }
 protected Rational multiply(Rational r1,Rational r2){
   return r1.multiply(r2);
 }
 protected Rational zero(){
   return new Rational(0,1);
 }
}
