package Atividade3;

public class AtividadeThreads {
    private static int numero = 0;

    public static void main(String[] args) {
        new Thread() {
            public void run() {
                int calculo = 0;
                for (int i = 0; i < 10; i += 2) {
                    System.out.println("i: " + i);
                    calculo = i / 2;
                    System.out.println("Calculo: " + calculo);
                    numero += calculo;
                    System.out.println("Número: " + numero);
                }
            }
        }.start();
        new Thread() {
            public void run() {
                int calculo = 0;
                for (int i = 0; i < 10; i += 2) {
                    System.out.println("i: " + i);
                    calculo = i / 2;
                    System.out.println("Calculo: " + calculo);
                    numero += calculo;
                    System.out.println("Número: " + numero);
                }
            }
        }.start();
        System.out.println("Resultado final: " + numero);
    }
}