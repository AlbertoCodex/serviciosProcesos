/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package servicios.llamadafichero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alberto
 */
public class LlamadaFichero {

    public static void main(String[] args) {
        try{
            Process proceso1 = new ProcessBuilder("Python", "Peliculas.py").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
            proceso1.waitFor();
            int exitStatus = proceso1.exitValue();
            while ((br.readLine()) != null) {
                System.out.println(br.readLine());
            }
            System.out.println("valor de la salida: " + exitStatus);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
