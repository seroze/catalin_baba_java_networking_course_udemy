package socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class RemotePortScanner {



  public static void main(String[] args) {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(in);

    String targetIp = "";
    int fromPort = 0;
    int toPort = 0;

    System.out.println("Please enter the target ip address: ");
    try {
      targetIp = reader.readLine();

    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Cannot read the target ip address");
    }

    boolean isValid = false;
    while(! isValid){
      try {
        System.out.println("Please enter the first port: ");//ask user to type the first port
        String portString = reader.readLine();
        fromPort = Integer.parseInt(portString);
        if(fromPort>=0 && fromPort<=65336){
          isValid=true;
        }else{
          System.out.println("invalid port range");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

    }

    int port = fromPort;
    while(port>=fromPort && port<=toPort){
      try {
        Socket socket = new Socket(targetIp, port);
        System.out.println("Port: "+ port+" is in listening state!");//print listening port
        socket.close();
      } catch (UnknownHostException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      port++;
    }


  }
}
