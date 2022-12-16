
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


/**
 *
 * @author Amanda
 */
public class SuperObject {
    
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    
    // to draw the objects on screen
    public void draw(Graphics2D g2, GamePanel gp) 
    {
        // same as the tiles
        int screenX = worldX - gp.player.worldX + gp.player.screenX; 
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.size > gp.player.worldX - gp.player.screenX &&
            worldX - gp.size < gp.player.worldX + gp.player.screenX &&
            worldY + gp.size > gp.player.worldY - gp.player.screenY &&
            worldY - gp.size < gp.player.worldY + gp.player.screenY)
        {
            g2.drawImage(image, screenX, screenY, gp.size, gp.size, null);
        }
    }
}
