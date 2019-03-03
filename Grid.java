public class Grid
{
    // Write your Grid class here
    private Location[][] grid;
    
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    
    // Create a new Grid. Initialize each Location in the grid
    // to be a new Location object.
    public Grid()
    {
        grid = new Location[NUM_ROWS][NUM_COLS];
        
        for(int i = 0; i < NUM_ROWS; i++)
        {
            for(int j = 0; j < NUM_COLS; j++)
            {
                grid[i][j] = new Location();
            }
        }
    }
    /**
     * This method can be called on your own grid. To add a ship
     * we will go to the ships location and mark a true value
     * in every location that the ship takes up.
    */
    
    /* Ship s has characteristics : 
     *
     *
     */
    
    public boolean overBoard(Ship s)
    {
        for(int i = 0; i < NUM_ROWS; i++)
        {
            for(int l = 0; l < NUM_COLS; l++)
            {
                // if there is the ship (Ship s) 
               //  then change hasShip() to true
               /**
                * this is the ugliest code
                * i have ever wrote
                * im so sorry for this sin
                * please forgive me
                */

                if(!grid[i][l].hasShip() &&  i == s.getRow() && l == s.getCol())
                {
                    if(s.getDirection() == 0)
                    {
                        for(int f = 0; f < s.getLength(); f++)
                        {
                            if(l + f > 10)
                            {
                                return true;
                            }
                        }
                    }
                    if(s.getDirection() == 1)
                    {
                        for(int k = 0; k < s.getLength(); k++)
                        {
                            if(i + k > 10)
                            {
                              return true;
                            }
                        
                        }
                    }
                    
                }
            }
        }
        return false;
    }
     

    
    public void addShip(Ship s)
    {
    
        for(int i = 0; i < NUM_ROWS; i++)
        {
            for(int l = 0; l < NUM_COLS; l++)
            {
                // if there is the ship (Ship s) 
               //  then change hasShip() to true
               /**
                * this is the ugliest code
                * i have ever wrote
                * im so sorry for this sin
                * please forgive me
                */

                if(!grid[i][l].hasShip() &&  i == s.getRow() && l == s.getCol())
                {
                    if(s.getDirection() == 0)
                    {
                        for(int f = 0; f < s.getLength(); f++)
                        {
                            if(l + f < 10)
                            {
                                if(!grid[i][l + f].hasShip())
                                {
                                    grid[i][l + f].setShip(true);
                                }
                            }
                        }
                    }
                    if(s.getDirection() == 1)
                    {
                        for(int k = 0; k < s.getLength(); k++)
                        {
                            if(i + k < 10)
                            {
                                if(!grid[i + k][l].hasShip())
                                {
                                    grid[i + k][l].setShip(true);
                                }
                            }
                        
                        }
                    }
                    
                }
            }
        }
   
    }
    
    /*
    public int numShips()
    {
        return numbShips;
    }
    */
    
    // Mark a hit in this location by calling the markHit method
    // on the Location object.  
    public void markHit(int row, int col)
    {
        grid[row][col].markHit();
        grid[row][col].setStatus(1);
    }
    
    // Mark a miss on this location.    
    public void markMiss(int row, int col)
    {
        grid[row][col].markMiss();
        grid[row][col].setStatus(2);
    }
    
    // Set the status of this location object.
    public void setStatus(int row, int col, int status)
    {
        grid[row][col].setStatus(status);
    }
    
    // Get the status of this location in the grid  
    public int getStatus(int row, int col)
    {
        return grid[row][col].getStatus();
    }
    
    // Return whether or not this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col)    
    {
        if(grid[row][col].isUnguessed())
        {
            return false;
        }
        
        return true;
    }
    
    // Set whether or not there is a ship at this location to the val   
    public void setShip(int row, int col, boolean val)
    {
        grid[row][col].setShip(val);
    }
    
    // Return whether or not there is a ship here   
    public boolean hasShip(int row, int col)
    {
        if(grid[row][col].hasShip())
        {
            return true;
        }
        
        return false;
    }
    
    
    // Get the Location object at this row and column position
    public Location get(int row, int col)
    {
        return grid[row][col];
    }
    
    // Return the number of rows in the Grid
    public int numRows()
    {
        return NUM_ROWS;
    }
    
    // Return the number of columns in the grid
    public int numCols()
    {
        return NUM_COLS;
    }
    
    
    // Print the Grid status including a header at the top
    // that shows the columns 1-10 as well as letters across
    // the side for A-J
    // If there is no guess print a -
    // If it was a miss print a O
    // If it was a hit, print an X
    // A sample print out would look something like this:
    // 
    //   1 2 3 4 5 6 7 8 9 10 
    // A - - - - - - - - - - 
    // B - - - - - - - - - - 
    // C - - - O - - - - - - 
    // D - O - - - - - - - - 
    // E - X - - - - - - - - 
    // F - X - - - - - - - - 
    // G - X - - - - - - - - 
    // H - O - - - - - - - - 
    // I - - - - - - - - - - 
    // J - - - - - - - - - - 
    public void printStatus()
    {
        
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for(int i = 0; i < NUM_ROWS;i++)
        {
            String row = "";
            String starChar = "";
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(grid[i][j].isUnguessed())
                {
                    row += "- ";
                }
                if(grid[i][j].checkMiss())
                {
                    row += "O ";
                }
                if(grid[i][j].checkHit())
                {
                    row += "F ";
                }
            }
            if(i == 0)
            {
                starChar = "A ";
            }
            if(i == 1)
            {
                starChar = "B ";
            }
            if(i == 2)
            {
                starChar = "C ";
            }
            if(i == 3)
            {
                starChar = "D ";
            }
            if(i == 4)
            {
                starChar = "E ";
            } 
            if(i == 5)
            {
                starChar = "F ";
            }
            if(i == 6)
            {
                starChar = "G ";
            }
            if(i == 7)
            {
                starChar = "H ";
            }
            if(i == 8)
            {
                starChar = "I ";
            }
            if(i == 9)
            {
                starChar = "J ";
            }
            
            System.out.println(starChar + row);
        }
    }
    
    // Print the grid and whether there is a ship at each location.
    // If there is no ship, you will print a - and if there is a
    // ship you will print a X. You can find out if there was a ship
    // by calling the hasShip method.
    //
    //   1 2 3 4 5 6 7 8 9 10 
    // A - - - - - - - - - - 
    // B - X - - - - - - - - 
    // C - X - - - - - - - - 
    // D - - - - - - - - - - 
    // E X X X - - - - - - - 
    // F - - - - - - - - - - 
    // G - - - - - - - - - - 
    // H - - - X X X X - X - 
    // I - - - - - - - - X - 
    // J - - - - - - - - X - 
    public void printShips()
    {
        
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        
        for(int i = 0; i < NUM_ROWS;i++)
        {
            String row = "";
            String starChar = "";
            
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(grid[i][j].hasShip())
                {
                    row += "X ";
                } 
                else
                {
                    row += "- ";
                }
                
            }
            
            if(i == 0)
            {
                starChar = "A ";
            }
            if(i == 1)
            {
                starChar = "B ";
            }
            if(i == 2)
            {
                starChar = "C ";
            }
            if(i == 3)
            {
                starChar = "D ";
            }
            if(i == 4)
            {
                starChar = "E ";
            }
            if(i == 5)
            {
                starChar = "F ";
            }
            if(i == 6)
            {
                starChar = "G ";
            }
            if(i == 7)
            {
                starChar = "H ";
            }
            if(i == 8)
            {
                starChar = "I ";
            }
            if(i == 9)
            {
                starChar = "J ";
            }
            
            System.out.println(starChar + row);
        }
    }
    
}
