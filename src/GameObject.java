import java.awt.*;

abstract class GameObject {

    public int x;
    public int y;
    public int vx;
    public int vy;
    public float angle;

    GameSound sound = new GameSound();
    public Rectangle hitBox;

    abstract void update();

    public void playSound(int i) {
        sound.setFile(i);
        sound.play();
    }

    public boolean isCollision(GameObject other) {
        if(this.hitBox.intersects(other.hitBox)) {
            return true;
        }
        else {
            return false;
        }
    }

}
