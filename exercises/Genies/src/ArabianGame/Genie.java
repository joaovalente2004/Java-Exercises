package ArabianGame;




public class Genie {

    private String name;

    private int wishes;



    public Genie(String name, int wishes) {
        this.name = name;
        this.wishes = wishes;
    }

    public String getName() {
        return name;
    }

    public int getWishes() {
        return wishes;
    }



    public void setWishes(int wishes) {
        this.wishes = wishes;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void soliciteWish() {

        System.out.println("\nSolicting wish from " + getName() + " \n");





    }




    public void chooseWish()  {



        soliciteWish();


            if (wishes > 0) {
                wishes --;





                System.out.println("You can only make one wish at a time. \n");
                System.out.println("Congrats, you have " + getWishes() + " wishes left.\n");
                System.out.println("Your wish is granted, my master. \n");


            }

                System.out.println("No wishes left, my master.");


    }






}
