import java.util.ArrayList;

public class PhysicSystem extends BaseSystem
{
    private Vector gravity = new Vector(0f, 0f);
    private Box boundary = null;
    
    public void setGravity(Vector v)
    {
        gravity = v;
    }
    
    public void setBoundary(Box b)
    {
        boundary = b;
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
            
            if(boundary != null)
            {
                float diameter = 5;
                float friction = 0.8f;
                
                if(position.y >= boundary.max.y - diameter)
                {
                    position.y = boundary.max.y - diameter;
                    speed.y *= -friction;
                    speed.x *= 0.995;
                }
                
                if(position.y < boundary.min.y)
                {
                    position.y = boundary.min.y;
                    speed.y *= -friction;
                    speed.x *= 0.995;
                }
                
                if(position.x <= boundary.min.x)
                {
                    position.x = boundary.min.x;
                    speed.x *= -friction;
                    speed.y *= 0.995;
                }
                
                if(position.x >= boundary.max.x - diameter)
                {
                    position.x = boundary.max.x - diameter;
                    speed.x *= -friction;
                    speed.y *= 0.995;
                }
            }
            
            entity.setComponent(Component.Position, position);
            entity.setComponent(Component.Speed, speed);
        }
    }
}
