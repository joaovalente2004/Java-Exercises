import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import java.io.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Player {

    private Rectangle player1;

    private boolean isPainted[][] = new boolean[1222][1116];

    Grid grid = new Grid(27, 16);


    public Player(Rectangle player) {
        this.player1 = player;
    }

    public void draw() {
        player1.draw();
    }

    public void moveRight() {
        player1.translate(30, 0);
        checkMapLimits();
    }

    public void moveLeft() {
        player1.translate(-30, 0);
        checkMapLimits();
    }

    public void moveUp() {
        player1.translate(0, -30);
        checkMapLimits();
    }

    public void moveDown() {
        player1.translate(0, 30);
        checkMapLimits();
    }

    public int getX() {
        return player1.getX() - 29;
    }

    public int getY() {
        return player1.getY() - 29;
    }

    public void checkMapLimits() {
        if (player1.getX() < 0) {
            player1.translate(30, 0);
        }
        if (player1.getX() > 790) {
            player1.translate(-30, 0);
        }
        if (player1.getY() < 0) {
            player1.translate(0, 30);
        }
        if (player1.getY() > 460) {
            player1.translate(0, -30);
        }
    }

    public void color() {
        player1.setColor(Color.RED);
        player1.fill();
    }

    public void drawBlackCell() {
        int actualCell = player1.getX();
        int actualCellY = player1.getY();

        Rectangle blackCell = new Rectangle(actualCell, actualCellY, 29, 29);
        blackCell.draw();
        blackCell.setColor(Color.BLACK);
        blackCell.fill();


        System.out.println("X: " + actualCell);
        System.out.println("Y: " + actualCellY);

        isPainted[actualCell][actualCellY] = true;



    }

    public void drawWhiteCell() {
        int actualCell = getX();
        int actualCellY = getY();

        Rectangle whiteCell = new Rectangle(actualCell, actualCellY, 29, 29);
        whiteCell.draw();
        whiteCell.setColor(Color.WHITE);
        whiteCell.fill();

        isPainted[actualCell][actualCellY] = false;


    }

    public void clearAll() {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                Rectangle clear = new Rectangle(grid.getColToX(j), grid.getRowToY(i), 29, 29);
                clear.draw();
                clear.setColor(Color.WHITE);
                clear.fill();
            }
        }

        Player player = new Player(new Rectangle(player1.getX(), player1.getY(), 30, 30));
        player.draw();
        player.color();

        Handler handler = new Handler(player);


    }


    public void save() throws IOException {
        File file = new File("resources/save.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-16"));

        for (int i = 0; i < isPainted.length; i++) {
            for (int j = 0; j < isPainted[i].length; j++) {
                if (isPainted[i][j]) {
                    writer.write(i + " " + j);
                    writer.newLine();
                }
            }
        }

        System.out.println("Saved");
        writer.close();


    }

    public void load() throws IOException {
        File file = new File("resources/save.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-16"));

        String line = reader.readLine();

        while (line != null) {
            String[] coordinates = line.split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            Rectangle blackCell = new Rectangle(x, y, 29, 29);
            blackCell.draw();
            blackCell.setColor(Color.BLACK);
            blackCell.fill();
            isPainted[x][y] = true;
            line = reader.readLine();
            System.out.println("Got line");
        }

        reader.close();
    }

}
