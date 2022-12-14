
/**
 *
 * @author Amanda
 */
public class CollisionChecker {
    
    GamePanel gp;
    
    public CollisionChecker(GamePanel gp)
    {
        this.gp = gp;
    }
    
    public void checkTile(Entity entity)
    {
        // need to check the four areas of the collision area
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
        
        int entityLeftCol = entityLeftWorldX/gp.size;
        int entityRightCol = entityRightWorldX/gp.size;
        int entityTopRow = entityTopWorldY/gp.size;
        int entityBottomRow = entityBottomWorldY/gp.size;
        
        int tileNum1, tileNum2;
        
        switch(entity.direction) 
        {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) /gp.size;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                    entity.collisionOn = true;
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) /gp.size;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                    entity.collisionOn = true;
                
                break;
            case "right":
                entityRightCol = (entityRightWorldX - entity.speed) /gp.size;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                    entity.collisionOn = true;
                
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX + entity.speed) /gp.size;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                    entity.collisionOn = true;
                
                break;
                
        }
        
    }
    
    public int checkObject(Entity entity, boolean player)
    {
        //check if player is hitting any obj, if it is, we return the index of the object
        int index = 999;
        
        for (int i = 0; i < gp.obj.length; i++)
        {
            // scan the obj array
            if (gp.obj[i] != null)
            {
                // get entity's solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                // get object's solid area position
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
                
                switch(entity.direction)
                {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        //automatically checks if the two are colliding or not
                        if (entity.solidArea.intersects(gp.obj[i].solidArea))
                        {
                            if (gp.obj[i].collision)
                            {
                                entity.collisionOn = true;
                            }
                            if (player)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea))
                        {
                            if (gp.obj[i].collision)
                            {
                                entity.collisionOn = true;
                            }
                            if (player)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea))
                        {
                            if (gp.obj[i].collision)
                            {
                                entity.collisionOn = true;
                            }
                            if (player)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea))
                        {
                            if (gp.obj[i].collision)
                            {
                                entity.collisionOn = true;
                            }
                            if (player)
                            {
                                index = i;
                            }
                        }
                        break;
                        
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index; 
    }

   
}
