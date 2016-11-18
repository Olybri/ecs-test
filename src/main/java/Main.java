import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        World world = new World();
        world.setFrameRate(60);
        
        int n = 100;
        for(int i=0; i<n; ++i)
        {
            Entity ball = new Entity();
            ball.setComponent(Component.Position, new Vector(randFloat(50, 750), randFloat(50, 300)));
            ball.setComponent(Component.Speed, new Vector(randFloat(-80, 80), randFloat(-100, 100)));
            ball.setComponent(Component.Drawable, new OvalShape(new Vector(10, 10), Color.gray));
            world.addEntity(ball);
        }
    
        PhysicSystem physicSystem = new PhysicSystem();
        physicSystem.setGravity(new Vector(0, 98));
        world.addSystem(physicSystem);
        
        RenderSystem renderSystem = new RenderSystem("ECS test", 800, 450);
        world.addSystem(renderSystem);
        
        try
        {
            world.run();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static float randFloat(float min, float max)
    {
        return (float)Math.random() * (max-min) + min;
    }
}
