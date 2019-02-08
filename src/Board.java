import java.util.Arrays;

/**
 * @author      Stephanie Begle <sbegle@ucsd.edu>
 *     This file initializes private variables in the Board constructor and allows for implementaion
 *     in the methods. The methods used in this file create the grid of the game, the characters used to
 *     play, conditions for specific situations that occur while playing the game, and the movement of
 *     pacman and the ghosts.
 *
 *     The purpose of Board class is so that we can create objects and be allowed to use
 *     such objects within methods. Board class allows us to use all of the characteristics that the board of pacman
 *     requires: characters, grid, ghosts, movement, etc.
 *
 *     Methods are blocks of code within a class that can then later be used by name and be invoked in other
 *     parts of the program whenever necessary. Some methods are created as void or int. If the method is void
 *     it should not return any value. If the method is of type "int" then it should be returning and int
 *     aswell. Methods can contain arguments, and those can be of any type according to what you have specified.
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
    public Board(int size) {

        int side = size;
        if (size < 3){
            side = 10;
        }
        // TODO - Initialize instance variables
        this.GRID_SIZE = size;
        this.visited = new boolean[this.GRID_SIZE][this.GRID_SIZE];
        this.mid = this.GRID_SIZE / 2;
        this.score = 0;
        this.grid = new char[side][side];

        // Create ghostIndex variable for easier readability
        int ghostIndex = this.GRID_SIZE - 1;

        // Initalize pacman character along with new ghosts
        this.pacman = new PacCharacter(this.mid, this.mid, 'P');
        this.ghosts = new PacCharacter[4];
        this.ghosts[0] = new PacCharacter(0, 0, 'G');
        this.ghosts[1] = new PacCharacter(ghostIndex, 0, 'G');
        this.ghosts[2] = new PacCharacter(0, ghostIndex, 'G');
        this.ghosts[3] = new PacCharacter(ghostIndex, ghostIndex, 'G');


        // Set starting point for pacman
        setVisited(this.mid, this.mid);

        // For testing
        System.out.println(this.GRID_SIZE);
        for (int i = 0; i < this.visited.length; i++) {
            System.out.println(Arrays.toString(this.visited[i]));
        }
        System.out.println("Pacman coordinates:" + pacman.getRow() + pacman.getCol());


        refreshGrid();

        String boardString = toString();
        System.out.println(boardString);
    }


    public void setVisited(int x, int y) {
        this.visited[x][y] = true;
    }

    public void refreshGrid() {

        int i, j;
        for (i = 0; i < this.grid.length; i++) {
            for (j = 0; j < this.grid.length; j++) {

                // Determine postion of pacman and update setVisited with grid position
                if (i == pacman.getRow() && j == pacman.getCol()) {
                    grid[i][j] = pacman.getAppearance();
                    setVisited(i, j);

                    // Check if pacman is at starting point in game and if true, then don't increment score yet
                    if (i == mid && j == mid) {
                        continue;
                    } else {
                        // Increment score when pacman has moved
                        this.score += 10;
                    }
                } else if (i == ghosts[0].getRow() && j == ghosts[0].getCol()) {

                    grid[i][j] = ghosts[0].getAppearance();

                } else if (i == ghosts[1].getRow() && j == ghosts[1].getCol()) {

                    grid[i][j] = ghosts[1].getAppearance();

                } else if (i == ghosts[2].getRow() && j == ghosts[2].getCol()) {

                    grid[i][j] = ghosts[2].getAppearance();

                } else if (i == ghosts[3].getRow() && j == ghosts[3].getCol()) {

                    grid[i][j] = ghosts[3].getAppearance();

                } else if (visited[i][j] == true) {

                    grid[i][j] = ' ';
                } else {

                    grid[i][j] = '*';
                }

                if (isGameOver() == true) {
                    grid[i][j] = 'X';
                }
            }
        }
    }

    public boolean canMove(Direction direction) {

        boolean inBounds;
        int xIndex;
        int yIndex;
        boolean xCheck;
        boolean yCheck;

        // Add current pacman position in grid to displacement of direction
        xIndex = pacman.getRow() + direction.getX();
        yIndex = pacman.getCol() + direction.getY();

        // Check that x and y index is in bounds of the grid
        xCheck = ((xIndex >= 0) && (xIndex < grid.length));
        yCheck = ((yIndex >= 0) && (yIndex < grid.length));
        inBounds = (xCheck) && (yCheck);

        return inBounds;
    }

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


    // do not need to update grid board in this method. That is another methods job .....
    public boolean isGameOver() {

// Check to see if pacman and ghosts are in same cell

        for (int g = 0; g < ghosts.length; g++) {
            if (pacman.getRow() == ghosts[g].getRow() && pacman.getCol() == ghosts[g].getCol()) {

                return true;
            }
        }

        return false;
    }

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
    public String toString(){

        StringBuilder outputString=new StringBuilder();
        outputString.append(String.format("Score: %d\n",this.score));

        //TODO
        String arrString;
        String[]splitString;
        String joinedString;

        for(int i=0;i<grid.length;i++){

        // Convert each row in array to string
        arrString=Arrays.toString(grid[i]);

        // Split string on commas and then join with ' ' in between
        splitString=arrString.split(",");
        joinedString=String.join(" ",splitString);

        // Remove the square brackets and replace with empty string
        joinedString=joinedString.replace("[","");
        joinedString=joinedString.replace("]","");

        // Append row string along with newline character to outputString
        outputString.append(joinedString+"\n");
        }

        return outputString.toString();
        }




}