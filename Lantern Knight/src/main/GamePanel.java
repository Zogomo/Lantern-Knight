package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.PC;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable 
{
    //Screen Setting
    public final static int originalTileSize = 16;//16 * 16 Pixels
    public final static int scale = 3;

    public final static int tileSize = originalTileSize * scale;//48x48 tile
    public final static int maxScreenCol = 16;
    public final static int maxScreenRow = 12;
    public final static int screenWidth = tileSize * maxScreenCol;//768 Pixels
    public final static int screenHeight = tileSize * maxScreenRow;//576 Pixels

    //World Settings
    public final static int maxWorldCol = 50;
    public final static int maxWorldRow = 50;
    public final static int worldWidth = tileSize * maxWorldCol;
    public final static int worldHeight = tileSize * maxWorldRow;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    public CollisionDetection cDet = new CollisionDetection(this);
    public ObjectSetter oSetter = new ObjectSetter(this);
    public UI ui = new UI(this);
    public PC pc = new PC(this, keyH);
    public SuperObject obj[] = new SuperObject[10]; // Allows for 20 objects to be displayed at a time.
    
    int FPS = 60;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void initGame() 
    {
        oSetter.setObject();
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) 
        {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1)
            {
            //update character position
            update();
            //draw
            repaint();
            delta --;
            }
        }
    }

    public void update()
    {
        pc.update();

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);

        //Goes through all object types
        for(int i = 0; i < obj.length; i++)
        {
            if(obj[i] != null)
            {
                obj[i].draw(g2, this);
            }
        }
        
        pc.draw(g2);

        ui.draw(g2);

        g2.dispose();
    }
}
