import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Asteroid extends GameObject {

    public BufferedImage asteroidImg;
    Random random = new Random();

    public Asteroid() {
        this.x = random.nextInt(GameConstants.GAME_SCREEN_WIDTH, GameConstants.GAME_SCREEN_WIDTH * 2);
        this.y = random.nextInt(GameConstants.GAME_SCREEN_HEIGHT, GameConstants.GAME_SCREEN_HEIGHT * 2);

        try {
            asteroidImg = ImageIO.read(Game.class.getResourceAsStream("Asteroid.png"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        this.hitBox = new Rectangle();
        this.hitBox.setRect(this.x, this.y, this.asteroidImg.getWidth(), this.asteroidImg.getHeight());
    }

    @Override
    void update() {
        x = x - 2;
        y = y - 2;

        if(x < 0 && y < 0) {
            x = random.nextInt(GameConstants.GAME_SCREEN_WIDTH, GameConstants.GAME_SCREEN_WIDTH * 2);
            y = random.nextInt(GameConstants.GAME_SCREEN_HEIGHT, GameConstants.GAME_SCREEN_HEIGHT * 2);
        }

        this.hitBox.setRect(this.x, this.y, this.asteroidImg.getWidth(), this.asteroidImg.getHeight());
    }
}
