import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {

    static final int maxX = Main.WINDOW_WIDTH;
    static final int maxY = Main.WINDOW_HEIGHT;
    static final int numRows = 50;
    static final int numCol = 50;

    public MainFrame(String title) {
        super(title);

        // Set layout manager.
        setLayout(new BorderLayout()); // lets you add components to top/bottom/left/right/center of frame

        // Create Swing components.
        JPanel panel = new JPanel();
        JButton button = new JButton("Click");

        // Add Swing components to JFrame's content pane.
        Container c = getContentPane();

        c.add(panel, BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);

        // Add behavior
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printSquares(getGraphics());
            }
        });


    }

    private void printSquares(Graphics g) {

        int squareSize = maxX / numRows;
        int padding = squareSize + 5;
        int colorChange = 255 / numRows;
        // TODO: handle larger values (colorChange is small when rgb is large)
        Random random = new Random();
        int red = random.nextInt(50);
        int green = random.nextInt(50);
        int blue = random.nextInt(50);
        int xPosition = 0;
        int yPosition = 0;

        Graphics2D g2d = (Graphics2D) g.create();

        while (red < 255 && green < 255 && blue < 255) {
            g2d.setPaint(new Color(red, green, blue));

            while (xPosition < maxX) {
                g2d.fillRect(xPosition, yPosition, squareSize, squareSize);
                xPosition += padding;
            }
            xPosition = 0;
            yPosition += padding;
            red += colorChange;
            green += colorChange;
            blue += colorChange;
        }
    }
}

