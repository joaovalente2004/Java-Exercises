package SniperGame;

public class ArmouredEnemy extends Enemy{

    private int armour = 6;

    private boolean isDead = false;


    public void hit(int damage) {

        if (armour > 0) {
            System.out.println("Armoured Enemy has " + armour + " armour");
            System.out.println("\nSniper hit Armoured Enemy " + damage + " damage");
            armour -= damage;


         }else {

            System.out.println("\nArmoured Enemy has " + getHealth() + " health");
            System.out.println("\nSniper hit Armoured Enemy " + damage + " damage");
            setHealth(getHealth() - damage);

        }
    }

    @Override
    public boolean isDestroyed() {
        return isDead;
    }

    public void setisDead(boolean dead) {
        this.isDead = dead;
    }

    public int getArmour() {
        return armour;
    }


    @Override
    public String getMessage() {
        return "Armoured Enemy";
    }



}
