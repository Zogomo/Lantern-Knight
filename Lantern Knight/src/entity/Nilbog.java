package entity;

final class Nilbog extends GroundNPC 
{
    private int ID = 0;

    public Nilbog()
    {
        super();
        super.setDialogue("I is not gobbo.", "Beat me, hurt me, make me write bad checks.");
    }

    public Nilbog(String newDialogue)
    {
        super(newDialogue);
    }

    @Override
    public void updateHealth(int newHealth) 
    {
        health -= newHealth;
        System.out.println(health);
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
        System.out.println("Drawing a Nilbog");
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
