
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


/**
 *
 * @author Amanda
 */
public class Entity {
    
    // this will store variables that will be used in player/monster/npc classes
    
    public int worldX, worldY;
    public int speed;
    
    // bufferedimage describes an image with accessible buffer of image data (stores image files)
    public BufferedImage up1, up2, up3, down1, down2, down3, right1, right2, left1, left2;
    public String direction;
    
    // to make them walk you need a counter
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    // make an abstract rectangle that we can store data in, x, y, w, and h
    public Rectangle solidArea;
    
    public boolean collisionOn = false;
    
}
