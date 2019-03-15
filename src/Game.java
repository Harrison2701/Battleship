public class Game {
    public static void main(String[]args) {
        String newLine = System.getProperty("line.separator");
        System.out.println("BATTLEFIELD");
        System.out.println("~ means that the area hasn't been shot");
        System.out.println("* means that the area was shot and nothing was there");
        System.out.println("X means that the area was shot and hit a ship" + newLine);



        Player player = new Player("Player");
        Opponent opponent = new Opponent("Opponent");

        player.shoot();
        while(player.boardPlayer.endGame(player.grid) == false  || opponent.boardOpponent.endGame(opponent.grid) == false){
            if(player.boardPlayer.endGame(player.grid) == true || opponent.boardOpponent.endGame(opponent.grid) == true){
                if(player.boardPlayer.endGame(player.grid) == true){
                    System.out.println("VICTORY");
                    System.out.println("You won");
                }
                if(opponent.boardOpponent.endGame(opponent.grid) == true){
                    System.out.println("GAME OVER");
                    System.out.println("You lost");
                }
                break;
            }
            opponent.makeGuess();
            player.shoot();

        }
    }
}
