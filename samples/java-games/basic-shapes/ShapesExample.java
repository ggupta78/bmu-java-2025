import java.awt.EventQueue;
import javax.swing.JFrame;

public class ShapesExample extends JFrame {

  public ShapesExample() {

    initUI();
  }

  private void initUI() {

    add(new Board());

    setSize(660, 660);

    setTitle("Shapes");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }

  public static void main(String[] args) {

    EventQueue.invokeLater(() -> {
      ShapesExample ex = new ShapesExample();
      ex.setVisible(true);
    });
  }
}
