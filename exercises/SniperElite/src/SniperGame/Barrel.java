package SniperGame;

public class Barrel extends GameObject implements Destroyable{

        private BarrelType barrelType;

        private int currentDamage = 2;

        private boolean destroyed = false;

        public String getMessage() {
            return "Barrel";
        }

        public int getcurrentDamage() {
            return currentDamage;
        }

        public void setcurrentDamage(int currentDamage) {
            this.currentDamage = currentDamage;
        }






    @Override
    public void hit(int damage) {
        //System.out.println("Sniper hit Barrel " + damage);
        if (currentDamage > 0) {
            currentDamage -= damage;
            //System.out.println("Barrel has Destroyed");
        } else {
            System.out.println("Barrel is broken");
            System.out.println("");
            System.out.println("Barrel has " + currentDamage + " damage");
            setcurrentDamage(currentDamage - damage);
        }


    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
