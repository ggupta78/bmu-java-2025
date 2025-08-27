import java.awt.EventQueue;
import javax.swing.JFrame;

public class ThreadAnimationExample extends JFrame {

  public ThreadAnimationExample() {

    initUI();
  }

  private void initUI() {

    // add(new Board());
    add(new Board2());

    setResizable(false);
    pack();

    setTitle("Stars");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {

    EventQueue.invokeLater(() -> {
      JFrame ex = new ThreadAnimationExample();
      ex.setVisible(true);
    });
  }
}
