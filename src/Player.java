import java.util.Scanner;

public class Player extends Game {
    String name;
    String[][] grid = new String[10][10];
    Board boardPlayer = new Board(grid);

    public Player(String name) {
        this.name = name;
        boardPlayer.populateBoard(grid, true);
        boardPlayer.printBoard(grid,"Opponent");
    }

    public void shoot() {
        Scanner input = new Scanner(System.in);
        int row;
        int column;
        System.out.println("Enter a value between 0 and 9");
        System.out.println("Column?");
        row = input.nextInt();
        if (row > 10) {
            System.out.println("Error!");
            shoot();
        } else {
            System.out.println("Row?");
            column = input.nextInt();
            if (column > 10) {
                System.out.println("Error!");
                shoot();
            }
            check(row, column);
        }
    }
    public void check(int row, int column){
        String newLine = System.getProperty("line.separator");
        if(grid[column][row] == "X" || grid[column][row] == "*"){
            System.out.println("You already shot there");
            shoot();
        }
        for(int x = 0; x < 3; x++){
            if (boardPlayer.columnarr[x] == column && boardPlayer.rowarr[x] == row) {
                System.out.print("Hit" + newLine);
                grid[column][row] = "X";
                break;
            } else {
                System.out.print("Miss" + newLine);
                grid[column][row] = "*";
            }
        }
        System.out.print("Opponent Board" + newLine);
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print("\t" + grid[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
