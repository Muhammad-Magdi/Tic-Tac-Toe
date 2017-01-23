/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

/**
 *
 * @author muhammad
 */
public class Board {
    private Cell[][] cells;
    private int current_row;
    private int current_col;
    public static final int ROWS = 3;
    public static final int COLS = 3;
    
    public Board(){
        this.cells = new Cell[ROWS][COLS];
        for(int row = 0 ; row < cells.length ; row++){
            for(int col = 0 ; col < cells[row].length ; col++){
                cells[row][col] = new Cell(row,col);
            }
        }
    }

    public void init(){
        for (int row = 0; row < cells.length; ++row) {
            for (int col = 0; col < cells[row].length ; ++col) {
                cells[row][col].clear();  // clear the cell content
         }
      }
    }
    
    public boolean isDraw() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (cells[row][col].getContent() == Seed.EMPTY) {
                    return false; // an empty seed found, not a draw, exit
            }
         }
      }
      return true; // no empty cell, it's a draw
    }
    
    public boolean hasWon(Seed theSeed) {
      return (cells[current_row][0].getContent() == theSeed         // 3-in-the-row
                   && cells[current_row][1].getContent() == theSeed
                   && cells[current_row][2].getContent() == theSeed
              || cells[0][current_col].getContent() == theSeed      // 3-in-the-column
                   && cells[1][current_col].getContent() == theSeed
                   && cells[2][current_col].getContent() == theSeed
              || current_row == current_col            // 3-in-the-diagonal
                   && cells[0][0].getContent() == theSeed
                   && cells[1][1].getContent() == theSeed
                   && cells[2][2].getContent() == theSeed
              || current_row + current_col == 2    // 3-in-the-opposite-diagonal
                   && cells[0][2].getContent() == theSeed
                   && cells[1][1].getContent() == theSeed
                   && cells[2][0].getContent() == theSeed);
    }
    public void paint() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                cells[row][col].paint();   // each cell paints itself
                if (col < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("-----------");
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getCurrent_row() {
        return current_row;
    }

    public int getCurrent_col() {
        return current_col;
    }

    public void setCurrent_row(int current_row) {
        this.current_row = current_row;
    }

    public void setCurrent_col(int current_col) {
        this.current_col = current_col;
    }
    
    
}
