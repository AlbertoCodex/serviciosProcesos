import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] cmdArray = new String[2];
        cmdArray[0] = "java";
        BufferedReader stdInput = null;
        cmdArray[1] = "numPar.java";
        String line;

        Process proceso = Runtime.getRuntime().exec(cmdArray);
        stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        checkProcess(proceso, stdInput);
        while ((line = stdInput.readLine()) != null) {
            System.err.println(line);
        }
    }
    public static void checkProcess(Process proceso, BufferedReader stdInput) throws InterruptedException, IOException {
        int valorRetorno = proceso.waitFor();
        if (valorRetorno == 0) {
            System.out.println("Proceso completado, su salida fue: ");
        } else {
            System.out.println("Proceso fallado. Código error: " + valorRetorno);
            System.out.println("Se produjo un error, la salida fue: " + stdInput.readLine());
        }
    }
}