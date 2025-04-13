package object;

import javax.imageio.ImageIO;

import entity.Rectangle;
import main.GamePanel;

public class OBJ_Chest extends SuperObject
{
    public OBJ_Chest()
    {
        name = "Chest";
        collision = true;
        opened = false;
        objectWidth = GamePanel.tileSize - 12;
        objectHeight = GamePanel.tileSize * 2 - 24;
        hitBoxOffSetY = objectHeight/2;
        hitBoxWidth = objectWidth - hitBoxOffSetX/2;
        hitBoxHeight = objectHeight/2;
        
        hitBox = new Rectangle(0, hitBoxOffSetY, hitBoxWidth, hitBoxHeight);

        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("Furniture.png"));
            imageAlt = image.getSubimage(736, 160, 16, 32);
            image = image.getSubimage(752, 160, 16, 32);
        }    
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
