package entity;
public abstract class PC extends Entity
{

    public PC()
    {
        super("I am a PC. Player Character, not personal computer.");
    }

    public PC(String newDialogue)
    {
        super(newDialogue);
    }
}
