import java.awt.*;

public class Node implements Comparable
{
    private Point location;
    private Node parent;
    private char type;
    private int f,h,g;
    
    public Node(Point location,Node parent, int g, int h)
    {
        this.location = location;
        this.g = g;
        this.h = h;
        this.parent = parent;
        fixF();
    }

    public void setG(int g)
    {
        this.g = g;
        fixF();
    }

     public void setH(int h)
    {
        this.h = h;
        fixF();
    }

    public int getG()
    {
        return g;
    }

    public int getH()
    {
        return h;
    }

    public int getF()
    {
        return f;
    }

    public Point getLocation()
    {
        return location;
    }

    public Node getParent()
    {
        return parent;
    }

    public char getType()
    {
        return type;
    }

    public void fixF()
    {
        f=g+h;
    }

    public String toString()
    {
        return location+"("+parent+")" + " "+f+"="+g+"+"+h;
    }

    public int compareTo(Object o)
    {
        if(f!=((Node)o).f)
            return f - ((Node)o).f;
        else {
            return h - ((Node)o).h;
        }
    }

    public boolean equals(Object o)
    {
        return location.equals(((Node)o).location);
    }
}