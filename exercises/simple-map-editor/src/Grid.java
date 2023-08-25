import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.Serializable;

public class Grid implements Serializable {
    public static final int PADDING = 10;
    private final int cols;
    private final int rows;


    private int x = 56;

    private int y = 80;



    private final int cellSize = 30;


    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;

    }


    public void init(){
        Rectangle background = new Rectangle(x, y, cols * cellSize, rows * cellSize);
        background.draw();
        background.setColor(Color.WHITE);

        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                Rectangle rectangle = new Rectangle(PADDING + cellSize * i, PADDING + cellSize * j, cellSize, cellSize);
                rectangle.draw();
                rectangle.setColor(Color.BLACK);
            }
        }
    }


    public int getCols(){
        return this.cols;
    }

    public int getRows(){
        return this.rows;
    }


    public double getColToX(int j) {
        return PADDING + cellSize * j;
    }

    public double getRowToY(int i) {
        return PADDING + cellSize * i;
    }


}
