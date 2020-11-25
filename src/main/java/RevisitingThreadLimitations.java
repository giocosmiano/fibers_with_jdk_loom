import java.util.*;
import java.net.*;

public class RevisitingThreadLimitations {
  public static void getResponse() {
//    var url = "http://httpstat.us/200";
    var url = "http://httpstat.us/200?sleep=1000";

    System.out.println("RevisitingThreadLimitations::getResponse() sending request from: " + Thread.currentThread());
    try(Scanner scanner = new Scanner(new URL(url).openStream())) {
      System.out.println(scanner.nextLine());
    } catch(Exception ex) {
      System.out.println(ex.getMessage());
    } finally {
      System.out.println("RevisitingThreadLimitations::getResponse() received response from: " + Thread.currentThread());
    }
  } 
  
  public static void main(String[] args) throws Exception {
    Thread th1 = new Thread(RevisitingThreadLimitations::getResponse);
    th1.start();
    
    th1.join();

    Thread th2 = Thread.startVirtualThread(RevisitingThreadLimitations::getResponse);
    
    th2.join();
  }
}