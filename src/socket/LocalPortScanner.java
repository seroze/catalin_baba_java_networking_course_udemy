package socket;

import java.net.ServerSocket;

public class LocalPortScanner {

  public static void main(String[] args) {
    int port = 1;
    while (port<= 65535) {
      try {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Port: "+port+" is  open");
      } catch (Exception ex) {
        System.out.println("Port: "+port+" is closed");
      }
      port++;
    }
  }
}
