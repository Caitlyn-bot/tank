import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 张志伟
 * @version v1.0
 */
public class ImageTest {
    @Test
    void test(){
//        fail("Not yet implemented");
        try {
            InputStream path = this.getClass().getClassLoader().getResourceAsStream("images/bulletD.gif");
            System.out.println(path);
            BufferedImage image = ImageIO.read(path);
            assertNotNull(new Object());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
