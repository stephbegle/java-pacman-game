import java.lang.StringBuilder;
import java.util.*;
import java.io.*;

/**
 * @author      Firstname Lastname <address @ example.com>
 */
public class Board {

    // FIELD
    public final int GRID_SIZE;

    private char[][] grid;          // String Representation of Pac-man Game Board
    private boolean[][] visited;    // Record of where Pac-man has visited
    private PacCharacter pacman;    // Pac-man that user controls
    private PacCharacter[] ghosts;  // 4 Ghosts that controlled by the program
    private int score;              // Score Recorded for the gamer
    private int mid;

    /*
     * Constructor
     *
     * <p> Description: TODO
     *
     * @param:  TODO
     * @return: TODO
     */

    // constructor takes in an int... initialize all instance variables from above
    // when constructing pacman and ghosts, pacman always spawns at center of grid, ghosts spawn at 4 corners
    //if grid size is an even number, then pacman spawns at the bottom right corner
    //new game, there are always 4 ghosts
    public Board(int size) {
        int side = size;
        if(size < 3) {
            side = 10;
        }
        this.GRID_SIZE = side;
        this.mid = this.GRID_SIZE / 2;
        this.visited = new boolean[this.GRID_SIZE][this.GRID_SIZE];
        this.score = 0;
        this.grid = new char[side][side];

        //gIndex maps pacman and ghosts initial positions
        int ghostIndex = this.GRID_SIZE -1;

        //Sets up the positions of pacman and the ghosts at the start of the game
        this.pacman = new PacCharacter(this.mid, this.mid, 'P');
        PacCharacter upperLeftGhost = new PacCharacter(0, 0, 'G');
        PacCharacter upperRightGhost = new PacCharacter(0, ghostIndex, 'G');
        PacCharacter lowerLeftGhost = new PacCharacter(ghostIndex, 0, 'G');
        PacCharacter lowerRightGhost = new PacCharacter(ghostIndex, ghostIndex, 'G');


        //initiating ghosts and setting the ghosts to arrays
//        this.ghosts[0] = upperLeftGhost;
//        this.ghosts[1] = upperRightGhost;
//        this.ghosts[2] = lowerLeftGhost;
//        this.ghosts[3] = lowerRightGhost;

        //set pacman to the center of the grid when starting
        setVisited(this.mid, this.mid);



        // TODO - Initialize instance variables
    }

//if the pacman has visited this coordinate, it will record it and "set" the visit to TRUE ( creating an empty slot)
    // in visited [][]
    // x = row, y = col
    public void setVisited(int x, int y) {
        this.visited[x][y] = true;


        // TODO
    }

    // will update grid [][] according to the info stored in visited, pacman, and ghosts
    public void refreshGrid() {
        int i, j, k = 0;
        for(i = 0; i < this.grid.length; i++) {
            for (j = 0; j < this.grid.length; j++) {
                if (this.visited[i][j] == true) {
                    this.grid[i][j] = ' ';
                } else {
                    this.grid[i][j] = '*';
                }
                // if pacman has visited, --> ' '
                // if he has not visited --> '*'
            }
        }

        for(k = 0; k < this.grid.length; k++) {
            System.out.println(Arrays.toString(this.grid[k]));
        }

                // nested for loops with if conditions following, check if pacma

        // TODO
    }

//takes in a Direction and returns boolean whethere pacman is able to move in that direction
//    public boolean canMove(Direction direction) {
//        // TODO
//    }

//the actual movement.... enter direction definitions? " get enum Direction" ?
    // groups other methods together to execute a move of user after checking canMove
    // pacman moves 1 step to a new position; score may change if there is a pacdot (what other instance variable
    // needs to change in this scenario)?; all ghosts should also move 1 step toward pacman based on pacman's new position
    // at the end of this method, grid is always refreshed
    // this will only work if canMove = true
    // all characters move 1 slot at a time
//    public void move(Direction direction) {
//        // TODO
//    }

// here we can write an if statment that asks whether pacman and a ghost is in the same coordinate?
    // do not need to update grid board in this method. That is another methods job .....
//    public boolean isGameOver() {
//        }
//        // TODO
//    }

    //lengthy method
    // Monster always move towards Pac-man
    // will return the direction that the ghost will move based on the current location of pacman
    //ghost always seeks to reduce the manhattan distance between it and pacman and in the shortest distance first
    // if distance is the same [3][3] ghost moves on col dimension first
    // if its in the same position as pacman, ir should choose to STAY
    // always "get" the grid coordinates of pacman from the object pacman to ensure currentness of position
//    public Direction ghostMove(PacCharacter ghost) {
//        // TODO
//    }

// returns a string representation of an object
    // use stringbuilder to concatenate rather than +
    // .append() and .toString() will be helpful here in stringBuilder class
//    public String toString(){
//
//        StringBuilder outputString = new StringBuilder();
//        outputString.append(String.format("Score: %d\n", this.score));
//
//        //TODO
//




}
