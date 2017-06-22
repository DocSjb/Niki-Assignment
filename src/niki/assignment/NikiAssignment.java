package niki.assignment;
import java.util.*;
import java.io.*;
/**
 *
 * @author Soumyajyoti
 */
//Fibonacci Series using Optimized Method

	



class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
    }
}

/*The question can be solved by finding the (n+2)th Fibonacci sequence number, with n being the input string. All constraints involved in a subtask can be functionally solved here, and this is the Olog(n) complexity method to find the nth fibonacci number. Other method involved can be a more time consuming brute force method and a big integer method, both of which can be easily provided if necessary.*/


class NikiAssignment
{
    static long con = 1000000007;
    /* function that returns (n+2)th Fibonacci number */
    static long fib(long n)
    {
        long F[][] = new long[][]{{1,1},{1,0}};
        if (n == 0)
            return 0;
        power(F, n-1);
    
        return F[0][0]%con;
    }
    
    static void multiply(long F[][], long M[][])
    {
        long x = (((F[0][0]*M[0][0])%con) + ((F[0][1]*M[1][0])%con))%con;
        long y = (((F[0][0]*M[0][1])%con) + ((F[0][1]*M[1][1])%con))%con;
        long z = (((F[1][0]*M[0][0])%con) + ((F[1][1]*M[1][0])%con))%con;
        long w = (((F[1][0]*M[0][1])%con) + ((F[1][1]*M[1][1])%con))%con;
    
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
    
    /* Optimized version of power() in method 4 */
    static void power(long F[][], long n)
    {
        if( n == 0 || n == 1)
            return;
        long M[][] = new long[][]{{1,1},{1,0}};
    
        power(F, n/2);
        multiply(F, F);
    
        if (n%2 != 0)
            multiply(F, M);
    }
    
    /* Driver program to test above function */
    public static void main (String args[])throws IOException
    {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));

        long t = Long.parseLong(br.readLine());
        ArrayList<Long> ar = new ArrayList<Long>();
        while((t--)>0)
        {
            long n = Long.parseLong(br.readLine());
            ar.add(fib(n+2));
            
            
        }
        for(int i=0;i<ar.size();i++)
        {
            System.out.println(ar.get(i));
        }
        
    }
}


 