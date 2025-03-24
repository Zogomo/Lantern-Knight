package entity;

abstract class AirNPC extends NPC
{
    private int ID = 0;
    public AirNPC()
    {
        super();
    }

    public AirNPC(String newDialogue)
    {
        super(newDialogue);
    }
}
