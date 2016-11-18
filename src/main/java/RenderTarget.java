import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderTarget extends JPanel
{
    private BufferedImage bufferImage;
    private Graphics2D graphics;
    
    public RenderTarget(int width, int height)
    {
        bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = (Graphics2D)bufferImage.getGraphics();
    
        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHints(rh);
    
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);
    }
    
    public void drawOval(Vector v, int w, int h, Color color)
    {
        graphics.setColor(color);
        graphics.fillOval((int)v.x, (int)v.y, w, h);
    }
    
    public void clear(Color color)
    {
        graphics.setColor(color);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }
    
    private void render(Graphics g)
    {
        g.drawImage(bufferImage, 0, 0, null);
    }
    
    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        render(graphics);
    }
}