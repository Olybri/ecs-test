import java.awt.*;

public class LineShape extends Shape
{
    private Vector start;
    private Vector end;
    
    public LineShape(Vector start, Vector end)
    {
        this.start = start;
        this.end = end;
    }
    
    public LineShape(Vector start, Vector end, Color color)
    {
        this(start, end);
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D graphics, Vector position)
    {
        graphics.setColor(color);
        
        graphics.drawLine((int)(start.x + position.x), (int)(start.y + position.y),
                (int)(end.x + position.x), (int)(end.y + position.y));
    }
}
