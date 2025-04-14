package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager 
{
    GamePanel gPanel;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gPanel)
    {
        this.gPanel = gPanel;
        tile = new Tile[3]; //Random can be changed to suit needs.
        mapTileNum = new int[GamePanel.maxWorldCol][GamePanel.maxWorldRow];
        getTileImage();
        loadMap("/res/maps/map1.txt");
    }

    public void loadMap(String mapPath)
    {
        try 
        {
            InputStream is = getClass().getResourceAsStream(mapPath); 
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < GamePanel.maxWorldCol && row < GamePanel.maxWorldRow)
            {
                String line = br.readLine();

                while(col < GamePanel.maxWorldCol)
                {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == GamePanel.maxWorldCol)
                {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void getTileImage()
    {
        BufferedImage floorSS = null;
        BufferedImage waterSS = null;
        BufferedImage wallSS = null;
        /* 
        SpriteLoader loader = new SpriteLoader();
        BufferedImage floorSS = null;
        BufferedImage waterSS = null;
        BufferedImage wallSS = null;
        
        try 
        {
            floorSS = loader.loadImage("Floors_Tiles.png");
            waterSS = loader.loadImage("Water_tiles.png");
            wallSS = loader.loadImage("Wall_Tiles.png");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        SpriteSheet floorSheet = new SpriteSheet(floorSS);
        SpriteSheet waterSheet = new SpriteSheet(waterSS);
        SpriteSheet wallSheet = new SpriteSheet(wallSS);
        */
        

        try 
        {
            floorSS = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Floors_Tiles.png"));
            waterSS = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Water_Tiles.png"));
            wallSS = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall_Tiles.png"));

            tile[0] = new Tile();
            tile[0].image = floorSS.getSubimage(16, 10*16, 16, 16);    //grass

            tile[1] = new Tile();
            tile[1].image = waterSS.getSubimage(16, 6*16, 16, 16);     //water
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = wallSS.getSubimage(16, 2*16, 16, 16);      //wall
            tile[2].collision = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2)
    {
        int worldCol = 0;
        int worldRow = 0;

        //Sets what tile is where on the map row by row.
        while(worldCol < GamePanel.maxWorldCol && worldRow < GamePanel.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * GamePanel.tileSize;
            int worldY = worldRow * GamePanel.tileSize;
            int screenX = (int) (worldX - gPanel.pc.worldX + gPanel.pc.screenX);
            int screenY = (int) (worldY - gPanel.pc.worldY + gPanel.pc.screenY);

            //Limits how many tiles are rendered to just what is needed for the player.
            if (worldX  + GamePanel.tileSize > gPanel.pc.worldX - gPanel.pc.screenX &&
            worldX  - GamePanel.tileSize < gPanel.pc.worldX + gPanel.pc.screenX &&
            worldY  + GamePanel.tileSize > gPanel.pc.worldY - gPanel.pc.screenY &&
            worldY  - GamePanel.tileSize < gPanel.pc.worldY + gPanel.pc.screenY)
            {
                g2.drawImage(tile[tileNum].image, screenX, screenY, GamePanel.tileSize, GamePanel.tileSize, null);
            }

            worldCol++;

            if(worldCol == GamePanel.maxWorldCol)
            {
                worldCol = 0;
                worldRow++;

            }
        }
    }
}
