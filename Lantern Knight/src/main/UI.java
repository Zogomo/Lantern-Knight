package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Key;

public class UI 
{
    GamePanel gPanel;
    Font font;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    public int messageTime = 0;

    public UI(GamePanel gPanel)
    {
        this.gPanel = gPanel;
        font = new Font("Arial", Font.PLAIN, 40);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }

    public void notification(String text)
    {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2)
    {
        g2.setFont(font);
        g2.setColor(Color.YELLOW);
        g2.drawImage(keyImage, GamePanel.tileSize/2, GamePanel.tileSize/2, GamePanel.tileSize, GamePanel.tileSize, null);
        g2.drawString("x " + gPanel.pc.hasKey, 74, 60);

        if(messageOn == true)
        {
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, (GamePanel.screenWidth / 2) - (GamePanel.tileSize * 5), (GamePanel.screenHeight / 2) - GamePanel.tileSize);

            messageTime++;

            if (messageTime > 120)
            {
                messageTime = 0;
                messageOn = false;
            }
        }
    }
}
