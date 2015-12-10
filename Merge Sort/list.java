//Paulo Costa
//3/6/2012
//This is the List class for my Merge Sort program. It contains all of the methods used to perform an appropriate Merge Sort on a list of inputted objects.

import java.io.*;
import java.util.*;

public class list implements Iterable{
   
node head;

public list(){ //constructor.
   head = null;
}

public Iterator iterator(){
   return new listiter();
}

public class listiter implements Iterator{ //implements Iterator to keep track of position in a list.
   node n;
   public listiter(){
      n = head;
   }
   public boolean hasNext(){ //checks if a next node is present.
      return(n.next != null);
   }
   public Object next(){ //returns Object referenced by the n node and moves on to the next node.
      if(n == null){
         return null;
      }
      Object t = n.d;
      n = n.next;
      return t;
   }
   public void remove(){ //unneeded method, but still must be defined.
   }
}

public void insert(Object d){ //inserts an Object into the linked list.
   head = new node(d, head);
}

public static node split(node head1){ //splits list into two equal halves.
   node point1 = head1;
   node point2 = head1.next;
   while (point2 != null && point2.next != null){
      point1 = point1.next;
      point2 = point2.next.next;
   }
   point2 = point1.next;
   point1.next = null;
   return point2;
}

public static node merge(node head1, node head2){ //merges sublists together prioritizing Objects of lesser value.
   node merged;
   if(((Comparable)(head1.d)).compareTo((Comparable)(head2.d)) < 0){
      merged = head1;
      head1 = head1.next;
   }
   else{
      merged = head2;
      head2 = head2.next;	
   }
   node point3 = merged;
   while(head1 != null && head2 != null){
      if(((Comparable)(head1.d)).compareTo((Comparable)(head2.d)) < 0){
         point3.next = head1;
         head1 = head1.next;
      }
      else{
         point3.next = head2;
         head2 = head2.next;
      }
      point3 = point3.next;
   }
   if(head1 != null){
      point3.next = head1;
   }
   else{
      point3.next = head2;
   }
   return merged;	
}

public static node mergeSort(node head1){ //Sorts objects by recursively partitioning a listm, sorting each sublist, and then merging the sublists accordingly.
   if(head1 == null || head1.next == null){
      return head1;
   }
   node head2 = split(head1);
   head1 = mergeSort(head1);
   head2 = mergeSort(head2);
   return merge(head1, head2);			
}

public void sort(){ //access method to perform Merge Sort.
   head = mergeSort(head);
}

}