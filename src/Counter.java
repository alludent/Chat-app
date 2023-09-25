public class Counter implements Runnable {
    private int numConnectedClients = ClientThread.numConnectedClients;

    @Override
    public void run() {
        while (true) {
            numConnectedClients = ClientThread.numConnectedClients;
            System.out.println(numConnectedClients);
            try {
                Thread.sleep(3333);
            } catch (InterruptedException e) {
                System.out.println("BRUH");
            }
        }
    }
}
