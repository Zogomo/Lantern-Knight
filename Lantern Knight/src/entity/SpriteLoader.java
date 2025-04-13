package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteLoader 
{
    public BufferedImage loadImage(String fileName) throws IOException
    {
        BufferedImage image = ImageIO.read(getClass().getResourceAsStream(fileName));
        return image;
    }
}
