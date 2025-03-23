package arenas;

import entity.*;
final class Arena
{
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

    @Override
    public void draw() 
    {
        System.out.println("Drawing the arena.");
    }
}
