import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class GameWorld {

    Game game;

    private BufferedImage Background;
    public Base[] map = new Base[5];
    public Asteroid[] asteroids = new Asteroid[20];
    private Random random = new Random();

    public GameWorld(Game game) {

        this.game = game;

        getBackgroundImage();
        loadMap();
        loadAsteroids();
    }

    public void getBackgroundImage() {
        try {
            this.Background = ImageIO.read(Game.class.getResourceAsStream("Background.bmp"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        for(int i = 0; i < map.length; i++) {
            this.map[i] = new Base();
        }
    }

    public void loadAsteroids() {
        for(int i = 0; i < asteroids.length; i++) {
            this.asteroids[i] = new Asteroid();
        }
    }

    public void update() {
        for(int i = 0; i < asteroids.length; i++) {
            asteroids[i].update();
        }
    }

    public void drawWorld(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.Background, 0, 0, GameConstants.GAME_SCREEN_WIDTH, GameConstants.GAME_SCREEN_HEIGHT, null);
        for(int i = 0; i < map.length; i++) {
            g2d.drawImage(this.map[i].baseImg, this.map[i].x, this.map[i].y, GameConstants.TILE_SIZE, GameConstants.TILE_SIZE, null);
        }
        for(int i = 0; i < asteroids.length; i++) {
            g2d.drawImage(this.asteroids[i].asteroidImg, this.asteroids[i].x, this.asteroids[i].y, null);
        }
    }

}
