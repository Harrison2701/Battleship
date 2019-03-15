import java.util.Random;

public class Opponent{
    String name;
    String[][] grid = new String[10][10];
    Board boardOpponent = new Board(grid);

    public Opponent(String name) {
        this.name = name;
        boardOpponent.populateBoard(grid, false);
        boardOpponent.printBoard(grid,"Player");
    }
    public void makeGuess(){
        Random random = new Random();
        int column =  random.nextInt(10);
        int row = random.nextInt(10);
        check(row,column);
    }
    public void check(int row, int column){
        String newLine = System.getProperty("line.separator");
        if(grid[column][row] == "🚢"){
            System.out.print("You have been hit!" + newLine);
            grid[column][row] = "X";
        }else{
            System.out.print("The enemy missed!" + newLine);
            grid[column][row] = "*";
        }
        System.out.print("Player Board" + newLine);
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print("\t" + grid[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }

}


