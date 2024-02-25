//Add Code Here
import java.awt.Point;
import java.util.*;
public class Path{


public static int heuristic(Point st, Point end)
{
    int dX = Math.abs(st.x-end.x);
    int dY = Math.abs(st.y-end.y);
    return dX + dY;
}
public static Node small(ArrayList<Node> n){
    Node min = n.get(0);
    for(Node cN: n){
        if(cN.getF()<min.getF() || (cN.getF()==min.getF() && cN.getH() < min.getH()))
        {
            min = cN;
        }
    }
    return min;
}
public static ArrayList<Point> reconstruct(Node n)
{
    ArrayList<Point> p = new ArrayList<Point>();
    while(n!=null)
    {
        p.add(n.getLocation());
        n=n.getParent();
    }
    return p;
}
public static void checkAdd(ArrayList<Node> o, ArrayList<Node> cl, Node curr, int dX, int dY, Point st, Point end, char[][] maze)
{
   int x = curr.getLocation().x + dX;
   int y = curr.getLocation().y + dY;

   if(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]!='W')
   {
       Node finalz = new Node(new Point(x,y), curr, heuristic(new Point(x,y), st), heuristic(new Point(x,y), end));


       if(!cl.contains(finalz))
                {
                    if(o.contains(finalz))
                    {
                        for(Node oN: o){
                    
                            if(oN.getLocation().equals(finalz.getLocation()) && oN.getG()>finalz.getG())
                            {
                                oN.setG(finalz.getG());
                                oN.fixF();
                            }
                        }
                    }
                    else{
                        o.add(new Node(new Point(x,y), curr, curr.getG()+1, heuristic(new Point(x,y), end)));
                    }
                }
            }         
        }



public static Solution aStar(char[][] maze)
{
    ArrayList<Node> o = new ArrayList<Node>();
    ArrayList<Node> cl = new ArrayList<Node>();
    Point st = new Point();
    Point end = new Point();
    for(int i=0;i<maze.length;i++)
    {
        for(int j=0;j<maze[0].length;j++)
        {
            if(maze[i][j]=='S')
            {
                st = new Point(i,j);
            }
            if(maze[i][j]=='E')
            {
                end = new Point(i,j);
            }
          }
    }
    o.add(new Node(st,null,0,heuristic(st,end)));
    while(!o.isEmpty())
    {
        Node curr = small(o);
        o.remove(curr);

        if(curr.getLocation().equals(end)){
            ArrayList<Point> p1 = reconstruct(curr);
            Collections.reverse(p1);
            ArrayList<Point> p2 = new ArrayList<Point>();
            for(Point p3: p1)
            {
                p2.add(new Point(p3.getLocation().y,p3.getLocation().x));
            }
            return new Solution(p2,p2.size()-1);
        }

        cl.add(curr);
        
        checkAdd(o,cl, curr, -1,0, st, end, maze);
        checkAdd(o,cl, curr, 1,0, st, end, maze);
        checkAdd(o,cl, curr, 0,-1, st, end, maze);
        checkAdd(o,cl, curr, 0,1, st, end, maze);

        
        /*int[][] neigh = {{0,-1},{0,1},{1,0},{-1,0}};
        for(int[] n: neigh)
        {
            int x = curr.getLocation().x + n[0];
            int y = curr.getLocation().y + n[1];
            if(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y] != 'W')
            {
                Node nN = new Node(new Point(x,y),curr,curr.getG()+1,heuristic(new Point(x,y),end));
                if(!cl.contains(nN))
                {
                    if(o.contains(nN))
                    {
                        for(Node oN: o){
                    
                            if(oN.getLocation().equals(nN.getLocation()) && oN.getG()>nN.getG())
                            {
                                oN.setG(nN.getG());
                                oN.setH(nN.getH());
                            }
                        }
                    }
                    else{
                        o.add(nN);
                    }
                }
            }
        }
        */
        /*
        if(curr.getLocation().x-1 >= 0 && maze[curr.getLocation().x-1][curr.getLocation().y]!='W'){
            int x = curr.getLocation().x; 
            int y = curr.getLocation().y;
            Node finalz = new Node(new Point(x-1,y),curr,curr.getG()+1,heuristic(new Point(x-1,y),end));

            if(!cl.contains(finalz))
                {
                    if(o.contains(finalz))
                    {
                        for(Node oN: o){
                    
                            if(oN.getLocation().equals(finalz.getLocation()) && oN.getG()>finalz.getG())
                            {
                                oN.setG(finalz.getG());
                                oN.setH(finalz.getH());
                            }
                        }
                    }
                    else{
                        o.add(finalz);
                    }
                }

        }

        if(curr.getLocation().x+1 < maze.length && maze[curr.getLocation().x+1][curr.getLocation().y]!='W'){
            int x = curr.getLocation().x; 
            int y = curr.getLocation().y; 
            Node finalz = new Node(new Point(x+1,y),curr,curr.getG()+1,heuristic(new Point(x+1,y),end));

            if(!cl.contains(finalz))
                {
                    if(o.contains(finalz))
                    {
                        for(Node oN: o){
                    
                            if(oN.getLocation().equals(finalz.getLocation()) && oN.getG()>finalz.getG())
                            {
                                oN.setG(finalz.getG());
                                oN.setH(finalz.getH());
                            }
                        }
                    }
                    else{
                        o.add(finalz);
                    }
                }

        }

        if(curr.getLocation().y+1 < maze[0].length && maze[curr.getLocation().x][curr.getLocation().y+1]!='W'){
            int x = curr.getLocation().x; 
            int y = curr.getLocation().y;
            Node finalz = new Node(new Point(x,y+1),curr,curr.getG()+1,heuristic(new Point(x,y+1),end));

            if(!cl.contains(finalz))
                {
                    if(o.contains(finalz))
                    {
                        for(Node oN: o){
                    
                            if(oN.getLocation().equals(finalz.getLocation()) && oN.getG()>finalz.getG())
                            {
                                oN.setG(finalz.getG());
                                oN.setH(finalz.getH());
                            }
                        }
                    }
                    else{
                        o.add(finalz);
                    }
                }

        }

        if(curr.getLocation().y-1 >= 0 && maze[curr.getLocation().x][curr.getLocation().y-1]!='W'){
            int x = curr.getLocation().x;
            int y = curr.getLocation().y;
            Node finalz = new Node(new Point(x,y-1),curr,curr.getG()+1,heuristic(new Point(x,y-1),end));

            if(!cl.contains(finalz))
                {
                    if(o.contains(finalz))
                    {
                        for(Node oN: o){
                    
                            if(oN.getLocation().equals(finalz.getLocation()) && oN.getG()>finalz.getG())
                            {
                                oN.setG(finalz.getG());
                                oN.setH(finalz.getH());
                            }
                        }
                    }
                    else{
                        o.add(finalz);
                    }
                }

        }
        */

    }
    return null;
}




public static void main(String[] args)
{

}

}
