public class SincronizacionSegmento extends Thread{
    int id;
    static Object bloqueo1 = new Object();
    static Object bloqueo2 = new Object();

    public SincronizacionSegmento(int id) {this.id = id;}

    public void metodo1() {
        synchronized (bloqueo1){
            System.out.println("Comienzo del metodo 1 del hilo"+id);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                return;
            }
            System.out.println("Fin del metodo 1 del hilo"+id);
        }
    }

    public void metodo2() {
        synchronized (bloqueo2){
            System.out.println("Comienzo del metodo 2 del hilo"+id);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                return;
            }
            System.out.println("Fin del metodo 2 del hilo"+id);
        }
    }

    @Override
    public void run() {
        if(id == 1) {
            metodo1();
            metodo2();
        } else {
            metodo2();
            metodo1();
        }
    }
    public static void main(String[] args) {
        new SincronizacionSegmento(1).start();
        new SincronizacionSegmento(2).start();
    }
}
