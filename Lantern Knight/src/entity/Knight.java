package entity;

final class Knight extends GroundNPC 
{
    public Knight()
    {
        super("I am a knight.");
    }

    public Knight(String newDialogue)
    {
        super(newDialogue);
    }

    @Override
    public void setAttack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAttack'");
    }

    @Override
    public void setDefense() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDefense'");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a knight");
    }
}
