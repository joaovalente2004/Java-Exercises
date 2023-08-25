public class Academia {

    public static void main(String[] args) {

        Bathroom wc = new Bathroom(new Toilet());

        Thread cadet1 = new Thread(new Cadets("Ronaldo", wc));

        Thread cadet2 = new Thread(new Cadets("Messi", wc));

        Thread cadet3 = new Thread(new Cadets("Neymar", wc));


            cadet1.start();
            cadet2.start();
            cadet3.start();







    }
}
