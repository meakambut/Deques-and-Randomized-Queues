/******************************************************************************
 *  Name:    Olga Soloveva
 *  NetID:   olgrit
 *  Precept: P02/2
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 *  Description:  Randomized Queue
 ******************************************************************************/

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
   private Node first;
   private int size = 0;
   private class Node
   {
     Item item;
     Node next; 
   }
   public RandomizedQueue()     
   {
     first = null;
   }      
   public boolean isEmpty()  
   {
     return first == null;
   }            
   public int size()  
   {
     return size;
   }        
             
   public void enqueue(Item item)
   {
     if (item == null)
       throw new java.lang.IllegalArgumentException("There is no element to add");
     
     if (first == null)
     {
       first = new Node();
       first.item = item;
       first.next = null;
       size++;
     }
     else
     {
       Node p = first;
       while (p.next != null)
         p = p.next;
       p.next = new Node();
       p.next.item = item;
       p.next.next = null;
       size++;
     }
   }          

   public Item dequeue() 
   {
     if (first == null)
       throw new java.util.NoSuchElementException("There is no elements in the queue");
     if (first.next == null)
     {
        Item item = first.item;
        first = null;
        size--;
        return item;
     }
     int random;
     random = StdRandom.uniform(size());
     if (random == 0)
     {
       Item item = first.item;
       first = first.next;
       size--;
       return item;
     }
     Node p = first;
     for (int i = 0; i < random - 1; i++)
       p = p.next;
     Item item = p.next.item;
     p.next = p.next.next;
     size--;
     return item;
   }                  

   public Item sample()  
   {
     if (first == null)
       throw new java.util.NoSuchElementException();
     int random;
     random = StdRandom.uniform(size());
     Node p = first;
     for (int i = 0; i < random; i++)
       p = p.next;
     return p.item;
   }                   

   private class ListIterator implements Iterator<Item>
   {
     private boolean[] flag = new boolean[size()];
     private ListIterator()
     {
       for (int i = 0; i < size(); i++)
         flag[i] = false;
     }
     public boolean hasNext() 
     {
       boolean done = true;
       for (boolean f : flag)
         if (!f) 
         { 
           done = false; 
           return !done; 
         }
       return !done;
     }  
     public void remove() 
     { throw new java.lang.UnsupportedOperationException("No remove method"); }
     public Item next()
     {
       if (!hasNext())
         throw new java.util.NoSuchElementException("No more elements to display");
       Node p = first;
       int random, size = size();
       random = StdRandom.uniform(size); 
       while (flag[random])
         random = StdRandom.uniform(size);
       for (int i = 0; i < random; i++)
         p = p.next;
       flag[random] = true;
       return p.item;   
     }
   }

   /* private void print()
   {
     if (first == null)
       System.out.println("Empty queue");
     Node p = first;
     while (p != null)
     {
       System.out.println(p.item);
       p = p.next;
     }
   }

    private void randomprint()
   {
     if (first == null)
       System.out.println("Empty queue");
     Iterator<Item> p = iterator(); 
     while (p.hasNext())
       System.out.println(p.next());
   } */

   public Iterator<Item> iterator() 
   {
     return new ListIterator();
   }      

   public static void main(String[] args) { return; }
}