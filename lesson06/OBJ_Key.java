
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Amanda
 */
public class OBJ_Key extends SuperObject 
{

    public OBJ_Key() 
    {
        
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
