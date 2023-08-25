package org.academiadecodigo.bootcamp.gfx.simplegfx;

import com.googlecode.lanterna.TerminalFacade;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;





    private int cols;

    private int rows;

    private int width;

    private int height;



    private  Rectangle field;
    public final int cellSize = 10;

    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }




    /**
     * @see Grid#init()
     */


    @Override
    public void init() {

       Rectangle background = new Rectangle(PADDING,PADDING, cols*cellSize, rows*cellSize);
       background.draw();



    }

    @Override
    public int getCols() {
        return this.cols;
    }



    /**
     * @see Grid#getCols()
     */


    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return this.rows;
    }




    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {

        return this.field.getWidth();
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return this.field.getHeight();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public int getX() {
        return this.getX();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {
        return rows;
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */
    public int getCellSize() {
        return cellSize;

    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col,row,this);
        //return new
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition() {
        return new SimpleGfxGridPosition(this);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return PADDING + cellSize * row;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        //return x;
        return PADDING + cellSize * column;
    }
}
