import java.util.*;
import java.awt.Point;

public class Solution
{
    private ArrayList<Point> path;
    private int steps;

    public Solution(ArrayList<Point> path, int steps)
    {
        this.path = path;
        this.steps = steps;
    }

    public ArrayList<Point> getPath()
    {
        return path;
    }

    public int getSteps()
    {
        return steps;
    }

    public String toString()
    {
        return path.toString() + " "+ steps;
    }
}