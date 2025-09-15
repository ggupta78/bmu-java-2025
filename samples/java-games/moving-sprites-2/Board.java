import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

  private final int ICRAFT_X = 40;
  private final int ICRAFT_Y = 60;
  private final int DELAY = 10;
  private Timer timer;
  private SpaceShip spaceShip;

  // For FPS calculation
  long lastTime = System.currentTimeMillis(); // The time of the last FPS update in milliseconds
  int frameCount = 0; // The number of frames rendered in the current second
  int lastFrameCount = 0;
  long fpsTimer = 0; // A timer to track when a full second has passed in milliseconds

  public Board() {
    initBoard();
  }

  private void initBoard() {

    addKeyListener(new TAdapter());
    setBackground(Color.BLACK);
    setFocusable(true);

    spaceShip = new SpaceShip(ICRAFT_X, ICRAFT_Y);

    timer = new Timer(DELAY, this);
    timer.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    doDrawing(g);

    Toolkit.getDefaultToolkit().sync();
  }

  private void doDrawing(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;

    g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
        spaceShip.getY(), this);

    List<Missile> missiles = spaceShip.getMissiles();

    for (Missile missile : missiles) {
      g2d.drawImage(missile.getImage(), missile.getX(),
          missile.getY(), this);
    }

    // printFPS(g2d);
  }

  private void printFPS(Graphics2D g2d) {
    // --- Step 1: Set the color of font ---
    g2d.setColor(Color.ORANGE);

    // --- Step 2: Set the font for the text ---
    // Creates a new font with a name ("Serif"), style (BOLD), and size (30).
    Font myFont = new Font("Serif", Font.PLAIN, 20);
    g2d.setFont(myFont);

    // --- Step 3: Draw the text on the screen ---
    // The drawString method takes the text string, and its x and y coordinates.
    // The coordinates specify the baseline of the text.
    g2d.drawString("FPS: " + lastFrameCount, 725, 20);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    updateMissiles();
    updateSpaceShip();

    // calculateFPS();

    repaint();
  }

  private void calculateFPS() {
    long now = System.currentTimeMillis();
    long elapsedTime = now - lastTime;
    lastTime = now;

    // Increment the frame counter for this loop iteration
    frameCount++;

    // Add the elapsed time to our FPS timer
    fpsTimer += elapsedTime;

    // Check if one second has passed (1000 milliseconds)
    if (fpsTimer >= 1000) {
      // One second has passed. The current frameCount is the FPS.
      // System.out.println("FPS: " + frameCount);

      // Reset the counter and timer for the next second's measurement
      lastFrameCount = frameCount;
      frameCount = 0;
      fpsTimer = 0;
    }
  }

  private void updateMissiles() {

    List<Missile> missiles = spaceShip.getMissiles();

    for (int i = 0; i < missiles.size(); i++) {
      Missile missile = missiles.get(i);

      if (missile.isVisible()) {
        missile.move();
      } else {
        missiles.remove(i);
      }
    }
  }

  private void updateSpaceShip() {
    spaceShip.move();
  }

  private class TAdapter extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent e) {
      spaceShip.keyReleased(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
      spaceShip.keyPressed(e);
    }
  }
}
