package entity;

import GroundNPC;

final class Goblin extends GroundNPC
{
    public Goblin()
    {
        super("I is Gobbo.");
    }

    public Goblin(String newDialogue)
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
        System.out.println("Drawing a goblin");
    }
}
