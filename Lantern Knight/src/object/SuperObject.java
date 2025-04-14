package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Rectangle;
import main.GamePanel;

public class SuperObject 
{
    public BufferedImage image;
    public BufferedImage imageAlt;
    public String name;
    public boolean collision = false;
    public boolean interactable = false;
    public double worldX;
    public double worldY;
    public int objectWidth = GamePanel.tileSize;
    public int objectHeight = GamePanel.tileSize;
    public int hitBoxOffSetX = 0;
    public int hitBoxOffSetY = 0;
    public int hitBoxWidth = objectWidth - hitBoxOffSetX/2;
    public int hitBoxHeight = objectHeight - hitBoxOffSetY;
    public Rectangle hitBox = new Rectangle(hitBoxOffSetX, hitBoxOffSetY, hitBoxWidth, hitBoxHeight);
    public int hitBoxDefaultX = 0;
    public int hitBoxDefaultY = 0;
    public boolean opened = true;
    

    public void draw(Graphics2D g2, GamePanel gPanel)
    {
        int screenX = (int) (worldX - gPanel.pc.worldX + gPanel.pc.screenX);
        int screenY = (int) (worldY - gPanel.pc.worldY + gPanel.pc.screenY);
        
        //Limits how many tiles are rendered to just what is needed for the player.
        if (worldX  + GamePanel.tileSize > gPanel.pc.worldX - gPanel.pc.screenX &&
        worldX  - GamePanel.tileSize < gPanel.pc.worldX + gPanel.pc.screenX &&
        worldY  + GamePanel.tileSize > gPanel.pc.worldY - gPanel.pc.screenY &&
        worldY  - GamePanel.tileSize < gPanel.pc.worldY + gPanel.pc.screenY)
        {
            g2.drawImage(image, screenX, screenY, objectWidth, objectHeight, null); //draws from top left corner
            //hitBox.draw(g2, screenX + hitBoxOffSetX, screenY + hitBoxOffSetY); //For bug fixing 
        }
    }
}
