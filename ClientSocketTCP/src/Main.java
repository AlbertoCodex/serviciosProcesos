import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static final String ip = "127.0.0.1";
    private static final int port = 57741;
    private static String fileRoute = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero a leer");
        fileRoute = sc.next();
        try {
            System.out.println("Conexion realizada");
            // Conectar al servidor
            Socket socket = new Socket(ip, port);
            // Entrada y salida para comunicarse con el servidor
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Enviar ruta al servidor
            output.println(fileRoute);
            // Leer la respuesta del servidor
            System.out.println("Mostrando el contenido del fichero:");
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line); // Imprimir el contenido del archivo recibido del servidor
            }

            // Cerrar los flujos y el socket
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}