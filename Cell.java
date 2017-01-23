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

public class Cell {
    private Seed content;
    private final int row;
    private final int col;
    
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        clear();
    }
    
    public final void clear(){
        this.content = Seed.EMPTY;
    }
    
    public Seed getContent(){
        return this.content;
    }
    
    public void paint(){
        switch(this.content){
            case EMPTY : System.out.print("   ");  break;
            case CROSS : System.out.print(" X ");   break;
            case NOUGHT : System.out.print(" O ");   break;
        }
    }

    public void setContent(Seed content) {
        this.content = content;
    }
    
}
