import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

  private Timer timer;
  private SpaceShip spaceShip;
  private final int DELAY = 10;

  public Board() {

    initBoard();
  }

  private void initBoard() {

    addKeyListener(new TAdapter());
    setBackground(Color.black);
    setFocusable(true);

    spaceShip = new SpaceShip();

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
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    update();
  }

  private void update() {

    spaceShip.move();

    // Repainting with optimisation
    repaint(spaceShip.getX() - 5, spaceShip.getY() - 5,
        spaceShip.getWidth() + 10, spaceShip.getHeight() + 10);
    // repaint(); //Without optimisation
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
