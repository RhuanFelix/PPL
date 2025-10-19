#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

using namespace std;

int numero = 0;

void *funcaoHelper(void * arg){
    int calculo;
    for (int i = 0; i < 10; i += 2){
        cout << "i: " << i << "\n";
        calculo = i / 2;
        cout << "Calculo: " << calculo << "\n";
        numero += calculo;
        cout << "Numero: " << numero << "\n";
    }
    return NULL;
}

int main(){
    pthread_t thread1, thread2;

    pthread_create(&thread1, NULL, funcaoHelper, NULL);
    pthread_create(&thread2, NULL, funcaoHelper, NULL);

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    printf("Resultado final: %d\n", numero);
}