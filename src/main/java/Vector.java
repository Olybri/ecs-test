public class Vector
{
    public float x;
    public float y;
    
    public Vector()
    {
        x = 0;
        y = 0;
    }
    
    public Vector(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void add(Vector v)
    {
        x += v.x;
        y += v.y;
    }
    
    public void scale(float r)
    {
        x *= r;
        y *= r;
    }
    
    public static Vector scale(Vector v, float r)
    {
        return new Vector(v.x * r, v.y * r);
    }
}
