import java.util.*;

public class Battleship extends ConsoleProgram
{
    public void run()
    {
        // Start here! This class should interact with the user
        // to play the game of Battleship
        Player player1 = new Player();
        Ship ship1 = new Ship(2);
        Ship ship2 = new Ship(3);
        Ship ship3 = new Ship(3);
        Ship ship4 = new Ship(4);
        Ship ship5 = new Ship(5);
        
        
        Player player2 = new Player();
        
        //player1.printPlayerStatus();
       //player2.printPlayerStatus();
       
       System.out.println("----- Battle Ship ----- ");
       
       putShips(player1);
       
       putCompShips(player2);
        
       player1.printMyShips();
       player2.printMyShips();
       
       
        
        
        // You only need to allow for the user to set up each player's
        // ships and for each player to make a guess on the other player's grid
        // Don't worry about finishing the whole game yet.
        
        // You will probably need to make additions to the Player class to
        // allow for this setting up and guessing
    }
    
    public void putShips(Player player)
    {
        int[] arr = {2, 3, 3, 4, 5};
        
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println("Place your length " + arr[i] + " ship (row, col, direction): ");
            int row = readInt("Row : ");
            int col = readInt("Column : ");
            int direction = readInt("Direction : ");
            
            Ship newShip = new Ship(arr[i]);
            newShip.setLocation(row, col);
            newShip.setDirection(direction);
            
            if(player.overBoard(newShip))
            {
                System.out.println("Error boy");
            }
            else
            {
                player.addShip(newShip);
            }
        
        }

    }
    
    public void putCompShips(Player player)
    {
        Ship ship1 = new Ship(2);
        ship1.setLocation(Randomizer.nextInt(8), Randomizer.nextInt(8));
        ship1.setDirection(Randomizer.nextInt(2));
        
        Ship ship2 = new Ship(3);
        ship2.setLocation(Randomizer.nextInt(7), Randomizer.nextInt(7));
        ship2.setDirection(Randomizer.nextInt(2));
        
        Ship ship3 = new Ship(3);
        ship3.setLocation(Randomizer.nextInt(7), Randomizer.nextInt(7));
        ship3.setDirection(Randomizer.nextInt(2));
        
        Ship ship4 = new Ship(4);
        ship4.setLocation(Randomizer.nextInt(6), Randomizer.nextInt(6));
        ship4.setDirection(Randomizer.nextInt(2));
        
        Ship ship5 = new Ship(5);
        ship5.setLocation(Randomizer.nextInt(5), Randomizer.nextInt(5));
        ship5.setDirection(Randomizer.nextInt(2));
        
        if(!player.overBoard(ship1))
        {
            player.addShip(ship1);
        }
        if(!player.overBoard(ship2))
        {
            player.addShip(ship2);
        }
        if(!player.overBoard(ship3))
        {
            player.addShip(ship3);
        }
        if(!player.overBoard(ship4))
        {
            player.addShip(ship4);
        }
        if(!player.overBoard(ship5))
        {
            player.addShip(ship5);
        }
       
      
    }
    
    public void askForGuess(Player player)
    {
        int inRow = readInt("Make your guess(row, col): ");
        int inCol = readInt(" : ");
        
        player.recordPlayerGuess(inRow, inCol);
    }
}
