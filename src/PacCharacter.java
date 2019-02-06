public class PacCharacter {

    private char appearance;
    private int row;
    private int col;

    //this is the constructor
    // here the instance variables are initiated
    public PacCharacter(int row, int col, char appearance) {
        this.appearance = appearance;
        this.row = row;
        this.col = col;

        //TODO
    }
 //the following are the "contracts" (public methods) used to be able to access the private variables
    public int getRow(int row) {

        //TODO
        return this.row;
    }

    public int getCol(int col) {
        //TODO
        return this.col;
    }

    public char getAppearance() {
        //TODO
        return this.appearance;
    }

    public void setPosition(int row, int col) {
        //TODO
        this.row = row;
        this.col = col;
    }


    public void setAppearance(char appearance) {
        //TODO
        this.appearance = appearance;
    }
}
