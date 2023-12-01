import javax.swing.*;
import java.awt.event.WindowEvent;

public class Launcher {

    private Game game;

    private JPanel title;

    private JFrame window;

    public Launcher() {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Galactic Mail");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void initUIComponents() {
        game = new Game();
        window.add(game);

        window.pack();
        game.startGameThread();
        game.requestFocus();
    }

    public static void main(String[] args) {
        Launcher launch = new Launcher();
        launch.initUIComponents();
    }

    public void closeGame(){
        this.window.dispatchEvent(new WindowEvent(this.window, WindowEvent.WINDOW_CLOSING));
    }

}
