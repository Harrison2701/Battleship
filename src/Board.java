import java.util.Random;
import java.util.Arrays;

public class Board{
    int[] rowarr = new int[3];
    int[] columnarr = new int[3];
    public Board(String[][]grid){
        //iterate through and add "0" to every position in your grid
        for(int x=0;x<grid.length;x++){
            for(int y=0;y<grid[x].length;y++){
                //System.out.print("\t"+ "~");
                grid[x][y] = "~";
                //System.out.print("\t"+grid[x][y]);
            }
           // System.out.println();
        }
       // System.out.println();
    }

    public void populateBoard(String[][]grid, boolean isOpponent){
        Random random = new Random();
        for(int x = 0; x < 3; x++){
            int column =  random.nextInt(10);
            int row = random.nextInt(10);
            grid[column][row] = "🚢";

            if(isOpponent == true){
                grid[column][row] = "~";
                rowarr[x] = row;
                columnarr[x] = column;
            }else{
                grid[column][row] = "🚢";
            }
        }
    }

    public void printBoard(String[][]grid,String name){
        String newLine = System.getProperty("line.separator");
        System.out.print(name + "Board" + newLine);
        for(int x=0;x<grid.length;x++){
            for(int y=0;y<grid[x].length;y++){
                System.out.print("\t"+grid[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean endGame(String[][]grid){
        int boatsSunk = 0;
        for(int x = 0; x<grid.length;x++){
            for(int y =0;y<grid[x].length;y++){
                if(grid[x][y]=="X"){
                    boatsSunk += 1;
                }else{
                    boatsSunk += 0;
                }
            }
        }

        if(boatsSunk == 3){
            return true;
        }else{
            return false;
        }

    }
}



