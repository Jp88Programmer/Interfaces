package example;

public abstract class GenericMatrix<E extends Number> {
 protected abstract E add(E o1,E o2);
 protected abstract E multiply(E o1,E o2);
 protected abstract E zero();
 public E[][] addMatrix(E[][]m1,E[][]m2){
   if(m1.length != m2.length)
   {
     throw  new RuntimeException("Matrix row Oreder are incorrect");
   }
   else
   {
     if(m1[0].length != m2[0].length)
      throw  new RuntimeException("Matrix row Oreder are incorrect");
   }
   E[][] result = (E[][])new Number[m1.length][m1[0].length];
   for(int i = 0 ; i < m1.length ; i++){
     for(int j = 0 ; j < m1[0].length ; j++){
       result[i][j] = add(m1[i][j],m2[i][j]);
     }
   }
   return result ;
 }
 public E[][] multiplyMatrix(E[][] m1,E[][] m2){
   if(m1[0].length != m2.length)
    throw new RuntimeException("Matrix Order not qualify by multiply of matrixs");
 
 E[][] result = (E[][])new Number[m1.length][m2[0].length];
 for(int i = 0 ; i < result.length ; i++){
     for(int j = 0 ; j < result[0].length ; j++){
    result[i][j] = zero();
      for(int k = 0 ; k < m1[0].length ; k++)
      result[i][j] = add(result[i][j],multiply(m1[i][k],m2[k][j]));
     }
 } 
 return result ;
}
public void print(E[][] m1,E[][] m2 ,E[][] m3,char op){
   for(int i = 0 ; i < m1.length ; i++){
     for(int j = 0 ; j < m1[0].length ; j++)
      System.out.print(m1[i][j] + " ");
     if(i == m1.length / 2 )
      System .out.print("  " + op + "  ");
     else
      System.out.print("     ");
     for(int j = 0 ; j < m2[0].length ; j++)
      System.out.print(m2[i][j] + " ");
     if(i == m1.length / 2 )
      System .out.print("  " + "=" + "  ");
     else
      System.out.print("     ");
     for(int j = 0 ; j < m3[0].length ; j++)
      System.out.print(m3[i][j] + " ");
     System.out.println();
   }
 }
}