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
        gPanel.obj[0].worldX = 24 * GamePanel.tileSize + GamePanel.tileSize / 2 + 6;
        gPanel.obj[0].worldY = 15 * GamePanel.tileSize;

        gPanel.obj[1] = new OBJ_Key();
        gPanel.obj[1].worldX = 42 * GamePanel.tileSize;
        gPanel.obj[1].worldY = 41 * GamePanel.tileSize;
    } 
}
