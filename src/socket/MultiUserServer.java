package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiUserServer  {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(9090);

    while (true) {

      System.out.println("waiting for clients");

      Socket socket = serverSocket.accept();
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      out.println("hello client");
      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


      String clientInput = input.readLine();
      System.out.println(clientInput);
      input.close();

      out.close();
      socket.close();
    }
  }
}
