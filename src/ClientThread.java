// creates a thread for 
// accepted clients



import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;


public class ClientThread implements Runnable {
    private Socket acceptedClientSocket;
    private String clientName;
    public static int numConnectedClients = 0;

    public ClientThread (Socket _acceptedClientSocket) {
        acceptedClientSocket = _acceptedClientSocket;

    }

    @Override
    public void run() {
        numConnectedClients++;

        InputStreamReader clientReader;
        BufferedReader clientBufferedReader;
        try {
            clientReader = new InputStreamReader(acceptedClientSocket.getInputStream());

            // read chunks of data into a buffer
            clientBufferedReader = new BufferedReader(clientReader);

            // clients first message is their username!
            clientName = clientBufferedReader.readLine();
            System.out.println(clientName + " connected.");

            // this loop just prints out the client stuff
            while (true) {
                String clientIn = clientBufferedReader.readLine();
                
                if (clientIn != null && clientIn.length() > 0) {
                    System.out.println(clientName + ": " + clientIn);
                } 
                // clientIn is null when client types 'q'
                else if (clientIn == null){
                    System.out.println(clientName + " disconnected.");
                    numConnectedClients--;
                    break;
                }
            }
            acceptedClientSocket.close();
        } catch (IOException e) {}


    }
}




