import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    static int xPosition = 0;
    static int yPosition = 0;

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
                doDrawing(getGraphics());
               // printSquares(getGraphics());
            }
        });


    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int red = 1;
        int green = 50;
        int blue = 50;

        while (red < 255 && green < 255  && blue < 255) {
            g2d.setPaint(new Color(red, green, blue));

            while (xPosition < 1000) {
                g2d.fillRect(xPosition, yPosition, 10, 10);
                xPosition += 15;
            }
            xPosition = 0;
            yPosition += 15;
            red += 10;
            green += 10;
            blue += 10;
        }
    }

    private void printSquares(Graphics g) {
        Graphics2D graphics = (Graphics2D) g.create();


        graphics.setPaint(Color.black);
        while (xPosition < 1000) {
            graphics.fillRect(xPosition, yPosition, 10, 10);
            xPosition += 15;
            xPosition += 15;
        }
//        while (red < 255 && green > 0 && blue < 255) {
//            graphics.setPaint(new Color(red, green, blue));
//            red++;
//            blue++;
//            green--;
//            while (xPosition < Main.WINDOW_WIDTH) {
//                graphics.fillRect(xPosition, yPosition, 10, 10);
//                xPosition += 15;
//            }
//            yPosition += 15;
//        }
    }
}
