/******************************************************************************
 *  Name:    Olga Soloveva
 *  NetID:   olgrit
 *  Precept: P02/1
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 *  Description:  Dequeue
 ******************************************************************************/

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> 
{
   private Node first, last;
   private int size = 0;

   private class Node
   {
     Item item;
     Node next, prev; 
   }

   public Deque()
   {
     first = null;
     last = null;
   }           
               
   public boolean isEmpty()
   {
     return first == null;
   }            
    
   public int size()      
   {
     return size;
   }                  

   public void addFirst(Item item)  
   {
     if (item == null)
       throw new java.lang.IllegalArgumentException("You should add smth to the list");
     
     Node p = first;
     first = new Node();
     first.item = item;
     first.next = p;
     first.prev = null;
     if (p == null)
       last = first;
     else
       p.prev = first;
     size++;
   }      

   public void addLast(Item item) 
   {
     if (item == null)
       throw new java.lang.IllegalArgumentException("You should add smth to the list");
     if (first == null)
     {
       first = new Node();
       first.item = item;
       first.next = null;
       first.prev = null;
       last = first;
       size++;
     }
     else
     {
       Node p = new Node();
       p.item = item;
       last.next = p;
       p.prev = last;
       last = p;
       size++;
     }
   }        

   public Item removeFirst()
   {
     if (first == null)
        throw new java.util.NoSuchElementException("The queue is empty");
     if (first.next == null)
     {
       Item item = first.item;
       first = null;
       last = null;
       size--;
       return item;
     }
     Item item = first.item;
     first = first.next;
     first.prev = null;
     if (isEmpty())
       last = null;
     size--;
     return item;
   }            

   public Item removeLast()
   {
     if (first == null)
        throw new java.util.NoSuchElementException("The queue is empty");

     if (first.next == null)
     {
        Item lastItem = first.item;
        first = null;
        last = null;
        size--;
        return lastItem;
     }

     Item lastItem = last.item;
     last = last.prev;
     last.next = null;
     size--;
     return lastItem;
   }            
   
   /* private void print()
   {
     Iterator<Item> p = iterator(); 
     while (p.hasNext())
       System.out.println(p.next());
   } */

   private class ListIterator implements Iterator<Item>
   {
     private Node current = first;

     public boolean hasNext() { return current != null; }
     public void remove() 
     { throw new java.lang.UnsupportedOperationException("No remove method"); }
     public Item next()
     {
       if (current == null)
         throw new java.util.NoSuchElementException("There is nothing to return left");
       Item item = current.item;
       current = current.next;
       return item;
     }
   }

   public Iterator<Item> iterator()
   {
     return new ListIterator();
   }    

   public static void main(String[] args) { return; }
}

