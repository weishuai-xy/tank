package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageTest {

    @Test
    void test1() {
        try{
            System.out.println(11);
//            BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/0.gif"));
            BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/0.gif"));
            assertNotNull(image);
        }catch (IOException e) {

        }


    }
}
