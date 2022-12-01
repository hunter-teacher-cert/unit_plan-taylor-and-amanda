
import javax.swing.JFrame;

public class Driver
{
    
    public static void main(String[] args) 
    {
        // STEP 1a
        // create a new window using JFrame
        JFrame window = new JFrame();
        
        // close the window properly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // user cannot change size
        window.setResizable(false);
        
        // set a title
        window.setTitle("2D Game");
        
        // ----------------------------
        // STEP 3a
        // after creating the game panel, create an obj and add it to the window
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        // causes the window to fit the preferred size of the game panel
        window.pack();
        
        //-----------------------------
        
        // STEP 1b
        // center the window
        window.setLocationRelativeTo(null);
        
        // user can see the window
        window.setVisible(true);
        
        
        // STEP 11
        // need to place before we start the game
        gamePanel.setupGame();
        
        // STEP 4
        gamePanel.startGameThread();
        
        
    }
}