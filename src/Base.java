import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Base extends GameObject {

    public BufferedImage baseImg;
    private BufferedImage[] Images = new BufferedImage[10];
    private Random random = new Random();

    public Base() {
        this.x = random.nextInt(GameConstants.GAME_SCREEN_WIDTH - GameConstants.TILE_SIZE);
        this.y = random.nextInt(GameConstants.GAME_SCREEN_HEIGHT - GameConstants.TILE_SIZE);
        baseImg = getBaseImg(random.nextInt(7));
        this.hitBox = new Rectangle();
        this.hitBox.setRect(this.x, this.y, GameConstants.TILE_SIZE, GameConstants.TILE_SIZE);
    }

    public BufferedImage getBaseImg(int i) {
        try {
            Images[0] = ImageIO.read(Game.class.getResourceAsStream("Base0.png"));
            Images[1] = ImageIO.read(Game.class.getResourceAsStream("Base1.png"));
            Images[2] = ImageIO.read(Game.class.getResourceAsStream("Base2.png"));
            Images[3] = ImageIO.read(Game.class.getResourceAsStream("Base3.png"));
            Images[4] = ImageIO.read(Game.class.getResourceAsStream("Base4.png"));
            Images[5] = ImageIO.read(Game.class.getResourceAsStream("Base5.png"));
            Images[6] = ImageIO.read(Game.class.getResourceAsStream("Base6.png"));
            Images[7] = ImageIO.read(Game.class.getResourceAsStream("Base7.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return Images[i];
    }

    @Override
    void update() {

    }

}
