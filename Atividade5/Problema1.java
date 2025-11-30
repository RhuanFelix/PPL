package Atividade5;

import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class Problema1 {
    private static ReentrantLock mutex = new ReentrantLock();
    private static int[] vetor = new int[6];

    public static void main(String[] args) {
        Random rand = new Random();

        // Threads que alteram posições 0 e 1
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    int pos = rand.nextBoolean() ? 0 : 1;
                    mutex.lock();
                    vetor[pos]++;
                    mutex.unlock();
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    int pos = rand.nextBoolean() ? 0 : 1;
                    mutex.lock();
                    vetor[pos]++;
                    mutex.unlock();
                }
            }
        };

        // Threads que alteram posições 2 e 3
        Thread t3 = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    int pos = rand.nextBoolean() ? 2 : 3;
                    mutex.lock();
                    vetor[pos]++;
                    mutex.unlock();
                }
            }
        };

        Thread t4 = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    int pos = rand.nextBoolean() ? 2 : 3;
                    mutex.lock();
                    vetor[pos]++;
                    mutex.unlock();
                }
            }
        };

        // Threads que alteram posições 4 e 5
        Thread t5 = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    int pos = rand.nextBoolean() ? 4 : 5;
                    mutex.lock();
                    vetor[pos]++;
                    mutex.unlock();
                }
            }
        };

        Thread t6 = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    int pos = rand.nextBoolean() ? 4 : 5;
                    mutex.lock();
                    vetor[pos]++;
                    mutex.unlock();
                }
            }
        };

        // Criadas primeiro, agora iniciamos todas
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Impressão dos resultados
        System.out.println("Resultado final do vetor:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Posição " + i + ": " + vetor[i]);
        }

        // Garantia: soma de cada par sempre será 40
        System.out.println("Soma [0+1]: " + (vetor[0] + vetor[1]));
        System.out.println("Soma [2+3]: " + (vetor[2] + vetor[3]));
        System.out.println("Soma [4+5]: " + (vetor[4] + vetor[5]));
    }
}
