public class PacCharacter {
// these istance variables will be abstracted
    private char appearance;
    private int row;
    private int col;
    private int thePosition;

    //this is the constructor
    // here the instance variables are initiated
    public PacCharacter(int row, int col, char appearance) {
        this.appearance = appearance;
        this.row = row;
        this.col = col;
        this.thePosition = thePosition;
        //TODO
    }
// the following are the "contracts" (public methods) used to be able to access the private variables
    public int getRow(int row) {

        //TODO
        return row;
    }

    public int getCol(int col) {
        //TODO
        return col;
    }

    public char getAppearance(char appearance) {
        //TODO
        return appearance;
    }

    public void setPosition(int row, int col) {
        //TODO
    }

    public int getPosition(int row, int col) {
        return thePosition;
    }

    public void setAppearance(char appearance) {
        //TODO
    }
}
