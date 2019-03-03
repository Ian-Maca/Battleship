public class Location
{
    //Implement the Location class here
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    public int status;
    
    public boolean beenHit;
    public boolean unGuessed;
    public boolean miss;
    public boolean ship;
    
    
    // Location constructor. 
    public Location()
    {
        beenHit = false;
        unGuessed = true;
        miss = false;
    }
    
    // Was this Location a hit?
    public boolean checkHit()
    {
        return beenHit;
    }
    
    // Was this location a miss?
    public boolean checkMiss()
    {
        return miss;
    }
    
    // Was this location unguessed?
    public boolean isUnguessed()
    {
        this.status = UNGUESSED;
        return unGuessed;
    }
    
    // Mark this location a hit.
    public void markHit()
    {
        beenHit = true;
        this.status = HIT;
    }
    
    // Mark this location a miss.
    public void markMiss()
    {
        miss = true;
        this.status = MISSED;
    }
    
    // Return whether or not this location has a ship.
    public boolean hasShip()
    {
        return ship;
    }
    
    // Set the value of whether this location has a ship.
    public void setShip(boolean val)
    {
        ship = val;
    }
    
    // Set the status of this Location.
    public void setStatus(int status)
    {
        if(status == UNGUESSED)
        {
            unGuessed = true;
        }
        if(status == HIT)
        {
            beenHit = true;
        }
        if(status == MISSED)
        {
            miss = true;
        }
        this.status = status;
    }
    
    // Get the status of this Location.
    public int getStatus()
    {
        return this.status;
    }
}
