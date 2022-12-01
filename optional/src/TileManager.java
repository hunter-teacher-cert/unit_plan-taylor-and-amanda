
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;



/**
 *
 * @author Amanda
 */
public class TileManager {
    
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    
    public TileManager(GamePanel gp)
    {
        this.gp = gp;
        
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        getTileImage();
        loadMap("/maps/world01.txt");
    }
    
    public void getTileImage()
    {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadMap(String filePath) 
    {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); //uses this to import the text file and read the content of the text file
            
            int col = 0;
            int row = 0;
            
            while (col < gp.maxWorldCol && row < gp.maxWorldRow)
            {
                String line = br.readLine(); //reads a single line of text
                
                while (col < gp.maxWorldCol)
                {
                    String numbers[] = line.split(" "); //catches each number seperated by line
                    
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol)
                {
                    col = 0;
                    row++;
                }
            }
            br.close();
            
        }catch(Exception e){
            
        }
    }
    public void draw(Graphics2D g2)
    {
        
        // METHOD 1: one way to draw is...
//        for (int i = 0; i < 192; i+=48)
//        {
//            g2.drawImage(tile[1].image, i, 0, gp.size, gp.size, null);
//        }
//        
//        g2.drawImage(tile[1].image, 0, 48, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 48, 48, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 96, 48, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 144, 48, gp.size, gp.size, null);
//        g2.drawImage(tile[1].image, 192, 48, gp.size, gp.size, null);
//        
//        g2.drawImage(tile[1].image, 0, 96, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 48, 96, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 96, 96, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 144, 96, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 192, 96, gp.size, gp.size, null);
//        
//        g2.drawImage(tile[1].image, 0, 144, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 48, 144, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 96, 144, gp.size, gp.size, null);
//        g2.drawImage(tile[0].image, 144, 144, gp.size, gp.size, null);
//        g2.drawImage(tile[1].image, 192, 144, gp.size, gp.size, null);
//        
//        g2.drawImage(tile[1].image, 0, 192, gp.size, gp.size, null);
//        g2.drawImage(tile[2].image, 48, 192, gp.size, gp.size, null);
//        g2.drawImage(tile[2].image, 96, 192, gp.size, gp.size, null);
//        g2.drawImage(tile[2].image, 144, 192, gp.size, gp.size, null);
//        g2.drawImage(tile[1].image, 192, 192, gp.size, gp.size, null);
        
//        g2.drawImage(tile[1].image, 48, 0, gp.size, gp.size, null);
//        g2.drawImage(tile[2].image, 96, 0, gp.size, gp.size, null);
        
        // OKAY that was super tiring, let's automate this process
        // METHOD 2
        /*
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while (col < gp.maxCol && row < gp.maxRow)
        {
            g2.drawImage(tile[0].image,x, y, gp.size, gp.size, null);
            col++;
            x += gp.size;
            
            if (col == gp.maxCol)
            {
                col = 0;
                x = 0;
                row++;
                y += gp.size;
            }
        } // now the entire background is all grass
        */
        
        // method 3
        int worldCol = 0;
        int worldRow = 0;
//        int x = 0;
//        int y = 0;
        
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
        {
            
            int tileNum = mapTileNum[worldCol][worldRow];
            
            int worldX = worldCol * gp.size; // checks the tile
            int worldY = worldRow * gp.size;
            int screenX = worldX - gp.player.worldX + gp.player.screenX; 
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            

            // the problem is that this draws the entire 50x50 map, this is pretty small for now
            // but if you have a larger map, it can cause your computer to slow down
            if (worldX + gp.size > gp.player.worldX - gp.player.screenX &&
                worldX - gp.size < gp.player.worldX + gp.player.screenX &&
                worldY + gp.size > gp.player.worldY - gp.player.screenY &&
                worldY - gp.size < gp.player.worldY + gp.player.screenY)
            {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.size, gp.size, null);
            }
            
            worldCol++;
            
            if (worldCol == gp.maxWorldCol)
            {
                worldCol = 0;
                worldRow++;

            }
        }
        
        
        
        
    }
}
