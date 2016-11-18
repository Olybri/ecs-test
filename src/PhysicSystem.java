import java.util.ArrayList;

public class PhysicSystem extends BaseSystem
{
    private Vector gravity = new Vector(0f, 0f);
    
    public void setGravity(Vector v)
    {
        gravity = v;
    }
    
    @Override
    public void update(ArrayList<Entity> entities, float elapsedTime)
    {
        for(Entity entity : entities)
        {
            if(!entity.hasComponents(Component.Position, Component.Speed))
                break;
            
            Vector position = entity.getComponent(Component.Position, Vector.class);
            Vector speed = entity.getComponent(Component.Speed, Vector.class);
            
            speed.add(Vector.scale(gravity, elapsedTime));
            position.add(Vector.scale(speed, elapsedTime));
            
            if(position.y >= 440)
            {
                position.y = 440;
                speed.y *= -0.8;
                speed.x *= 0.995;
            }
            if(position.x <= 0)
            {
                position.x = 0;
                speed.x *= -1;
            }
    
            if(position.x >= 790)
            {
                position.x = 790;
                speed.x *= -1;
            }
            
            entity.setComponent(Component.Position, position);
            entity.setComponent(Component.Speed, speed);
        }
    }
}
