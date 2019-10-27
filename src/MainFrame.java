import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {

    static final int maxPosition = Main.WINDOW_DIM;
    static final int numRows = 50;
    static Square[][] squares = new Square[maxPosition + 1][maxPosition + 1];
    static int colorChange = 255 / numRows;


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
                // printSquares(getGraphics());
                //drawSquares(getGraphics());
                doSquares(getGraphics());
                startMouseListener();
            }
        });


    }

    private void printSquares(Graphics g) {

        int squareSize = maxPosition / numRows;
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

            while (xPosition < maxPosition) {
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

    private void startMouseListener() {
        MouseMotion mouseMotion = new MouseMotion();
        addMouseMotionListener(mouseMotion);
    }

    private void drawSquares(Graphics graphics) {
        //TODO: organize this
        int xPosition = 0;
        int yPosition = 0;
        int squareSize = maxPosition / numRows;
        int padding = squareSize + 5;

        Color color = createColor();

        while (yPosition < maxPosition) {
            while (xPosition < maxPosition) {
                squares[xPosition][yPosition] = new Square(xPosition, yPosition, squareSize, getGraphics(), color);
                xPosition += padding;
            }
            xPosition = 0;
            yPosition += padding;
            color = changeColor(color, colorChange);
        }
    }

    private Color createColor() {
        Random random = new Random();
        return new Color(random.nextInt(50), random.nextInt(50), random.nextInt(50));
    }

    protected static Color changeColor(Color c, int colorChange) {
        int red = c.getRed() + colorChange;
        int green = c.getGreen() + colorChange;
        int blue = c.getBlue() + colorChange;

        if (red < 255 && green < 255 && blue < 255) {
            return new Color(c.getRed() + colorChange,
                    c.getGreen() + colorChange,
                    c.getBlue() + colorChange);
        } else {
            return Color.black;
        }
    }

    private void doSquares(Graphics graphics) {
        int xPosition = 0;
        int yPosition = 0;
        int squareSize = maxPosition / numRows;
        int padding = squareSize + 5;
        Graphics2D g2D = (Graphics2D) graphics;
        Color color = createColor();

        while (yPosition < maxPosition) {
            while (xPosition < maxPosition) {
                Rectangle rect = new Rectangle(xPosition, yPosition, squareSize, squareSize);
                g2D.setPaint(color);
                g2D.fill(rect);
                xPosition += padding;

                if (rect.contains(getMousePosition())) {
                    System.out.println("/????");
                }
            }
            xPosition = 0;
            yPosition += padding;
            color = changeColor(color, colorChange);
        }
    }
}


