import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        
        String username = "";
        while (username.length() == 0) {
            System.out.print("Enter username: "); 
            username = scanner.nextLine();
            if (username.length() == 0) {
                System.out.println("Invalid username.\n");
            }
        }
        
        String IPtoConnectTo = "";
        while (IPtoConnectTo.length() == 0) {
            System.out.print("What IP are you connecting to? ");
            IPtoConnectTo = scanner.nextLine();
            if (IPtoConnectTo.length() == 0) {
                System.out.println("Invalid IP address.\n");
            }
        }
        
        Socket clientSocket = new Socket(IPtoConnectTo, 9999);
        PrintWriter serverWriter = new PrintWriter(clientSocket.getOutputStream());

        // first message to server is the client name
        serverWriter.println(username);
        serverWriter.flush();

        // handle client inputs
        String userIn = "";
        while (!userIn.equals("q")) {
            System.out.print("> ");
            userIn = scanner.nextLine();
            serverWriter.println(userIn);
            serverWriter.flush();
        }

        clientSocket.close();
        scanner.close();
    }
}
