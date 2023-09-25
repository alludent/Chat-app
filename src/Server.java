import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server started successfully.");
        
        Counter numConnectedClientsCounter = new Counter();
        Thread numConnectedClientsThread = new Thread(numConnectedClientsCounter);
        numConnectedClientsThread.start();
        
        while (true) {
            Socket acceptedClientSocket = serverSocket.accept();
            Thread acceptedClientThread = new Thread(new ClientThread(acceptedClientSocket));
            acceptedClientThread.start(); 
        }
    }   
}
