/**
 * Created by ricardo on 10/04/2017.
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server{

    public static void main(String[] args) {

        String strigRecebida;
        String ord;

        try {
            
            ServerSocket socket = new ServerSocket(1235);
            System.out.println("Start of Server!");
            System.out.println("Port 1235 open!");

            while(true) {

                Socket connectionSocket = socket.accept();

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                String str;
                String numbers = inFromClient.readLine();

                String[] parts = numbers.split(" ");

                ArrayList<Integer> n1 = new ArrayList<Integer>();

                for(int n = 0; n < parts.length; n++) {
                    n1.add(Integer.parseInt(parts[n]));
                }

                Collections.sort(n1);

                str = Arrays.toString(n1.toArray());

                // retorna as informações modificadas, ao cliente
                outToClient.writeBytes(str +"\n");
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
