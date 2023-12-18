/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package servicios.sistemariegotimertask;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Alberto
 */
public class SistemaRiegoTimerTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("Regando...");
    }
    public static void main(String[] args) {
        Timer temporizador = new Timer();
        temporizador.schedule(new SistemaRiegoTimerTask(), 1000, 2000);
    }
}