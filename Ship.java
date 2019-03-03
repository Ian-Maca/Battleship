public class Ship
{
    //initializers
    private int row;
    private int col;
    private int length;
    private int direction;
    private boolean locationSet;
    private boolean directionSet;
    
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    
    //constructor for ship
    public Ship(int length)
    {
        this.row = UNSET;
        this.col = UNSET;
        this.length = length; 
        direction = -1;
    }
    
    //determines wether or not the ships location has been set
    public boolean isLocationSet()
    {
        if(locationSet)
        {
            return true;
        }
        
        return false;
    }
    
    //determines if the direction has been set
    public boolean isDirectionSet()
    {
        if(directionSet)
        {
            return true;
        }
        return false;
    }
    
    //function to set the location of the ship
    public void setLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
        locationSet = true;
    }
    
    //function to set the location of the ship
    public void setDirection(int direction)
    {
        this.direction = direction;
        directionSet = true;
    }
    
    //return the row of the ship
    public int getRow()
    {
        return this.row;
    }
    
    //returns the column of the ship
    public int getCol()
    {
        return this.col;
    }
    
    public int getLength()
    {
        return this.length;
    }
    
    public int getDirection()
    {
        return this.direction;
    }
    
    private String directionToString()
    {
        if(this.direction == -1)
        {
            return "unset direction";
        }
        if(this.direction == 0)
        {
            return "horizontal";
        }
        if(this.direction == 1)
        {
            return "vertical";
        }
        return "";
    }
    
    private String locationToString()
    {
        if(locationSet)
        {
            return "(" + this.row + ", " + this.col + ")";
        }
        else
        {
            return "(unset location)";
        }
    }
    
    public String toString()
    {
        return directionToString() + " ship of length " + this.length + " at " + locationToString();
    }
    
}
