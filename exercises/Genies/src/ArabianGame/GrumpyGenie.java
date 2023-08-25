package ArabianGame;

public class GrumpyGenie extends Genie {

    //grumpy genie only grants one wish
    public GrumpyGenie(String name, int wish) {
        super(name, wish);


    }
    RecyclableDemon recyclableDemon = new RecyclableDemon("Recyclable Demon", 2);


    @Override
    public void chooseWish() {
        super.chooseWish();
        if (getWishes() > 0) {
            setWishes(getWishes() - 1);

            System.out.println("You can only make one wish at a time.");
            System.out.println("Your wish is granted, my master.");

        }

        System.out.println("Im a grumpy genie, I only grant one wish.");
        System.out.println("");
        System.out.println("Your wishes are finished, a recyclable demon appeared.");
        recyclableDemon.recycleDemon();
    }
}










