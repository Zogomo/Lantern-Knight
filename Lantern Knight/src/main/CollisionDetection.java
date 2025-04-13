package main;

import entity.Entity;

public class CollisionDetection 
{
    GamePanel gPanel;

    public CollisionDetection(GamePanel gPanel)
    {
        this.gPanel = gPanel;
    }

    public void checkTile(Entity entity)
    {
        int entityLeftX = (int) (entity.worldX + entity.hitBox.x);
        int entityRightX = (int) (entity.worldX + entity.hitBox.x + entity.hitBox.width);
        int entityTopY = (int) (entity.worldY + entity.hitBox.y);
        int entityBotY = (int) (entity.worldY + entity.hitBox.y + entity.hitBox.height);

        int entityLeftCol = entityLeftX/GamePanel.tileSize;
        int entityRightCol = entityRightX/GamePanel.tileSize;
        int entityTopRow = entityTopY/GamePanel.tileSize;
        int entityBotRow = entityBotY/GamePanel.tileSize;

        int tileNum1, tileNum2, tileNum3;

        switch(entity.direction)
        {
            case "upLeft":
                entityTopRow = (int) ((entityTopY - entity.speed)/(GamePanel.tileSize));
                entityLeftCol = (int) ((entityLeftX - entity.speed)/(GamePanel.tileSize ));
                tileNum1 = gPanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gPanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum3 = gPanel.tileM.mapTileNum[entityLeftCol][entityBotRow];
                if(gPanel.tileM.tile[tileNum1].collision == true || gPanel.tileM.tile[tileNum2].collision == true || gPanel.tileM.tile[tileNum3].collision == true)
                    {
                        entity.collision = true;
                    }
                break;

            case "upRight":
                entityTopRow = (int) ((entityTopY - entity.speed)/GamePanel.tileSize);
                entityRightCol = (int) ((entityRightX + entity.speed)/GamePanel.tileSize);
                tileNum1 = gPanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gPanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum3 = gPanel.tileM.mapTileNum[entityRightCol][entityBotRow];
                if(gPanel.tileM.tile[tileNum1].collision == true || gPanel.tileM.tile[tileNum2].collision == true || gPanel.tileM.tile[tileNum3].collision == true)
                    {
                        entity.collision = true;
                    }
                break;
            case "up":
                entityTopRow = (int) ((entityTopY - entity.speed)/GamePanel.tileSize);
                tileNum1 = gPanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gPanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gPanel.tileM.tile[tileNum1].collision == true || gPanel.tileM.tile[tileNum2].collision == true)
                    {
                        entity.collision = true;
                    }
                break;
            case "downLeft":
                entityBotRow = (int) ((entityBotY + entity.speed)/GamePanel.tileSize);
                entityLeftCol = (int) ((entityLeftX - entity.speed)/GamePanel.tileSize);
                tileNum1 = gPanel.tileM.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gPanel.tileM.mapTileNum[entityRightCol][entityBotRow];
                tileNum3 = gPanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                if(gPanel.tileM.tile[tileNum1].collision == true || gPanel.tileM.tile[tileNum2].collision == true || gPanel.tileM.tile[tileNum3].collision == true)
                    {
                        entity.collision = true;
                    }
                break;
            case "downRight":
                entityBotRow = (int) ((entityBotY + entity.speed)/GamePanel.tileSize);
                entityRightCol = (int) ((entityRightX + entity.speed)/GamePanel.tileSize);
                tileNum1 = gPanel.tileM.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gPanel.tileM.mapTileNum[entityRightCol][entityBotRow];
                tileNum3 = gPanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gPanel.tileM.tile[tileNum1].collision == true || gPanel.tileM.tile[tileNum2].collision == true || gPanel.tileM.tile[tileNum3].collision == true)
                    {
                        entity.collision = true;
                    }
                break;
            case "down":
                entityBotRow = (int) ((entityBotY + entity.speed)/GamePanel.tileSize);
                tileNum1 = gPanel.tileM.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gPanel.tileM.mapTileNum[entityRightCol][entityBotRow];
                if(gPanel.tileM.tile[tileNum1].collision == true || gPanel.tileM.tile[tileNum2].collision == true)
                    {
                        entity.collision = true;
                    }
                break;
            case "right":
                entityRightCol = (int) ((entityRightX + entity.speed)/GamePanel.tileSize);
                tileNum1 = gPanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gPanel.tileM.mapTileNum[entityRightCol][entityBotRow];
                if(gPanel.tileM.tile[tileNum1].collision == true || gPanel.tileM.tile[tileNum2].collision == true)
                    {
                        entity.collision = true;
                    }
                break;
            case "left":
                entityLeftCol = (int) ((entityLeftX - entity.speed)/GamePanel.tileSize);
                tileNum1 = gPanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gPanel.tileM.mapTileNum[entityLeftCol][entityBotRow];
                if(gPanel.tileM.tile[tileNum1].collision == true || gPanel.tileM.tile[tileNum2].collision == true)
                    {
                        entity.collision = true;
                    }
                break;
        }
    }

    public int checkObject(Entity entity, boolean isPlayer)
    {
        int index = 999;

        for(int i = 0; i < gPanel.obj.length; i++)
        {
            if(gPanel.obj[i] != null)
            {
                //Gets the hitbox of the entity.
                entity.hitBox.x = entity.worldX + entity.hitBox.x;
                entity.hitBox.y = entity.worldY + entity.hitBox.y;

                //Gets the hitbox of the object.
                gPanel.obj[i].hitBox.x = gPanel.obj[i].worldX + gPanel.obj[i].hitBox.x + gPanel.obj[i].hitBoxOffSetX;
                gPanel.obj[i].hitBox.y = gPanel.obj[i].worldY + gPanel.obj[i].hitBox.y + gPanel.obj[i].hitBoxOffSetY;

                switch(entity.direction)
                {
                    case "upLeft":
                        entity.hitBox.y -= entity.speed;
                        entity.hitBox.x -= entity.speed;
                        if (entity.hitBox.overlap(gPanel.obj[i].hitBox))
                        {
                            
                            if(gPanel.obj[i].collision == true)
                            {
                                entity.collision = true;
                                
                            }
                            if(isPlayer == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "upRight":
                        entity.hitBox.y -= entity.speed;
                        entity.hitBox.x += entity.speed;
                        if (entity.hitBox.overlap(gPanel.obj[i].hitBox))
                        {
                            if(gPanel.obj[i].collision == true)
                            {
                                entity.collision = true;
                            }
                            if(isPlayer == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "downLeft":
                        entity.hitBox.y += entity.speed;
                        entity.hitBox.x -= entity.speed;
                        if (entity.hitBox.overlap(gPanel.obj[i].hitBox))
                        {
                            if(gPanel.obj[i].collision == true)
                            {
                                entity.collision = true;
                            }
                            if(isPlayer == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "downRight":
                        entity.hitBox.y += entity.speed;
                        entity.hitBox.x += entity.speed;
                        if (entity.hitBox.overlap(gPanel.obj[i].hitBox))
                        {
                            if(gPanel.obj[i].collision == true)
                            {
                                entity.collision = true;
                            }
                            if(isPlayer == true)
                            {
                                index = i;
                            }
                        }
                    break;
                        case "up":
                        entity.hitBox.y -= entity.speed;
                        if (entity.hitBox.overlap(gPanel.obj[i].hitBox))
                        {
                            
                            if(gPanel.obj[i].collision == true)
                            {
                                entity.collision = true;
                            }
                            if(isPlayer == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.hitBox.y += entity.speed;
                        if (entity.hitBox.overlap(gPanel.obj[i].hitBox))
                        {
                            
                            if(gPanel.obj[i].collision == true)
                            {
                                entity.collision = true;
                            }
                            if(isPlayer == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.hitBox.y += entity.speed;
                        if (entity.hitBox.overlap(gPanel.obj[i].hitBox))
                        {
                            if(gPanel.obj[i].collision == true)
                            {
                                entity.collision = true;
                            }
                            if(isPlayer == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.hitBox.y -= entity.speed;
                        if (entity.hitBox.overlap(gPanel.obj[i].hitBox))
                        {
                            if(gPanel.obj[i].collision == true)
                            {
                                entity.collision = true;
                            }
                            if(isPlayer == true)
                            {
                                index = i;
                            }
                        }
                        break;
                }
                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                gPanel.obj[i].hitBox.x = gPanel.obj[i].hitBoxDefaultX;
                gPanel.obj[i].hitBox.y = gPanel.obj[i].hitBoxDefaultY;
            }
        }
        return index;
    }
}
