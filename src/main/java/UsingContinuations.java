import java.util.*;
import static java.lang.Continuation.*;

public class UsingContinuations {
  public static void doWork(ContinuationScope scope) {
    System.out.println("UsingContinuations::doWork() Entering... " + Thread.currentThread());
    Continuation.yield(scope);
    
    System.out.println("UsingContinuations::doWork() Step 2 " + Thread.currentThread());
    Continuation.yield(scope);
    
    System.out.println("UsingContinuations::doWork() Step 3 " + Thread.currentThread());
    Continuation.yield(scope);
    
    System.out.println("UsingContinuations::doWork() Step 4 " + Thread.currentThread());
    Continuation.yield(scope);
    
    System.out.println("UsingContinuations::doWork() Step 5 " + Thread.currentThread());
  } 
  
  public static void main(String[] args) {   
    var scope = new ContinuationScope("sample");
    var continuation = new Continuation(scope,
      () -> doWork(scope));

    while(!continuation.isDone()) {
      System.out.println("UsingContinuations::main()   In the loop with " + Thread.currentThread());
      continuation.run();
    }
  }
}