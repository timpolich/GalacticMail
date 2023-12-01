import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ship extends GameObject {

    private final int SPEED = 6;
    private final float ROTATIONSPEED = 4f;

    private BufferedImage shipImg;
    private boolean UpPressed;
    private boolean LeftPressed;
    private boolean RightPressed;
    public boolean LandPressed;
    private boolean Destroyed = false;

    public Ship(int x, int y, int vx, int vy, int angle) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        try {
            this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Flying.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        this.angle = angle;
        this.hitBox = new Rectangle();
        this.hitBox.setRect(this.x, this.y, this.shipImg.getWidth(), this.shipImg.getHeight());
    }

    void toggleUpPressed() {
        this.UpPressed = true;
    }

    void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    void toggleRightPressed() {
        this.RightPressed = true;
    }

    void toggleLandPressed() {
        if(this.LandPressed == false) {
            this.LandPressed = true;
            playSound(0);
            try {
                this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Landed.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(this.LandPressed == true) {
            this.LandPressed = false;
            playSound(2);
            try {
                this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Flying.png"));
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    void unToggleUpPressed() {
        this.UpPressed = false;
    }

    void unToggleLeftPressed() {
        this.LeftPressed = false;
    }

    void unToggleRightPressed() {
        this.RightPressed = false;
    }

    @Override
    void update() {
        if(this.LandPressed == false) {
            if (this.UpPressed) {
                this.moveForward();
            }
            if (this.LeftPressed) {
                this.rotateLeft();
            }
            if (this.RightPressed) {
                this.rotateRight();
            }
        }
        if(this.Destroyed == true) {
            this.UpPressed = false;
            this.LeftPressed = false;
            this.RightPressed = false;
            this.LandPressed = false;
            try {
                this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Explosion0.png"));
                this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Explosion1.png"));
                this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Explosion2.png"));
                this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Explosion3.png"));
                this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Explosion4.png"));
                this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Explosion5.png"));
                this.shipImg = ImageIO.read(Game.class.getResourceAsStream("Explosion6.png"));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.hitBox.setLocation(this.x, this.y);
    }

    private void rotateLeft() {
        this.angle -= this.ROTATIONSPEED;
    }

    private void rotateRight() {
        this.angle += this.ROTATIONSPEED;
    }

    private void moveForward() {
        vx = (int) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;
        checkBorder();
    }

    public void destroy() {
        this.Destroyed = true;
        this.playSound(2);
    }

    private void checkBorder() {
        if (x < 0) {
            x = 0;
        }
        if (x >= GameConstants.GAME_SCREEN_WIDTH - 32) {
            x = GameConstants.GAME_SCREEN_WIDTH - 32;
        }
        if (y < 0) {
            y = 0;
        }
        if (y >= GameConstants.GAME_SCREEN_HEIGHT - 32) {
            y = GameConstants.GAME_SCREEN_HEIGHT - 32;
        }
    }


    void drawImage(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), this.shipImg.getWidth() / 2.0, this.shipImg.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.shipImg, rotation, null);
    }

}
