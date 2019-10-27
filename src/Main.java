import javax.swing.*;

public class Main {
    static int WINDOW_DIM = 500; // height and width must be equal

    public static void main(String[] args) {
        createGUI();

    }

    private static void createGUI() {
        // Swing manages its own thread.
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                // Create and display window.
                JFrame jFrame = new MainFrame("Squares");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setSize(WINDOW_DIM, WINDOW_DIM);
                jFrame.setLocationRelativeTo(null); // center window on screen
                //jFrame.pack(); // changes the size of frames according to size of components
                jFrame.setVisible(true);
            }
        });
    }



}
