package SniperGame;

public class SoldierEnemy extends Enemy{

    private boolean isDead = false;
    public void hit(int damage) {


        System.out.println("Soldier Enemy has " + getHealth() + " health");

        System.out.println("\nSniper hit Soldier Enemy " + damage + " damage");
        setHealth(getHealth() - damage);

    }

    @Override
    public boolean isDestroyed() {
        return isDead;
    }

   public void setisDead(boolean dead) {
        this.isDead = dead;
    }



    @Override
    public String getMessage() {
        return "Soldier Enemy";
    }


}
