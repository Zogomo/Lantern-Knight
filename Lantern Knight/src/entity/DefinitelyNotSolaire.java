package entity;
final class DefinitelyNotSolaire extends PC 
{
    public DefinitelyNotSolaire()
    {
        super("I am definitely not Solaire. Praise the Sun!");
    }

    public DefinitelyNotSolaire(String newDialogue)
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
        System.out.println("Drawing Solaire, I mean, not Solaire");
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
