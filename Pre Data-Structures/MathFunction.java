public class MathFunction
{
    public static int summation(int a, int b)
    {
        if(a==b)
        {
            return a;
        }
        else{
            return a+summation(a+1,b);
        }
    }
}