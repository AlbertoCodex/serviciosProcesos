public class Main implements Runnable {
    private String matricula;
    private String modelo;
    private String marca;
    private int estado;

    public Main(String matricula, String modelo, String marca, int estado) {
        super();
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.estado = estado;
    }

    @Override
    public void run() {
        try {
            this.reparar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Main vehiculo1 = new Main("1234 ABC", "Modelo", "Marca", (int) (Math.random()*8+1));
        Main vehiculo2 = new Main("1234 ABC", "Modelo", "Marca", (int) (Math.random()*8+1));
        Main vehiculo3 = new Main("1234 ABC", "Modelo", "Marca", (int) (Math.random()*8+1));
        new Thread(vehiculo1).run();
        new Thread(vehiculo2).run();
        new Thread(vehiculo3).run();
    }

    public void reparar() throws InterruptedException {
        System.out.println("Se está intentando reparar el coche");
        Thread.sleep(5000);
        if (estado > 4) {
            System.out.println("El estado del coche es malo");
        } else if (estado > 2) {
            System.out.println("El estado del coche es regular");
        } else {
            System.out.println("El estado del coche es bueno");
        }
    }
}