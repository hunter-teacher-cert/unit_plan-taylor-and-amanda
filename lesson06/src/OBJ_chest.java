
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Amanda
 */
public class OBJ_chest extends SuperObject{
    
    public OBJ_chest() 
    {
        
        name = "chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
