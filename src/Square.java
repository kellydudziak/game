import java.awt.*;

public class Square {
    Color color;

    public Square(int x, int y, int size, Graphics graphics, Color color) {
        this.color = color;
        Graphics2D g = (Graphics2D) graphics.create();
        g.setPaint(color);
        g.fillRect(x, y, size, size);
    }
}
