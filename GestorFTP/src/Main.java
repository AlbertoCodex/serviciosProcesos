import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class Main {
    private FTPClient clienteFTP;
    private static final String SERVIDOR="localhost";
    private static final int PUERTO = 21;
    private static final String USUARIO = "Alberto";
    private static final String PASSWORD = "1234";

    public Main() {
        clienteFTP = new FTPClient();
    }

    private void conectar() throws IOException {
        clienteFTP.connect(SERVIDOR, PUERTO);
        int respuesta = clienteFTP.getReplyCode();
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP");
        }
        boolean credencialesOK = clienteFTP.login(USUARIO, PASSWORD);
        if (!credencialesOK) {
            throw new IOException("Error al conectar con el servidor FTP. credenciales incorrectar");
        }
        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
    }
    private void desconectar() throws IOException {
        clienteFTP.disconnect();
    }

    private boolean subirFichero(String path) throws IOException {
        File ficherolocal = new File(path);
        InputStream is = new FileInputStream(ficherolocal);
        boolean enviado = clienteFTP.storeFile(ficherolocal.getName(), is);
        is.close();
        return enviado;
    }

    private boolean descargarFichero(String ficheroRemoto, String pathLocal) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(pathLocal));
        boolean recibido = clienteFTP.retrieveFile(ficheroRemoto, os);
        os.close();
        return recibido;
    }

    public static void main(String[] args) {
        Main gestorFTP = new Main();
        try {
            gestorFTP.conectar();
            System.out.println("conectado");
            boolean subido = gestorFTP.subirFichero("C:\\Users\\Alberto\\hola.txt");
            if (subido) {
                System.out.println("Fichero subido a Filezilla correctamente");
            } else {
                System.err.println("Ha ocurrido un error al intentar subir el fichero");
            }
            boolean descargado = gestorFTP.descargarFichero("hola.txt","C:\\Users\\Alberto\\Desktop\\hola.txt");
            if (descargado) {
                System.out.println("Fichero descargado correctamente");
            } else {
                System.err.println("Ha ocurrido un error al intentar subir el fichero");
            }
            gestorFTP.desconectar();
            System.out.println("Desconectado");
        } catch (Exception e) {

        }
    }
}