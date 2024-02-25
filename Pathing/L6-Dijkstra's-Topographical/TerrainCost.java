public class TerrainCost {
    private int cost;
    private char type;

    public TerrainCost(char type, int cost)
    {
        this.type = type;
        this.cost = cost;
    }

    public int getCost()
    {
        return cost;
    }

    public char getType()
    {
        return type;
    }

    public String toString()
    {
        return type+""+cost;
    }
}
