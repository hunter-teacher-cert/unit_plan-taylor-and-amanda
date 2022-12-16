
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Amanda
 */
public class Player extends Entity{
    
    GamePanel gp;
    Keyhandler key;
    
    public final int screenX; // where we draw the player on the screen
    public final int screenY;
    
    public Player(GamePanel gp, Keyhandler key)
    {
        this.gp = gp;
        this.key = key;
        
        screenX = gp.width/2 - (gp.size/2); // displayed at center of the screen
        screenY = gp.height/2 - (gp.size/2);
        
        // collision area
        solidArea = new Rectangle(8, 16, 32, 32);
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues() 
    {
        worldX = gp.size * 23;   //player position on world map
        worldY = gp.size * 21;
        speed = 4;
        direction = "down";
        
    }
    
    public void getPlayerImage()
    {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/pikachu/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/pikachu/up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/pikachu/up3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/pikachu/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/pikachu/down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/pikachu/down3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/pikachu/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/pikachu/right2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/pikachu/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/pikachu/left2.png"));
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update()
    {
        
        // will only move and animation when any of these keys are pressed
        if (key.up || key.down || key.left || key.right)
        {
            
            if (key.up)
            {
                direction = "up";
                 // y value increases when they go DOWN
            }
            else if (key.down)
            {
                direction = "down";
                
            }
            else if (key.right)
            {
                direction = "right";
                
            } // x value increases to the right
            else if (key.left)
            {
                direction = "left";
                
            }
            
            // checking tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            // if collision is false player can move
            if (!collisionOn)
            {
                switch (direction)
                {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "right": worldX += speed; break;
                    case "left": worldX -= speed; break;
                }
            }
            
            spriteCounter++;
            if (spriteCounter > 12)
            {
                if (spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2 && (direction == "up" || direction == "down")) {
                    spriteNum = 3;
                }
                else if (spriteNum == 2 )
                {
                    spriteNum = 1;
                }
                else if (spriteNum == 3)
                {
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }
        }
    }
    
    public void draw(Graphics2D g2)
    {
//        g2.setColor(Color.white);
//        //rectangle
//        g2.fillRect(x, y, gp.size, gp.size);
        
        BufferedImage image = null;
        
        switch(direction) {
            case "up":
                if (spriteNum == 1)
                {
                    image = up1;
                }
                if (spriteNum == 2)
                {
                    image = up2;
                }
                if (spriteNum == 3)
                {
                    image = up3;
                }
                break;
            case "down":
                if (spriteNum == 1)
                {
                    image = down1;
                }
                if (spriteNum == 2)
                {
                    image = down2;
                }
                if (spriteNum == 3)
                {
                    image = down3;
                }
                break;
            case "left":
                if (spriteNum == 1)
                {
                    image = left1;
                }
                if (spriteNum == 2)
                {
                    image = left2;
                }
                
                break;
            case "right":
                if (spriteNum == 1)
                {
                    image = right1;
                }
                if (spriteNum == 2)
                {
                    image = right2;
                }
                
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.size, gp.size, null); //image observer
    }
}
