package main;

import object.OBJ_Chest;
import object.OBJ_Key;

public class ObjectSetter 
{
    GamePanel gPanel;
    public ObjectSetter(GamePanel gPanel)
    {
        this.gPanel = gPanel;
    }

    public void setObject()
    {
        gPanel.obj[0] = new OBJ_Chest();
        gPanel.obj[0].worldX = 23 * GamePanel.tileSize + 6;
        gPanel.obj[0].worldY = 15 * GamePanel.tileSize;

        gPanel.obj[1] = new OBJ_Key();
        gPanel.obj[1].worldX = 5 * GamePanel.tileSize;
        gPanel.obj[1].worldY = 5 * GamePanel.tileSize;

        gPanel.obj[2] = new OBJ_Chest();
        gPanel.obj[2].worldX = 10 * GamePanel.tileSize + 6;
        gPanel.obj[2].worldY = 5 * GamePanel.tileSize;
    } 
}
