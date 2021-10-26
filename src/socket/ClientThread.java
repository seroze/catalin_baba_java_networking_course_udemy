package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

  private Socket socket;

  public ClientThread(Socket socket){
    this.socket = socket;

  }

  @Override
  public void run() {
    //super.run();
    PrintWriter out = null;
    System.out.println("Current Thread name: "+ Thread.currentThread().getName());
    try {
      out = new PrintWriter(socket.getOutputStream(), true);
      out.println("hello client");
      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


      String clientInput = input.readLine();
      System.out.println(clientInput);
      input.close();

      out.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
