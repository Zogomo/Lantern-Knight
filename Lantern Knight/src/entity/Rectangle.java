package entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle 
{
    public double x;
    public double y;
    public double width;
    public double height;

    public Rectangle(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public boolean overlap(Rectangle other)
    {
        //Four possible cases:
        //To the left, right, above, or below.
        boolean noOverlap =
            this.x + this.width < other.x + 1 || //Left
            this.x + 1 > other.x + other.width || //Right
            this.y + this.height < other.y + 1|| //Below
            this.y + 1 > other.y + other.height; //Above
        return !noOverlap;
    }

    public void draw(Graphics2D g2, int screenX, int screenY)
    {
        g2.setColor(Color.RED);
        g2.fillRect(screenX, screenY, (int)width, (int)height);
    }
}
