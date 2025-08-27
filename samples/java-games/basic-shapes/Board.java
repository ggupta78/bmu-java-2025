
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Board extends JPanel {

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    drawShapes(g);
  }

  private void drawShapes(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;

    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    rh.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);

    g2d.setRenderingHints(rh);

    // // // draw Line2D.Double
    // g2d.setColor(Color.BLUE);
    // g2d.draw(new Line2D.Double(0, 0, 330, 316));

    // // // draw Rectangle2D
    // g2d.setColor(Color.BLUE);
    // g2d.draw(new Rectangle2D.Double(330, 316,
    // 100,
    // 50));

    // // // draw Circle
    // Ellipse2D circle = new Ellipse2D.Double(330, 316, 200, 200);
    // g2d.setStroke(new BasicStroke(2));
    // g2d.setColor(Color.GREEN);
    // g2d.draw(circle);

    // draw Ellipse and rotate
    Dimension size = getSize();
    double w = size.getWidth();
    double h = size.getHeight();

    Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
    g2d.setStroke(new BasicStroke(1));
    g2d.setColor(Color.red);

    for (double deg = 0; deg < 10; deg += 5) {
      AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
      at.rotate(Math.toRadians(deg));
      g2d.draw(at.createTransformedShape(e));
    }
  }
}
