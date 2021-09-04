package example;

public class TestCompter {

  public static void main(String[] args) {
   Computer com = new Computer();
  System.out.println("Computer hadwarer : ");
  com.processer();
  com.ram();
  com.ramExceted();
  com.graphicsCard();
  com.rom();
  com.keyboardSize();
   Laptop lap = new Laptop();
  System.out.println("Laptop hadwarer : ");
  lap.processer();
  lap.ram();
  lap.ramExceted();
  lap.graphicsCard();
  lap.rom();
  lap.keyboardSize();
  }
}
interface hardware{
  void processer();
  void ram();
  boolean ramExceted();
  boolean graphicsCard();
  void rom();
  void keyboardSize();
}
class Computer{
   void processer(){
     System.out.println("intel i9 Octa core 10 genration");
   }
  void ram(){
     System.out.println("16 gb Ram");
  }
  boolean ramExceted(){
    System.out.println("ram exceted upto 32 GB");
    return true;
  }
  boolean graphicsCard(){
     System.out.println("yes addtion graphic card add");
     return true ;  
  }
  void rom(){
    System.out.println("1 TB SSD exceted upto 3 TB  ");
  }
  void keyboardSize(){
    System.out.println("keyboad size is larger than Laptop ");
  }
}
class Laptop{
void processer(){
     System.out.println("intel i5 Octa core 10 genration");
   }
  void ram(){
     System.out.println("8 gb Ram");
  }
  boolean ramExceted(){
    System.out.println("ram exceted upto 16 GB");
    return true;
  }
  boolean graphicsCard(){
     System.out.println("no addtion graphic card not add");
     return false  ;  
  }
  void rom(){
    System.out.println("512 GB SSD exceted upto 256 GB  ");
  }
  void keyboardSize(){
    System.out.println("keyboad is backlet  "); 
}
}