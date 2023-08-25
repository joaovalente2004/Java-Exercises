public class Bathroom {

    private Toilet toilet;

    public Bathroom(Toilet toilet) {
        this.toilet = toilet;
    }

    public void enter() throws InterruptedException {

        synchronized (this) {

            System.out.println("Knock knock " + Thread.currentThread().getName());


            System.out.println(Thread.currentThread().getName() + " is entering the bathroom");

            toilet.use();

            Thread.sleep(1000);

            washHands();


        }


        System.out.println(Thread.currentThread().getName() + " is leaving the bathroom");
    }

    public void washHands(){
        System.out.println(Thread.currentThread().getName() + " is washing hands");
    }
}
