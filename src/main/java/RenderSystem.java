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
        window.setUndecorated(true);
        window.add(target);
        window.setTitle(title);
        window.setSize(width, height);
        window.setAlwaysOnTop(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        window.setVisible(true);
    }
    
    @Override
    public void update(ArrayList<Entity> entities, float elapsedTime)
    {
        target.clear(new Color(20, 20, 20, 200));
        
        for(Entity entity : entities)
        {
            if(!entity.hasComponents(Component.Drawable))
                break;
            
            if(entity.hasComponents(Component.Position))
                target.draw(entity.getComponent(Component.Drawable, Drawable.class),
                    entity.getComponent(Component.Position, Vector.class));
            
            else
                target.draw(entity.getComponent(Component.Drawable, Drawable.class),
                    new Vector(0, 0));
        }
        
        target.repaint();
    }
}
