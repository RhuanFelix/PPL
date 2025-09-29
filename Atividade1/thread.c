#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

int numero = 0;

void * tarefa1(void * arg){
    for(int i = 0; i < 10; i++){
        numero++;
        printf("%d\n", numero);
    }
}

void * tarefa2(void * arg){
    for(int i = 0; i < 10; i++){
        numero++;
        printf("%d\n", numero);
    }
}

int main(){
    pthread_t thread1, thread2;

    int resultado_thread1 = pthread_create(&thread1, NULL, tarefa1, NULL);
    int resultado_thread2 = pthread_create(&thread2, NULL, tarefa2, NULL);

    if(resultado_thread1 != 0){
        printf("Ocorreu um erro ao criar a thread1\n");
    } else{
        printf("Aguardando a thread1 terminar seu trabalho...\n");
        int resultado_t1_join = pthread_join(thread1, NULL);
        
        if(resultado_t1_join != 0){
            printf("A thread1 nao conseguiu terminar seu trabalho, sinto muito pela espera em vao :(\n\n");
        } else{
            printf("A thread1 conseguiu terminar seu trabalho! Obrigado pela paciencia :)\n\n");
        }
    }

    if(resultado_thread2 != 0){
        printf("Ocorreu um erro ao criar a thread2\n");
    } else{
        printf("Aguardando a thread2 terminar seu trabalho...\n");
        int resultado_t2_join = pthread_join(thread2, NULL);
        
        if(resultado_t2_join != 0){
            printf("A thread2 nao conseguiu terminar seu trabalho, sinto muito pela espera em vao :(\n\n");
        } else{
            printf("A thread2 conseguiu terminar seu trabalho! Obrigado pela paciencia :)\n\n");
        }
    }

    printf("Resultado final: %d\n", numero);
}