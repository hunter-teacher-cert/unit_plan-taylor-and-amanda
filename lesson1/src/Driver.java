
import javax.swing.JFrame;

public class Driver
{
    
    public static void main(String[] args) 
    {
        // create a new window using JFrame
        JFrame window = new JFrame();
        
        // close the window properly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // user cannot change size
        window.setResizable(false);
        
        // set a title
        window.setTitle("2D Game");
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        // causes the window to fit the preferred size of the game panel
        window.pack();
        
        // center the window
        window.setLocationRelativeTo(null);
        
        // user can see the window
        window.setVisible(true);
        
        ;
        
        
    }
}