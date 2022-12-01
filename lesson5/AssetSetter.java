
/**
 *
 * @author Amanda
 */
public class AssetSetter {
    
    GamePanel gp;
    
    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }
    
    public void setObject() 
    {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 23 * gp.size;
        gp.obj[0].worldY = 7 * gp.size;
        
        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 23 * gp.size;
        gp.obj[1].worldY = 40 * gp.size;
        
        gp.obj[2] = new OBJ_Key();
        gp.obj[2].worldX = 37 * gp.size;
        gp.obj[2].worldY = 7 * gp.size;
        
        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 10 * gp.size;
        gp.obj[3].worldY = 11 * gp.size;
        
        gp.obj[4] = new OBJ_Door();
        gp.obj[4].worldX = 8 * gp.size;
        gp.obj[4].worldY = 28 * gp.size;
        
        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 12 * gp.size;
        gp.obj[5].worldY = 22 * gp.size;
        
        gp.obj[6] = new OBJ_chest();
        gp.obj[6].worldX = 10 * gp.size;
        gp.obj[6].worldY = 7 * gp.size;
        
        
        
        
        
        
    }
}
