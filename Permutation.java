/******************************************************************************
 *  Name:    Olga Soloveva
 *  NetID:   olgrit
 *  Precept: P02/3
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 *  Description:  Permutation
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

public class Permutation 
{
   public static void main(String[] args)
   {
     int k = Integer.parseInt(args[0]);
     RandomizedQueue<String> q = new RandomizedQueue<String>();
     while (!StdIn.isEmpty())
       q.enqueue(StdIn.readString());
     Iterator<String> p = q.iterator(); 
     for (int i = 0; i < k; i++)
       System.out.println(p.next());
   }
}
