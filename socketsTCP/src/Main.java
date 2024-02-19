import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final int port = 57741;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor escuchando...");

            // Escuchando conexiones
            while (true) {
                // Aceptando conexiones
                Socket clientSocket = serverSocket.accept();

                // Crear un hilo por cada conexion
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
                System.out.println("Conexion establecida");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}