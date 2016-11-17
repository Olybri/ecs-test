public class Component
{
    public final Class valueClass;
    private Component(Class c)
    {
        valueClass = c;
    }
    
    public final static Component Position = new Component(Vector.class);
    public final static Component Speed = new Component(Vector.class);
}
