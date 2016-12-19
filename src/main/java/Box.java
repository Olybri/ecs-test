public class Box
{
    public Vector min;
    public Vector max;
    
    public Box()
    {
        min = new Vector(0, 0);
        max = new Vector(0, 0);
    }
    
    public Box(Vector min, Vector max)
    {
        this.min = min;
        this.max = max;
    }
}

