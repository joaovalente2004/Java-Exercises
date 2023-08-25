package org.c_shooters;

public class TrabalhadorDasCaldas implements Runnable{

    private String nome;

    private int producao;

    public TrabalhadorDasCaldas(String nome,int producao){
        this.producao = producao;

        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void work(){
        System.out.println(getNome() + " produziu " + this.producao + " caldas.");
        this.producao--;
    }

    @Override
    public void run() {
        while (this.producao > 0){

            try {
                Thread.sleep(2000);

                work();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(getNome() + " terminou de trabalhar.");
    }
}
