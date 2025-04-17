package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class PC extends Entity
{
    GamePanel gPanel;
    KeyHandler keyH;
    public int hasKey;
    int idleCount;

    public final int screenX;
    public final int screenY;

    public PC(GamePanel gPanel, KeyHandler keyH)
    {
        this.gPanel = gPanel;
        this.keyH = keyH;

        screenX = GamePanel.screenWidth / 2 - (GamePanel.tileSize / 2);
        screenY = GamePanel.screenHeight / 2 - (GamePanel.tileSize / 2);
        

        hitBox = new Rectangle(8, 16 , 32, 32);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues()
    {
        worldX = GamePanel.tileSize * 12;
        worldY = GamePanel.tileSize * 6;
        speed = 4;
        
        direction = "down";
    }

    public void getPlayerImage()
    {
        try {
            spriteSheet = ImageIO.read(getClass().getResourceAsStream("/res/player/Knight_M3_B.png"));
   
            up1 = spriteSheet.getSubimage(0, 48, 16, 16);
            up2 = spriteSheet.getSubimage(16, 48, 16, 16);
            up3 = spriteSheet.getSubimage(32, 48, 16, 16);
            down1 = spriteSheet.getSubimage(0, 0, 16, 16);
            down2 = spriteSheet.getSubimage(16, 0, 16, 16);
            down3 = spriteSheet.getSubimage(32, 0, 16, 16);
            left1 = spriteSheet.getSubimage(0, 16, 16, 16);
            left2 = spriteSheet.getSubimage(16, 16, 16, 16);
            left3 = spriteSheet.getSubimage(32, 16, 16, 16);
            right1 = spriteSheet.getSubimage(0, 32, 16, 16);
            right2 = spriteSheet.getSubimage(16, 32, 16, 16);
            right3 = spriteSheet.getSubimage(32, 32, 16, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void update()
    {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)
        {
            if(keyH.upPressed == true && keyH.leftPressed == true)
            {
                direction = "upLeft";
            }
            else if(keyH.upPressed == true && keyH.rightPressed == true)
            {
                direction = "upRight";
            }
            else if(keyH.downPressed == true && keyH.leftPressed == true)
            {
                direction = "downLeft";
            }
            else if(keyH.downPressed == true && keyH.rightPressed == true)
            {
                direction = "downRight";
            }
            else if(keyH.upPressed == true)
            {
                direction = "up";
            } 
            else if (keyH.downPressed == true)
            {
                direction = "down"; 
            }
            else if (keyH.leftPressed == true)
            {
                direction = "left";
            }
            else if (keyH.rightPressed == true)
            {
                direction = "right";
            }

            collision = false;

            //Checking collision.
            gPanel.cDet.checkTile(this);
            int objIndex = gPanel.cDet.checkObject(this, true);
            pickUpObject(objIndex);


            if (collision == false)
            {
                switch (direction) {
                    case "upLeft":
                        worldX -= Math.sqrt((speed*speed)/2); 
                        worldY -= Math.sqrt((speed*speed)/2);
                        break;
                    case "upRight":
                        worldX += Math.sqrt((speed*speed)/2); 
                        worldY -= Math.sqrt((speed*speed)/2); 
                        break;
                    case "downLeft":
                        worldX -= Math.sqrt((speed*speed)/2); 
                        worldY += Math.sqrt((speed*speed)/2); 
                        break;
                    case "downRight":
                        worldX += Math.sqrt((speed*speed)/2); 
                        worldY += Math.sqrt((speed*speed)/2);  
                        break;
                    case "up":
                        worldY -= speed; 
                        break;
                    case "right":
                        worldX += speed; 
                        break;
                    case "left":
                        worldX -= speed; 
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    default:
                        break;
                }
            }

            //Sets the rate of sprite change, currently once per 15 frames.
            spriteCounter++;
         
            if(spriteCounter > 15)
            {   
                if(spriteNum == 1)
                {
                    spriteNum = 2;
                }
                else if(spriteNum == 2)
                {
                    spriteNum = 3;
                }
                else if(spriteNum == 3)
                {
                    spriteNum = 4;
                }
                else if(spriteNum == 4)
                {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else {
            idleCount++;
            if (idleCount > 15)
            {
                spriteNum = 2;
                idleCount = 0;
            }
            
        }
    }

    
    public void pickUpObject(int i)
    {

        if(i != 999)
        {
            String objectName = gPanel.obj[i].name;
            switch(objectName)
            {
                case "Key":
                    gPanel.obj[i] = null;
                    hasKey++;
                    //System.out.println("Keys: " + hasKey);
                    
                    gPanel.ui.notification("You have picked up a key!");
        
                    break;     
                case "Chest":

                    String message = "The chest can't be opened without a key.";
                    if(gPanel.obj[i].opened == false && hasKey > 0)
                    {
                        gPanel.obj[i].image = gPanel.obj[i].imageAlt;
                        gPanel.obj[i].opened = true;
                        hasKey--;
                        //System.out.println("Keys: " + hasKey);
                        message = "The chest is open.";
                        gPanel.ui.notification("The chest has been opened!");
                        
                    }
                    else
                    {
                        gPanel.ui.notification(message);                       
                    }
                    break;
            }
        }
    }
    
    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;

        switch(direction) 
        {
            case "upLeft":
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                if(spriteNum == 3)
                {
                    image = up3;
                }
                if(spriteNum == 4)
                {
                    image = up2;
                }
                break;
            case "upRight":
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                if(spriteNum == 3)
                {
                    image = up3;
                }
                if(spriteNum == 4)
                {
                    image = up2;
                }
                break;
            case "up":
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                if(spriteNum == 3)
                {
                    image = up3;
                }
                if(spriteNum == 4)
                {
                    image = up2;
                }
                break;
            case "left":
                if(spriteNum == 1)
                {
                    image = left1;
                }
                if(spriteNum == 2)
                {
                    image = left2;
                }
                if(spriteNum == 3)
                {
                    image = left3;
                }
                if(spriteNum == 4)
                {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1)
                {
                    image = right1;
                }
                if(spriteNum == 2)
                {
                    image = right2;
                }
                if(spriteNum == 3)
                {
                    image = right3;
                }
                if(spriteNum == 4)
                {
                    image = right2;
                }
                break;
            case "downRight":
                if(spriteNum == 1)
                {
                    image = down1;
                }
                if(spriteNum == 2)
                {
                    image = down2;
                }
                if(spriteNum == 3)
                {
                    image = down3;
                }
                if(spriteNum == 4)
                {
                    image = down2;
                }
                break;
            case "downLeft":
                if(spriteNum == 1)
                {
                    image = down1;
                }
                if(spriteNum == 2)
                {
                    image = down2;
                }
                if(spriteNum == 3)
                {
                    image = down3;
                }
                if(spriteNum == 4)
                {
                    image = down2;
                }
                break;
            case "down":
                if(spriteNum == 1)
                {
                    image = down1;
                }
                if(spriteNum == 2)
                {
                    image = down2;
                }
                if(spriteNum == 3)
                {
                    image = down3;
                }
                if(spriteNum == 4)
                {
                    image = down2;
                }
                break;
            default:
                break;
        }
        g2.drawImage(image, screenX, screenY, GamePanel.tileSize, GamePanel.tileSize, null);
        //hitBox.draw(g2, screenX + 8, screenY + 16);
    }
}
