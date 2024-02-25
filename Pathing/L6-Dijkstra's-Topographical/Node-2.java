import java.awt.*;

public class Node implements Comparable
{
    private Point location;
    private int distance;

    public Node(Point location, int distance)
    {
        this.location = location;
        this.distance = distance;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    public int getDistance()
    {
        return distance;
    }

    public Point getLocation()
    {
        return location;
    }

    public String toString()
    {
        return location + "-"+distance;
    }

    public int compareTo(Object o)
    {
        return distance - ((Node)o).distance;
    }
}