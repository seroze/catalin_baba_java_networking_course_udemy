package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class InetAddressExample {
  public static void main(String[] args) {
    try {
      InetAddress inetAddress = InetAddress.getLocalHost();
      System.out.println(inetAddress.getHostAddress());
      System.out.println(inetAddress.getHostName());


      InetAddress inetAddress2 = InetAddress.getByName("https://zeta.udemy.com/course/java-network-programming/learn/lecture/5370558#overview");
      System.out.println(inetAddress2.getHostName());
      System.out.println(inetAddress2.getHostAddress());

      Socket socket = new Socket(inetAddress, 9090);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
