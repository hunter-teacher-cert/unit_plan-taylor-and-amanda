
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Amanda
 */
public class OBJ_Door extends SuperObject{
    public OBJ_Door() 
    {
        
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        // want to make this solid
        collision = true;
    }
}
