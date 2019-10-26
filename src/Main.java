import javax.swing.*;

public class Main {
    static int WINDOW_WIDTH = 500;
    static int WINDOW_HEIGHT = 500;

    public static void main(String[] args) {
        createGUI();

    }

    private static void createGUI() {
        // Swing manages its own thread.
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                // Create and display window.
                JFrame jFrame = new MainFrame("Game");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
                //jFrame.pack(); // changes the size of frames according to size of components
                jFrame.setVisible(true);
            }
        });
    }
}
