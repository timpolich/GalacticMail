import java.awt.*;

public class Score {

    private int score = 500;
    private int x = 20;
    private int y = 20;

    public Score() {

    }

    public void update(int i) {
        score = score + i;
    }

    public void drawScore(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.drawString("Score: " + score, x, y);
    }

}
