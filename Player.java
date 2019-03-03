import java.util.*;

public class Player
{
    // Write your Player class here
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    
    ArrayList<Ship> ships = new ArrayList<Ship>();
    
    Grid playerGrid = new Grid();
    Grid computerGrid = new Grid();
    
    public Player()
    {
        for(int i = 0; i < SHIP_LENGTHS.length; i++)
        {
            ships.add(new Ship(SHIP_LENGTHS[i]));
        }
    }
    
   /* public void putTheShips(int shipNum, int row, int col, int dir)
    {
        for(Ship : s ships)
        {
            if(s.getLength() == shipNum)
            {
                 playerGrid.addShip(s, row, col, dir);
            }
        }
    }*/
    
    public void recordOpponentGuess(int row, int col)
    {
        if(playerGrid.hasShip(row, col))
        {
            playerGrid.markHit(row, col);
            
        }
        else
        {
            playerGrid.markMiss(row, col);
        }
    
    }
    
    public void recordPlayerGuess(int row, int col)
    {
        if(computerGrid.hasShip(row, col))
        {
            computerGrid.markHit(row, col);
            
        }
        else
        {
            playerGrid.markMiss(row, col);
            
        }

    }
    
    public void addShip(Ship s)
    {
        playerGrid.addShip(s);
    }
    
    public boolean overBoard(Ship s)
    {
        return playerGrid.overBoard(s);
    }
    
    public void printPlayerStatus()
    {
        playerGrid.printStatus();
    }
    
    public void printOpponentGuesses()
    {
        playerGrid.printStatus();
    }
    
    public void printMyGuesses()
    {
        playerGrid.printShips();
    }
    
    public void printMyShips()
    {
        playerGrid.printShips();
    }
    
    public int numShips = 0;
    
    public void chooseShipLocation(Ship s, int row, int col, int direction)
    {
        
        if(numShips < 5)
        {
            s.setLocation(row, col);
            s.setDirection(direction);
            playerGrid.addShip(s);
            
            numShips++;
        }
    }
}
