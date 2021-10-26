package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Ping {
  public static void main(String[] args) {
    try {
      String hostAddress = "google.com";
      InetAddress host = InetAddress.getByName(hostAddress);
      System.out.println(host.isReachable(1000));//not this doesn't work

      Process process = Runtime.getRuntime().exec("ping "+ hostAddress);
      BufferedReader inp = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String commandOutput="";
      boolean isReachable  = true;
      while((commandOutput=inp.readLine())!=null){


        System.out.println(commandOutput);

        if(commandOutput.contains("Destination host unreachable")){
          isReachable=false;
          break;
        }
      }


    }catch (Exception ex){


    }
  }
}
