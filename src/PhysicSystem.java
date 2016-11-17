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
            
            if(position.y >= 445)
            {
                position.y = 445;
                speed.y *= -0.8;
            }
            
            entity.setComponent(Component.Position, position);
            entity.setComponent(Component.Speed, speed);
        }
    }
}
