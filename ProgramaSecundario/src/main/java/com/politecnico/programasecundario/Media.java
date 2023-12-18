/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnico.programasecundario;

/**
 *
 * @author alberto
 */
public class Media {
    public static void main (String args[]) {
        int n = 10;
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }
        result = result / n;
        System.out.println("La media de los " + n + " primeros enteros es: " + result);
    }
}