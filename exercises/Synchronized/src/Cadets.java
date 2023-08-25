public class Cadets implements Runnable{

    private String name;

    private Bathroom wc;

    public Cadets(String name, Bathroom wc){
        this.name = name;
        this.wc = wc;
    }



    @Override
    public void run(){
        Thread.currentThread().setName(name);
        try {
            wc.enter();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}
