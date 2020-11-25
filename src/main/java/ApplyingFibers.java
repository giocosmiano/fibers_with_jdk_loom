import java.util.*;
import java.util.concurrent.*;

public class ApplyingFibers {
  public static final int MAX = 2000000; //we could not get above 5000 on my machine with threads
  
  public static void doWork() {
//    System.out.println(Thread.currentThread());
    try { Thread.sleep(2000); } catch(Exception ex) {}
  }

  public static void main(String[] args) throws Exception {
    Thread th = null;
    
    boolean useVirtualThreads = Math.random() > 0.50;
    
    String message = useVirtualThreads ? "virtual" : "good old";
    
    System.out.printf("ApplyingFibers::main() executing `%s` %s threads.", MAX, message);
    
    for(int i = 0; i < MAX; i++) {
      if(useVirtualThreads) {
        th = Thread.startVirtualThread(ApplyingFibers::doWork);
      } else {
        th = new Thread(ApplyingFibers::doWork);
        th.start();
      }
    }
    
    th.join();
    
    System.out.println("ApplyingFibers::main() done");
  }
}