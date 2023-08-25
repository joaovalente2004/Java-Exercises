package ArabianGame;

public class FriendlyGenie extends Genie{

    RecyclableDemon recyclableDemon = new RecyclableDemon("Recyclable Demon", 2);

    public FriendlyGenie(String name, int wish) {
        super(name, wish);

        for (int i = 1; i < wish; i++){

            super.chooseWish();
        }
        System.out.println("");
        System.out.println("Your wishes are finished, a recyclable demon appeared.");
        recyclableDemon.wishDemon();




    }

}
