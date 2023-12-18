public class Main implements Runnable{
    private int id;

    public Main(int id) {
        super();
        this.id = id;
    }
    public synchronized void azafata1() {
        System.out.println("La azafata 1 revisando el pasaporte del ID " + this.id);
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            return;
        }
        System.out.println("Se ha revisado correctamente");
    }
    public synchronized void azafata2() {
        System.out.println("La azafata 2 revisando el pasaporte del ID " + this.id);
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            return;
        }
        System.out.println("Se ha revisado correctamente");
    }

    @Override
    public void run(){
        int n = (int) (Math.random()*2+1);
        if (n == 1) {
            azafata1();
        } else {
            azafata2();
        }
    }
    public static void main(String[] args) {
        Main pasajero;
        for (int i = 0; i < 5; i++) {
            pasajero = new Main(i);
            new Thread(pasajero).start();
        }
    }
}