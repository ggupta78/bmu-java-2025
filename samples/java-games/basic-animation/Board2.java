import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board2 extends JPanel
    implements Runnable {

  private final int B_WIDTH = 650;
  private final int B_HEIGHT = 650;
  private final int INITIAL_X = 40;
  private final int INITIAL_Y = 10;
  private final int DELAY = 3;

  private Image[] stars = new Image[10];
  private int[] starY = new int[10];
  private Thread animator;
  private int x, y;

  public Board2() {

    initBoard();
  }

  private void loadImage() {

    ImageIcon ii = new ImageIcon("star_gold.png");
    Image star = ii.getImage();
    for (int i = 0; i < stars.length; i++) {
      stars[i] = star;

    }
  }

  private void initBoard() {

    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

    loadImage();

    x = INITIAL_X;
    y = INITIAL_Y;
    initStarY();
  }

  private void initStarY() {
    for (int i = 0; i < starY.length; i++) {
      starY[i] = INITIAL_Y - getRandomY();
    }
  }

  private int getRandomY() {
    return (int) (Math.random() * (160 - 40 + 1)) + 40;
  }

  @Override
  public void addNotify() {
    super.addNotify();

    animator = new Thread(this);
    animator.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    drawStar(g);
  }

  private void drawStar(Graphics g) {

    for (int i = 0; i < stars.length; i++) {
      g.drawImage(stars[i], x + i * 60, starY[i] + i, this);
    }

    // The following line synchronises the painting on systems that buffer
    // graphics events. Without this line, the animation might not be smooth
    // on Linux.
    Toolkit.getDefaultToolkit().sync();
  }

  private void cycle() {

    incrementStarY();

    for (int i = 0; i < starY.length; i++) {
      if (starY[i] > B_HEIGHT) {
        starY[i] = INITIAL_Y - getRandomY();
      }
    }
  }

  private void incrementStarY() {
    for (int i = 0; i < starY.length; i++) {
      starY[i] = starY[i] + 1;
    }
  }

  @Override
  public void run() {

    long beforeTime, timeDiff, sleep;

    beforeTime = System.currentTimeMillis();

    // Main game loop
    while (true) {

      cycle();
      repaint();
      // break;

      // The above cycle() and repaint() method might take different time to
      // execute during each game loop, so below we are trying to ensure that
      // the length of each game loop is equivalent to the DELAY by making the
      // thread sleep for DELAY - (the time taken to execute cycle() + repaint())
      // However the minimum sleep is set at 2ms if the timediff >= DELAY
      timeDiff = System.currentTimeMillis() - beforeTime;
      sleep = DELAY - timeDiff;

      if (sleep < 0) {
        sleep = 2;
      }

      try {
        Thread.sleep(sleep);
      } catch (InterruptedException e) {

        String msg = String.format("Thread interrupted: %s", e.getMessage());

        JOptionPane.showMessageDialog(this, msg, "Error",
            JOptionPane.ERROR_MESSAGE);
      }

      beforeTime = System.currentTimeMillis();
    }
  }
}
