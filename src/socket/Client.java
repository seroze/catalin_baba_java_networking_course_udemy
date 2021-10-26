package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
  public static void main(String[] args) {
    System.out.println("This is a TCP client");

    try {
      InetAddress serverAddress = InetAddress.getByName("localhost");
      System.out.println("server ip address: "+ serverAddress.getHostAddress());
      Socket socket = new Socket(serverAddress, 9090);

      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader inp = new BufferedReader((new InputStreamReader(socket.getInputStream())));
      System.out.println(inp.readLine());
      out.println(" hello server this is client");
      inp.close();
      out.close();
      socket.close();

    } catch (UnknownHostException e) {
      e.printStackTrace();
      System.out.println("Unknown host exception "+e.toString());
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("IO Exception "+ e.toString());
    }

  }
}
