package entity;

import Attitudes;

public abstract class NPC extends Entity
{
    Attitudes myAttitude = Attitudes.Neutral;

    public NPC()
    {
        super("I am an NPC. Not Politically Correct.");
    }

    public NPC(String newDialogue)
    {
        super(newDialogue);
    }

    public Attitudes getAttitude() 
    {
        return myAttitude;
    }

    public void setAttitudes(Attitudes newAttitude) 
    {
        this.myAttitude = newAttitude;
    }

    public boolean isHostile()
    {
        return myAttitude == Attitudes.Hostile; 
    }
}
