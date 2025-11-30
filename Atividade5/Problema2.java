package Atividade5;

import java.util.concurrent.locks.ReentrantLock;

public class Problema2 {
    private static ReentrantLock mutex = new ReentrantLock();
    private static int numero = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    mutex.lock();
                    numero++;
                    mutex.unlock();
                }
            }
        };

        Thread t2 = new Thread() {
          public void run() {
              for (int i = 0; i < 100; i++) {
                  mutex.lock();
                  if (numero > 0) {
                      numero--;
                  }
                  mutex.unlock();
              }
          }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Número: " + numero);
    }
}