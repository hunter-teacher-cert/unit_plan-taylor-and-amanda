
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */

// this class inherites Jpanel
public class GamePanel extends JPanel {
    // this is the game screen
    
    // screen settings
    final int originalSize = 16; // 16x16 standard size for many pixel games
    
    // we need to scale this size because of modern computer screen resolution
    // the 16 bit will look tiny on our screens, but fit the olden days of NES 256z224, GENESIS 320x224
    
    final int scale = 3; // common scaling
    
    final int size = originalSize * scale; // 48 x 48 will be displayed
    
    // screen will be 16 x 12
    final int maxCol = 16;
    final int maxRow = 12; 
    
    final int width = size * maxCol; // 768 p
    final int height = size * maxRow; // 576 p
    
    // create a constructor
    public GamePanel() {
        
        // set the size of this class
        this.setPreferredSize(new Dimension(width, height));
        
        // background color
        this.setBackground(Color.black);
        
        // all the drawings will be done in an offcreen painting buffer and is better for rendering performance
        this.setDoubleBuffered(true);
        
        //back to driver
        
        
    }
    
}
