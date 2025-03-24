package entity;

abstract class GroundNPC extends NPC
{
    private int ID = 0;
    public GroundNPC()
    {
        super();
    }

    public GroundNPC(String newDialogue)
    {
        super(newDialogue);
    }
}

