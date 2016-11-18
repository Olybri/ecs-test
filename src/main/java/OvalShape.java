import java.awt.*;

public class OvalShape extends Shape
{
    private Vector size;
    
    public OvalShape(Vector size)
    {
        this.size = size;
    }
    
    public OvalShape(Vector size, Color color)
    {
        this.size = size;
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D graphics, Vector position)
    {
        graphics.setColor(color);
        
        if(fill)
            graphics.fillOval((int)position.x, (int)position.y, (int)size.x, (int)size.y);
        else
            graphics.drawOval((int)position.x, (int)position.y, (int)size.x, (int)size.y);
    }
}
