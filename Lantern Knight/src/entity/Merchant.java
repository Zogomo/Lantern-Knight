package entity;

final class Merchant extends GroundNPC
{
    private String[] inventory;

    public Merchant()
    {
        super();
    }

    public Merchant(String newDialogue)
    {
        super(newDialogue);
    }

    public String[] getInventory()
    {
        return inventory;
    }

    public void setInventory(String[] newInventory)
    {
        inventory = newInventory;
    }

    public boolean addInventoryItem(String newItem)
    {
        return true;
    }

    public boolean removeInventoryItem(String oldItem)
    {
        return true;
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
        System.out.println("Drawing a merchant");
    }
}
