package org.c_shooters;

public class FabricaDasCaldas{

    public static void main(String[] args){

        TrabalhadorDasCaldas gerente = new TrabalhadorDasCaldas("Monhe", 0);
        TrabalhadorDasCaldas trabalhador1 = new TrabalhadorDasCaldas("Neymar",5);
        TrabalhadorDasCaldas trabalhador2 = new TrabalhadorDasCaldas("Ronaldo", 4);
        TrabalhadorDasCaldas trabalhador3 = new TrabalhadorDasCaldas("Messi", 3);

        Thread threadTrab1 = new Thread(trabalhador1);
        Thread threadTrab2 = new Thread(trabalhador2);
        Thread threadTrab3 = new Thread(trabalhador3);

        try {
            threadTrab1.join();
            threadTrab2.join();
            threadTrab3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(gerente.getNome() + " é o gerente da fábrica.");

        System.out.println(trabalhador1.getNome() + " começou a trabalhar.");

        threadTrab1.start();

        System.out.println(trabalhador2.getNome() + " começou a trabalhar.");

        threadTrab2.start();

        System.out.println(trabalhador3.getNome() + " começou a trabalhar.");

        threadTrab3.start();


    }
}
