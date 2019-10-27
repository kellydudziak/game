import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotion implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //https://stackoverflow.com/questions/1837000/java-2d-hovering-over-circle

//        for (Square square[] : MainFrame.squares) {
//            for (Square sq : square) {
//            if (sq.
//                    contains(e.getPoint())) {
//                // change its color
//            }
//        }
//        if (MainFrame.squares[e.getX()][e.getY()] != null) {
//            Square square = MainFrame.squares[e.getX()][e.getY()];
//            MainFrame.changeColor(square.color, 5);
//        }
        // get square object at e.getX(), e.getY()
        // change square color by some number
        // change squares one away by another number
        // change squares two away by another number
        System.out.println(e.getX() + " " + e.getY());
    }
}
