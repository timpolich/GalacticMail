import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Game extends JPanel implements Runnable {

    int fps = 60;

    GameSound sound = new GameSound();
    GameWorld world = new GameWorld(this);
    Score score = new Score();
    Ship ship = new Ship(100, 100, 0, 0, 0);
    Controller player = new Controller(ship, KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SPACE);
    Thread gameThread;

    public Game() {
        this.setPreferredSize(new Dimension(GameConstants.GAME_SCREEN_WIDTH, GameConstants.GAME_SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(player);
        this.setFocusable(true);
        this.playMusic(3);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/fps;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        world.update();
        ship.update();
        if(ship.isCollision(world.map[0]) && ship.LandPressed) {
            score.update(100);
        }
        if(ship.isCollision(world.map[1]) && ship.LandPressed) {
            score.update(100);
        }
        if(ship.isCollision(world.map[2]) && ship.LandPressed) {
            score.update(100);
        }
        if(ship.isCollision(world.map[3]) && ship.LandPressed) {
            score.update(100);
        }
        if(ship.isCollision(world.map[4]) && ship.LandPressed) {
            score.update(100);
        }
        if(ship.isCollision(world.asteroids[0]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[1]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[2]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[3]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[4]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[5]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[6]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[7]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[8]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[9]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[10]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[11]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[12]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[13]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[14]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[15]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[16]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[17]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[18]) && !ship.LandPressed) {
            ship.destroy();
        }
        if(ship.isCollision(world.asteroids[19]) && !ship.LandPressed) {
            ship.destroy();
        }
        score.update(-1);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        world.drawWorld(g2);
        score.drawScore(g2);
        ship.drawImage(g2);
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

}
