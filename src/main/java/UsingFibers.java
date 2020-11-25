import java.util.*;

public class UsingFibers {
  public static void task() {
    System.out.println("UsingFibers::task() You called " + Thread.currentThread());
  }                                                          
  
  public static void main(String[] args) throws Exception {
    System.out.println("UsingFibers::main() In main " + Thread.currentThread());

    Thread.startVirtualThread(() -> task());
    Thread.startVirtualThread(() -> task());
    var fiber = Thread.startVirtualThread(() -> task());    
                
    fiber.join();
    System.out.println("UsingFibers::main() done");
  }
}