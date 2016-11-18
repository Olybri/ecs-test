import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RenderSystem extends BaseSystem
{
    private RenderTarget target;
    
    public RenderSystem(String title, int width, int height)
    {
        target = new RenderTarget(width, height);
    
        JFrame window = new JFrame();
        window.add(target);
        window.setSize(width, height);
        window.setTitle(title);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        window.setVisible(true);
    }
    
    @Override
    public void update(ArrayList<Entity> entities, float elapsedTime)
    {
        target.clear(new Color(255,255,255,20));
        
        for(Entity entity : entities)
        {
            if(!entity.hasComponents(Component.Position, Component.Drawable))
                break;
    
            target.draw(entity.getComponent(Component.Drawable, Drawable.class),
                    entity.getComponent(Component.Position, Vector.class));
        }
        
        target.repaint();
    }
}
