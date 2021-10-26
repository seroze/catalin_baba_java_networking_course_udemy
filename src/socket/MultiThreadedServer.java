package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
  public static void main(String[] args) throws IOException {


    ServerSocket serverSocket = new ServerSocket(9090);

    while (true) {
      System.out.println("Waiting for clients...");
      Socket clientSocket = serverSocket.accept();
      System.out.println("Client is connected");
      ClientThread clientThread = new ClientThread(clientSocket);
      clientThread.start();//note you should use thread.start() here and not thread.run() https://www.geeksforgeeks.org/difference-between-thread-start-and-thread-run-in-java/
      //start() will create a new thread and execute the code, whereas run() will execute code in same thread
    }

  }
}
