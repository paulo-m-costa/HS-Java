//Paulo Costa
//11/18/2011
//This is the List class for my Linked Lists program. It contains all of the methods used in the user interface.

import java.util.*;

public class list implements Iterable{  //The primary class, which implements the standard interface Iterable found under java.util.*. Without the implementation of Iterable, Iterator cannot be used.
   public node head;  //The head node is an invariant; it always references 'null' and the first node in the list.
   public Iterator iterator(){
      return new listiter();
   }
   public class listiter implements Iterator{  //The sub class, which implements the standard interface Iterator found under java.util.*. Iterator requires the definition of three methods - Objext next(), boolean hasNext(), and void remove().
      node n;
      public listiter(){
         n = head;
      }
      public Object next(){  //This method returns the data referenced by the current node and then moves on to the next node.
         Object t = null;
         if(n != null){
            t = n.d;
            n = n.next;
         }
         return t;
      }
      public boolean hasNext(){  //This method checks if there is a next node available. If there is, it returns true; if not, false.
         if(n != null) return true;
         else return false;
      }
      public void remove(){  //Because my user interface does not use this method, I have defined this method as empty.
      }
   }
   public void insert(String inserted){  //This method creates a new node referencing the data inputted and places it between already-existing nodes such that the list is in alphabetical order.
      node current = head;
      node previous = null;
      while(current != null && current.d.compareTo(inserted) < 0){
         previous = current;
         current = current.next;
      }
      node add = new node(inserted, current);
      if(previous == null){
         head = add;
         }
      else{
         previous.next = add;
      }
   }
   public void delete(String removed){  //This method 'removes' the node that references the data inputted by changing node references to essentially skip over it.
      node current = head;
      node previous = null;
      while(current != null && current.d.compareTo(removed) < 0){
         previous = current;
         current = current.next;
      }
      if(current.d.compareTo(removed) == 0){
         if(previous == null){ 
            head = current.next;
         }
         else previous.next = current.next;
      }
   }
   public boolean check(String check){  //This method checks if there is a node that references the data inputted. If there is, it returns true; if not, false.
      node current = head;
      while(current.next != null && current.d.compareTo(check) < 0){
         current = current.next;
      }
      if(current.d.compareTo(check) == 0) return true;
      else return false;
   }
}