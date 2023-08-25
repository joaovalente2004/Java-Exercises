package SniperGame;

public class SniperRifle {

    private int bulletDamage = 2;

    private int shootChance = 70;




    public void shoot(Destroyable target) {

        if (target instanceof ArmouredEnemy) {
            ArmouredEnemy armouredEnemy = (ArmouredEnemy) target;
            armouredEnemy.hit(bulletDamage);
            if (armouredEnemy.getHealth() <= 0) {
                armouredEnemy.setisDead(true);
            }
        } else if (target instanceof SoldierEnemy) {
            SoldierEnemy soldierEnemy = (SoldierEnemy) target;
            soldierEnemy.hit(bulletDamage);
            if (soldierEnemy.getHealth() <= 0) {
                soldierEnemy.setisDead(true);
            }
        } else if(target instanceof Barrel) {
            Barrel barrel = (Barrel) target;
            barrel.hit(bulletDamage);
            if (barrel.getcurrentDamage() <= 0) {
                barrel.setDestroyed(true);
            }
        } else if (target instanceof Tree) {
            Tree tree = (Tree) target;
            tree.getMessage();

        }


    }

}


