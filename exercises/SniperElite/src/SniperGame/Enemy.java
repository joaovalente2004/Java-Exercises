package SniperGame;

public abstract class Enemy extends GameObject implements Destroyable{


     private int health = 10;

     private boolean isDead = false;


     abstract public void hit(int damage);

     public String getMessage() {
          return "Enemy";
     }





     public boolean getisDead() {
          return isDead;
     }

     public void setisDead(boolean isDead) {
            this.isDead = isDead;
     }

        public int getHealth() {
             return health;
        }

        public void setHealth(int health) {
             this.health = health;
        }
}
