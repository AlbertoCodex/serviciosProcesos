/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package servicios.sistemariegoexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Alberto
 */
public class SistemaRiegoExecutor implements Runnable{
    @Override
    public void run(){
        System.out.println("Regando...");
    }

    public static void main(String[] args) {
        SistemaRiegoExecutor sr = new SistemaRiegoExecutor();
        ScheduledExecutorService stp = Executors.newSingleThreadScheduledExecutor();
        stp.scheduleAtFixedRate(sr, 1, 2, TimeUnit.SECONDS);
        System.out.println("Sistema de riego configurado");
    }
}
