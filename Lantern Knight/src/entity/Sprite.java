package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite 
{
    public Vector position;
    public Vector velocity;
    public Image image;
    public Rectangle boundary;

    public Sprite()
    {
        position = new Vector(0, 0);
        velocity = new Vector(0, 0);
        boundary = new Rectangle(0, 0, 0, 0);
    }
    public void setPosition(double x, double y)
    {
        position.set(x, y);
    }

    public void setImage(String filename)
    {
        image = new Image(filename);
        boundary.width = image.getWidth();
        boundary.height = image.getHeight();
    }

    public Rectangle getBoundary()
    {
        return new Rectangle(position.x, position.y,
         image.getWidth(), image.getHeight());

    }

    public boolean overlaps(Sprite other)
    {
        return this.getBoundary().overlap(other.getBoundary());
    }

    public void render(GraphicsContext context)
    {
        context.drawImage(image, position.x, position.y);
    }
}
