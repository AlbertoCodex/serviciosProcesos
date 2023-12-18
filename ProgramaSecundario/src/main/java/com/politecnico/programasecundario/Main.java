/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnico.programasecundario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        menu();
    }

    public static void menu() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String[] cmdArray = new String[2];
        cmdArray[0] = "java";
        Process proceso = null;
        BufferedReader stdInput = null;
        int x = -1;

        while (x != 0) {
            System.out.println("menu"); // Crear opciones | 0 para salir, 1 para ejercicio1 ...
            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Ejercicio 1");
                    cmdArray[1] = "Media.java";
                    String line;
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    
                    checkProcess(proceso, stdInput);
                    while ((line = stdInput.readLine()) != null) { 
                        System.err.println(line);
                    }
                    break;
                case 2:
                    System.out.println("Ejercicio 2");
                    cmdArray[1] = "RandomNotepad.java";
                    String[] notepad = {"Notepad.exe", "new"};
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    checkProcess(proceso, stdInput);
                    int n = Integer.parseInt(stdInput.readLine());
                    
                    System.out.println("Se va a ejecutar el Notepad " + n + " veces");
                    for (int i = 1; i <= n; i++) { 
                        notepad[1] = "new"+i;
                        Runtime.getRuntime().exec(notepad);
                    }
                    break;
                case 3:
                    System.out.println("Ejercicio 3");
                    cmdArray[1] = "ExecutorMensajes.java";
                    String executorLines;
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    
                    checkProcess(proceso, stdInput);
                    while ((executorLines = stdInput.readLine()) != null) {
                        System.err.println(executorLines);
                    }
                    break;
                case 4:
                    System.out.println("Ejercicio 4");
                    line = "";
                    cmdArray[1] = "LongitudCadena.java";
                    String str1 = "String 1";
                    String str2 = "String 2";
                    FileWriter fw = new FileWriter("cadenas.txt", false);
                    BufferedWriter stdOutput = new BufferedWriter(fw);
                    stdOutput.write(str1);
                    stdOutput.newLine();
                    stdOutput.write(str2);
                    stdOutput.close();
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

                    checkProcess(proceso, stdInput);
                    while ((line = stdInput.readLine()) != null) { 
                        System.err.println(line);
                    }
                    break;
                case 5:
                    System.out.println("Ejercicio 5");
                    String[] notas = {"Notepad.exe", "new"};
                    proceso = Runtime.getRuntime().exec(notas);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    
                    System.out.println("Se ha ejecutado un bloc de notas");
                    checkProcess(proceso, stdInput);
                    Runtime.getRuntime().exec("taskkill /F /IM notepad.exe");
                    proceso.destroy();
                    System.out.println("Se ha cerrado el bloc de notas");
                    break;
                case 6:
                    System.out.println("Ejercicio 6");
                    line = "";
                    cmdArray[0] = "python3";
                    cmdArray[1] = "Jugadores.py";
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

                    checkProcess(proceso, stdInput);
                    while ((line = stdInput.readLine()) != null) { 
                        System.err.println(line);
                    }
                    break;
            }
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
