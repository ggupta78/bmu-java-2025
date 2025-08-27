
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

public class Rectangles extends JPanel {

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

    int x = 15, y = 15, w = 630, h = 600;

    g2d.setColor(Color.BLUE);

    int gap = 0;

    while (gap <= 255) {
      // draw smaller rectangles with each loop
      g2d.draw(new Rectangle2D.Double(x + gap, y + gap, w - (gap * 2), h - (gap * 2)));
      gap = gap + 15;
    }

    // draw the four connecting lines
    g2d.setColor(Color.BLUE);
    // top left to center
    g2d.draw(new Line2D.Double(x, y, gap, gap));
    // bottom right to center
    g2d.draw(new Line2D.Double(x + w, y + h, gap + w - (gap * 2) + 30, gap + h - (gap * 2) + 30));
    // bottom left to center
    g2d.draw(new Line2D.Double(x, y + h, x + gap - 15, gap + h - (gap * 2) + 30));
    // top right to center
    g2d.draw(new Line2D.Double(x + w, y, gap + w - (gap * 2) + 30, gap));
  }
}
