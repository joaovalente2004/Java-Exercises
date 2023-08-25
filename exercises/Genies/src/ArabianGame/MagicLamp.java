package ArabianGame;

public class MagicLamp {


private Genie[] genies;

private int rubs;

private int totalGenies;




public MagicLamp(int totalGenies){

        this.totalGenies = totalGenies;

        genies = new Genie[totalGenies];

        for (int i = 0; i < totalGenies; i++){

            genies[i] = new Genie("Genie " + (i + 1), 3);

        }

}


    public void choosenumber(){

        int number = (int) (Math.random() *  20 + 1);

        System.out.println("You scrubbed " + number + " times.");


        if (number % 2 == 0){
            System.out.println("It's even number, you got a friendly genie.");
            FriendlyGenie friendlyGenie = new FriendlyGenie("Friendly Genie", 5);
            friendlyGenie.chooseWish();
        }
        else{
            System.out.println("It's a odd number, you got a grumpy genie.");
            GrumpyGenie grumpyGenie = new GrumpyGenie("Grumpy Genie", 5);
            grumpyGenie.chooseWish();
        }

    }

}
