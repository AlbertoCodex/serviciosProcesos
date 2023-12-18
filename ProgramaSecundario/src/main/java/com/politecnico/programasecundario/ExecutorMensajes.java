/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnico.programasecundario;

import java.util.concurrent.Executor;

/**
 *
 * @author alberto
 */
public class ExecutorMensajes {
    public static void main(String[] args)
    {
        ExecutorImp obj = new ExecutorImp();
        for (int i = 0; i < 3; i++)
        obj.execute(new NewThread());
    }
}

class ExecutorImp implements Executor {
    @Override
    public void execute(Runnable command)
    {
        new Thread(command).start();
    }
}
 
class NewThread implements Runnable {
    @Override
    public void run()
    {
        System.out.println("Mensaje de un hilo mediante Executor :D");
    }
}
