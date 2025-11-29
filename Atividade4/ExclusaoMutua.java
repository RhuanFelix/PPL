package Atividade4;

import java.util.concurrent.locks.ReentrantLock;

public class ExclusaoMutua {
    private static ReentrantLock mutex = new ReentrantLock();
    private static int numero = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                int calculo = 0;
                for (int i = 0; i < 10; i += 2) {
                    mutex.lock();
                    System.out.println("i da thread1: " + i);
                    mutex.unlock();

                    mutex.lock();
                    calculo = i / 2;
                    System.out.println("Calculo da thread1: " + calculo);
                    mutex.unlock();

                    mutex.lock();
                    numero += calculo;
                    mutex.unlock();

                    mutex.lock();
                    System.out.println("Número mostrado pela thread1: " + numero);
                    mutex.unlock();
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                int calculo = 0;
                for (int i = 0; i < 10; i += 2) {
                    mutex.lock();
                    System.out.println("i da thread2: " + i);
                    mutex.unlock();

                    mutex.lock();
                    calculo = i / 2;
                    System.out.println("Calculo da thread2: " + calculo);
                    mutex.unlock();

                    mutex.lock();
                    numero += calculo;
                    mutex.unlock();

                    mutex.lock();
                    System.out.println("Número mostrado pela thread2: " + numero);
                    mutex.unlock();
                }
            }
        };

        t1.start();
        t2.start();
    }
}