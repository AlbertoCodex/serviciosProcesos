import java.io.*;
import java.net.Socket;
public class ClientHandler extends Thread{
    private final Socket clientSocket;
    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Crear input y output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Leer el nombre del archivo enviado por el cliente
            String fileName = input.readLine();

            try {
                // Leer el contenido del archivo y enviarlo al cliente
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = fileReader.readLine()) != null) {
                    output.println(line); // Pintar el contenido del archivo
                }
                fileReader.close();
                System.out.println("Leyendo el archivo");
            } catch (FileNotFoundException fe) {
                output.println("No se encuentra el ficherito, máquina");
            }

            // Close
            input.close();
            output.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
