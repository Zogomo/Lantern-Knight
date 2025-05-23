package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener 
{
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean sprint;

    @Override
    public void keyTyped(KeyEvent event) 
    {

    }

    @Override
    public void keyPressed(KeyEvent event) 
    {
        int code = event.getKeyCode();

        if (code == KeyEvent.VK_W)
        {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S)
        {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D)
        {
            rightPressed = true;
        } 
        if (code == KeyEvent.VK_SHIFT)
        {
            sprint = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) 
    {
        int code = event.getKeyCode();

        if (code == KeyEvent.VK_W)
        {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S)
        {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D)
        {
            rightPressed = false;
        } 
        if (code == KeyEvent.VK_SHIFT)
        {
            sprint = false;
        }
    }
    
}
