package ArabianGame;

public class RecyclableDemon extends Genie {

        public RecyclableDemon(String name, int wish) {
            super(name, wish);

        }
        //MagicLamp magicLamp = new MagicLamp();

        public void wishDemon() {
            super.chooseWish();
        }



        public void recycleDemon() {
            System.out.println("Demon recycled.");
            //magicLamp.choosenumber();

        }
}
