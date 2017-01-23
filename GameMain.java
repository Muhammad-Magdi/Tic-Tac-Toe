/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.Scanner;

/**
 *
 * @author muhammad
 */
public class GameMain {
    private Board board;
    private GameState current_state;
    private Seed current_player;
    
    private static Scanner in = new Scanner(System.in);
    
    public GameMain(){
        board = new Board();
        
        // Initialize the game-board and current status
        initGame();
      // Play the game once. Players CROSS and NOUGHT move alternately.
        do {
            playerMove(current_player); // update the content, currentRow and currentCol
            board.paint();             // ask the board to paint itself
            updateGame(current_player); // update currentState
            switch (current_state) {
                case CROSS_WON:
                    System.out.println("'X' won! Bye!");
                    break;
                case NOUGHT_WON:
                    System.out.println("'O' won! Bye!");
                    break;
                case DRAW:
                    System.out.println("It's Draw! Bye!");
                    break;
                default:
                    break;
            }
            current_player = (current_player == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
        } while (current_state == GameState.RUNNING);
    }
    
    public void initGame() {
      board.init();  // clear the board contents
      current_player = Seed.CROSS;       // CROSS plays first
      current_state = GameState.RUNNING; // ready to play
    }
    
    public void playerMove(Seed theSeed) {
      boolean validInput = false;  // for validating input
      do {
         if (theSeed == Seed.CROSS) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }
         int row = in.nextInt() - 1;
         int col = in.nextInt() - 1;
         if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
               && board.getCells()[row][col].getContent() == Seed.EMPTY) {
            board.getCells()[row][col].setContent(theSeed);
            board.setCurrent_row(row);
            board.setCurrent_col(col);
            validInput = true; // input okay, exit loop
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);   // repeat until input is valid
   }
    
    /** Update the currentState after the player with "theSeed" has moved */
   public void updateGame(Seed theSeed) {
      if (board.hasWon(theSeed)) {  // check for win
         current_state = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
      } else if (board.isDraw()) {  // check for draw
         current_state = GameState.DRAW;
      }
      // Otherwise, no change to current state (still GameState.PLAYING).
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      new GameMain();  // Let the constructor do the job
   }
}
