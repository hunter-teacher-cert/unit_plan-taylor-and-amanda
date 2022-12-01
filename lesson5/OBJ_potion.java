
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Amanda
 */
public class OBJ_potion extends SuperObject {
    public OBJ_potion() 
    {
        
        name = "potion";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/potion_red.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
