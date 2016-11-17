public class Main
{
    public static void main(String[] args)
    {
        World world = new World();
        world.setFrameRate(60);
        
        Entity ballA = new Entity();
        ballA.setComponent(Component.Position, new Vector(100, 200));
        ballA.setComponent(Component.Speed, new Vector(10, -100));
        world.addEntity(ballA);
    
        Entity ballB = new Entity();
        ballB.setComponent(Component.Position, new Vector(700, 100));
        ballB.setComponent(Component.Speed, new Vector(-10, 100));
        world.addEntity(ballB);
    
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
}
