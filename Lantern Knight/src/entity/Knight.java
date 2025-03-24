package entity;

final class Knight extends GroundNPC 
{
    private int ID = 0;
    public Knight()
    {
        super();
        super.setDialogue("I am a knight.", "I will lay the evil dragon.");
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

    @Override
    public void setMovementType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMovementType'");
    }

    @Override
    public void setMovementDistance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMovementDistance'");
    }
}
