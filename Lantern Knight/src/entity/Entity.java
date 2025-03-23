package entity;
public abstract class Entity implements AttackInterface, DefendInterface, Drawable, Movement
{
    protected int health = 100;
    protected int attack = 10;
    protected int defense = 10;
    protected int magicAtt = 10;
    protected int magicDef = 10;
    protected String name;
    protected String dialogue;
    protected int xPostition;
    protected int yPostition;

    public Entity ()
    {
        dialogue = "Who am I!!!";
    }

    public Entity (String newDialogue)
    {
        dialogue = newDialogue;
    }

    public void draw()
    {
        System.err.println("I am definitely being drawn at x = " + xPostition + ", y = " + yPostition);
    }

    public int getHealth()
    {
        return health;
    }

    public void updateHealth(int newHealth)
    {
        health += newHealth;
        System.out.println(health);
    }

    public int getAttack() 
    {
        return attack;
    }

    public void setAttack(int attack) 
    {
        this.attack = attack;
    }

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int defense) 
    {
        this.defense = defense;
    }

    public int getMagicAtt() 
    {
        return magicAtt;
    }

    public void setMagicAtt(int magicAtt) 
    {
        this.magicAtt = magicAtt;
    }

    public int getMagicDef() 
    {
        return magicDef;
    }

    public void setMagicDef(int magicDef) 
    {
        this.magicDef = magicDef;
    }

    public String getDialogue()
    {
        return dialogue;
    }

    public void setDialogue(String newDialogue)
    {
        dialogue = newDialogue;
    }

    public int getxPostition() 
    {
        return xPostition;
    }

    public void setxPostition(int xPostition) 
    {
        this.xPostition = xPostition;
    }

    public int getyPostition() 
    {
        return yPostition;
    }

    public void setyPostition(int yPostition) 
    {
        this.yPostition = yPostition;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) 
    {
        this.health = health;
    }

    public void attack()
    {
        System.out.println("Attacks");
    }

    public void defend()
    {
        System.out.println("Defends");
    }
}
