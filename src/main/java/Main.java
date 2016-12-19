import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        System.setProperty("sun.java2d.opengl", "true");
        
        World world = new World();
        world.setFrameRate(60);
        
        int width = 1500;
        int height = 1000;
    
        int particleCount = 1000;
        float speedMax = 100;
        
        for(int i=0; i<particleCount; ++i)
        {
            Entity ball = new Entity();
            ball.setComponent(Component.Position, new Vector(randFloat(0, width), randFloat(0, height)));
            ball.setComponent(Component.Speed, new Vector(randFloat(-speedMax, speedMax), randFloat(-speedMax, speedMax)));
            ball.setComponent(Component.Drawable, new OvalShape(new Vector(5, 5), Color.GRAY));
            world.addEntity(ball);
        }
    
        PhysicSystem physicSystem = new PhysicSystem();
        physicSystem.setGravity(new Vector(0, 98));
        physicSystem.setBoundary(new Box(new Vector(0,0), new Vector(width, height)));
        world.addSystem(physicSystem);
        
        RenderSystem renderSystem = new RenderSystem("ECS test", width, height);
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
