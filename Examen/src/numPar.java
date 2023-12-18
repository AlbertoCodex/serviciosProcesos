public class numPar {
    public static void main (String args[]) {
        int[] numeros = new int[5];
        int contPar = 0;
        int contImpar = 0;
        for (int i = 0; i < 5; i++) {
            numeros[i] = i;
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println("El numero " + numeros[i] + " es par");
                contPar++;
            } else {
                System.out.println("El numero " + numeros[i] + " es impar");
                contImpar++;
            }
        }
        System.out.println("Hay un total de " + contPar + " numeros pares");
        System.out.println("Hay un total de " + contImpar + " numeros impares");
    }
}
