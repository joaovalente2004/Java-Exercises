package SniperGame;
import sun.security.krb5.internal.crypto.Des;
public class Game {

    private int shotsFired = 0;

    private GameObject[] gameObjects;

    private SniperRifle sniperRifle;

    public GameObject[] createObjects() {
        //put enemys  and tree in array
        GameObject[] gameObjects = new GameObject[5];
        //create random number of enemys and trees but tress need to be 1/3 of the total
        for (int i = 0; gameObjects.length > i; i++) {
            int random = (int) (Math.random() * 50);
            if (random < 10) {
                gameObjects[i] = new Tree();
            } else if (random > 10 && random < 25) {
                gameObjects[i] = new SoldierEnemy();
            } else if (random > 25 && random < 43) {
                gameObjects[i] = new ArmouredEnemy();
            } else if (random > 43 && random < 50) {
                gameObjects[i] = new Barrel();
            }
        }


        return gameObjects;
    }

    public void start() {

        gameObjects = createObjects();

        SniperRifle sniperRifle = new SniperRifle();




        for (int i = 0; gameObjects.length > i; i++) {

                if (gameObjects[i] instanceof Destroyable) {
                    Destroyable destroyable = (Destroyable) gameObjects[i];
                    System.out.println("Sniper hit " + gameObjects[i].getMessage());
                    System.out.println("");
                    if (destroyable.isDestroyed()) {
                        System.out.println(gameObjects[i].getMessage() + " is already destroyed");
                    } else {
                        while (!destroyable.isDestroyed()) {
                            sniperRifle.shoot(destroyable);
                            shotsFired++;
                        }


                    }
                    System.out.println(shotsFired + " shots fired");
                    System.out.println(gameObjects[i].getMessage() + " is destroyed");
                }


            }
        }




    }
