import java.util.Arrays;
import java.util.Hashtable;

public class Entity
{
    private Hashtable<Component, Object> components = new Hashtable<>();
    
    public void setComponent(Component component, Object value)
    {
        assert component.valueClass.isInstance(value) : "Invalid component value type ("
                + value.getClass() + ") - expected " + component.valueClass;
        
        components.put(component, value);
    }
    
    public <T> T getComponent(Component component, Class<T> type)
    {
        return type.cast(components.get(component));
    }
    
    public Object getComponent(Component component)
    {
        return components.get(component);
    }
    
    public boolean hasComponent(Component component)
    {
        return components.keySet().contains(component);
    }
    
    public boolean hasComponents(Component... component)
    {
        return components.keySet().containsAll(Arrays.asList(component));
    }
}
