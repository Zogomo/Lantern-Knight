package entity;

final class Goblin extends GroundNPC
{
    private int ID = 0;
 
    public Goblin()
    {
        super();
        setDialogue("I is Gobbo.", "I eat your spleen!");
    }

    public Goblin(String newDialogue)
    {
        super(newDialogue);
    }

    public void setDialogue(String newDialogue, String catchPhrase) {

        super.setDialogue(newDialogue + " " + catchPhrase);
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
        System.out.println("Drawing a goblin");
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
