package entity;

import java.awt.image.BufferedImage;

public class Entity 
{
    public double worldX;
    public double worldY;
    public double speed;

    public BufferedImage spriteSheet;
    public BufferedImage up1, up2, up3;
    public BufferedImage down1, down2, down3;
    public BufferedImage left1, left2, left3;
    public BufferedImage right1, right2, right3;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle hitBox;
    public double hitBoxDefaultX;
    public double hitBoxDefaultY;
    public Boolean collision = false;
}
