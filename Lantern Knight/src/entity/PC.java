package entity;
public abstract class PC extends Entity
{
    private int ID = 0;

    public PC()
    {
        super("I am a PC. Player Character, not personal computer.");
    }

    public PC(String newDialogue)
    {
        super(newDialogue);
    }
}
