import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {

  private Image lotusTemple;

  public Board() {

    initBoard();
  }

  private void initBoard() {

    loadImage();

    int w = lotusTemple.getWidth(this);
    int h = lotusTemple.getHeight(this);
    setPreferredSize(new Dimension(w, h));
  }

  private void loadImage() {

    ImageIcon ii = new ImageIcon("lotus-temple.jpeg");
    lotusTemple = ii.getImage();
  }

  @Override
  public void paintComponent(Graphics g) {

    g.drawImage(lotusTemple, 0, 0, null);
  }
}
