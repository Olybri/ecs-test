import java.util.ArrayList;

public class World
{
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<BaseSystem> systems = new ArrayList<>();
    
    private int frameRate = 0;
    
    public void addEntity(Entity entity)
    {
        entities.add(entity);
    }
    
    public void addSystem(BaseSystem system)
    {
        systems.add(system);
    }
    
    public void setFrameRate(int rate)
    {
        frameRate = rate;
    }
    
    public void run() throws Exception
    {
        long time = System.currentTimeMillis();
        
        while(true)
        {
            float elapsedTime = (System.currentTimeMillis() - time) / 1000.f;
            time = System.currentTimeMillis();
            
            for(BaseSystem system : systems)
                system.update(entities, elapsedTime);
            
            if(frameRate > 0)
                Thread.sleep((long)Math.max(0, (1000.f / frameRate) - (System.currentTimeMillis() - time)));
        }
    }
}
