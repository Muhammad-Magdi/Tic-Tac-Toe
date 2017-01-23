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
public abstract class AIPlayer {
    
    private final int rows;
    private final int cols;
    private Cell[][] cells;
    private Seed my_seed;
    private Seed opp_seed;
    
    public AIPlayer(int rows, int cols, Board board){
        this.cells = board.getCells();
        this.rows = rows = 3;
        this.cols = cols = 3;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Seed getMy_seed() {
        return my_seed;
    }

    public void setMy_seed(Seed my_seed) {
        this.my_seed = my_seed;
        this.opp_seed = my_seed==Seed.CROSS ? Seed.NOUGHT : Seed.CROSS;
    }

    public Seed getOpp_seed() {
        return opp_seed;
    }

    abstract int[] move();
    
}
