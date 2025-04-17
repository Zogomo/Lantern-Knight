package object;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject
{
    public OBJ_Key()
    {
        name = "Key";

        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/Resources.png"));
            image = image.getSubimage(96, 48, 16, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
