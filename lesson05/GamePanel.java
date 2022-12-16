
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */


public class GamePanel extends JPanel implements Runnable // this class inherites Jpanel in 2, then runnable in 3
{
    // STEP 2a
    // this is the game screen
    
    // screen settings
    final int originalSize = 16; // 16x16 standard size for many pixel games
    
    // we need to scale this size because of modern computer screen resolution
    // the 16 bit will look tiny on our screens, but fit the olden days of NES 256z224, GENESIS 320x224
    
    final int scale = 3; // common scaling
    
    public final int size = originalSize * scale; // 48 x 48 will be displayed
    
    // screen will be 16 x 12
    public final int maxCol = 16;
    public final int maxRow = 12; 
    
    final int width = size * maxCol; // 768 p
    final int height = size * maxRow; // 576 p
    
    // STEP 3b
    // for time, can start and stop
    // once thread starts, keeps program running until stop
    Thread gameThread;
    
    
    // STEP 5a
    Keyhandler key = new Keyhandler();
    
//    // set player default position
//    int playerX = 100;        we don't need this anymore since we set it in the player class
//    int playerY = 100;
//    int playerSpeed = 4;
    
    int FPS = 60;
    
    // STEP 8 WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = size * maxWorldCol;
    public final int worldHeight = size * maxWorldRow;
    
    // STEP 9
    public CollisionChecker cChecker = new CollisionChecker(this);
    
    // STEP 6a
    public Player player = new Player(this, key);
    
    // Step 10
    public AssetSetter aSetter = new AssetSetter(this);
    // 10 slots to put in objects and display up to 10 at the same time
    public SuperObject obj[] = new SuperObject[10];
    
    
    // STEP 7a
    TileManager tileM = new TileManager(this);
    
    
    
    // STEP 2b
    // create a constructor
    public GamePanel() {
        
        // set the size of this class
        this.setPreferredSize(new Dimension(width, height));
        
        // background color
        this.setBackground(Color.black);
        
        // all the drawings will be done in an offcreen painting buffer and is better for rendering performance
        this.setDoubleBuffered(true);
        
        //back to driver
        
        // STEP 5b
        this.addKeyListener(key); // can recognize key input
        this.setFocusable(true); //gamepanel can be focused to receive key input
        
        
    }
    
    public void setupGame()
    {
        aSetter.setObject();
    }

    public void startGameThread() {
        // passing the game panel to the thread construction
        gameThread = new Thread(this);
        gameThread.start(); // will call run()
    }
    
    @Override
    // when we start the game thread, itll auto call the run method
    public void run() {
        // GAME LOOP (core of the game)
        
        double drawInt = 1000000000/FPS; //this is 1 sec, from nanosecond
        //draw the screen 60times in 1 second
        
        double delta = 0;
        
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while (gameThread != null) // as long as this game thread exists, it'll repeat the process that's written inside
        {
//            long currentTime = System.nanoTime();
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInt;
            timer += (currentTime - lastTime);
            
            lastTime = currentTime;
            
            if (delta >= 1)
            {
                // 1. update information (like character position)
                update();

                // 2. draw the screen with updated information
                repaint(); // calls paintComponent(g)
                
                delta--;
                drawCount++;
            }
            if (timer>= 1000000000)
            {
                System.out.println("FPS: " + drawCount);
                timer = 0;
                drawCount = 0;
            }
            
        }
    }
    
    public void update()
    {
        player.update();
    }
    
    public void paintComponent(Graphics g) // standard method to draw
    {
        // this is like your pencil 
        super.paintComponent(g); // parent class (jpanel)
        
        // graphics2D provides more control over cooridnate geometry, more colors, etc
        Graphics2D g2 = (Graphics2D)g;
        
        // needs to be before player because it's a layer underneath
        // tile
        tileM.draw(g2);
        
        // object
        for (int i = 0; i < obj.length; i++)
        {
            // scan the obj array 
            if (obj[i] != null) // if the obj is there
            {
                obj[i].draw(g2, this); //draw it
            }
        }
        
        //player
        player.draw(g2);
        
        g2.dispose();
    }
    
}
