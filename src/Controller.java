import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    Ship ship;
    private int up;
    private int left;
    private int right;
    private int land;

    public Controller(Ship ship, int up, int left, int right, int land) {
        this.ship = ship;
        this.up = up;
        this.left = left;
        this.right = right;
        this.land = land;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == up) {
            this.ship.toggleUpPressed();
        }
        if(e.getKeyCode() == left) {
            this.ship.toggleLeftPressed();
        }
        if(e.getKeyCode() == right) {
            this.ship.toggleRightPressed();
        }
        if(e.getKeyCode() == land) {
            this.ship.toggleLandPressed();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == up) {
            this.ship.unToggleUpPressed();
        }
        if(e.getKeyCode() == left) {
            this.ship.unToggleLeftPressed();
        }
        if(e.getKeyCode() == right) {
            this.ship.unToggleRightPressed();
        }
    }

}
