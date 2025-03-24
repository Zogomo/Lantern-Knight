package arenas;

import entity.*;
final class Arena
{
    private int ID = 0;
    Entity[] combatants;
    Entity combatantOne;
    Entity combatantTwo;

    public Arena()
    {

    }

    public Arena(Entity[] newEntities)
    {
        this.combatants = newEntities;
    }

    public void updateCombatantPositions(int xPostition, int yPostition)
    {
        System.out.println("Updating combatant positions");
    }


    public void draw() 
    {
        System.out.println("Drawing the arena.");
    }
}
