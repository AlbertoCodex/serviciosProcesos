public class Main implements Runnable{
    public synchronized void metodo1() {
        System.out.println("Comienzo del metodo 1, "+ Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            return;
        }
        System.out.println("Fin del metodo 1, "+ Thread.currentThread().getName());
    }
    public synchronized void metodo2() {
        System.out.println("Comienzo del metodo 2, "+ Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            return;
        }
        System.out.println("Fin del metodo 2, "+ Thread.currentThread().getName());
    }

    @Override
    public void run(){
        metodo1();
        metodo2();
    }
    public static void main(String[] args) {
        Main sm = new Main();
        new Thread(sm).start();
        new Thread(sm).start();
    }
}