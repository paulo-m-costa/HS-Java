import java.util.*;

public class dlist implements Iterable{
   public node head;
   public Iterator iterator(){
      return new dlistiter();
   }
   public class dlistiter implements Iterator{
      node n;
      public dlistiter(){
         n = head;
      }
      public Object next(){
         Object t = null;
         if(n != null){
            t = n.d;
            n = n.next;
         }
         return t;
      }
      public boolean hasNext(){
         if(n != null) return true;
         else return false;
      }
      public void remove(){
      }
   }
   public void insert(String inserted){
      node current = head;
      if(current == null){
         head = new node(inserted, null, null);
      }
      else{
         while(current.next != null && current.d.compareTo(inserted) < 0){
            current = current.next;
         }
         if(current.d.compareTo(inserted) < 0){
            current.next = new node(inserted, current, null);
         }
         else{
            node created = new node(inserted, current.prev, current);
            current.prev.next = created;
            current.prev = created;      
            if(created.prev == null){
               head = created;
            }
         }
      }
   }
   public void delete(String removed){
      node current = head;
      current.prev = null;
      while(current != null && current.d.compareTo(removed) != 0){
         current.prev = current;
         current = current.next;
      }
      if(current.d.compareTo(removed) == 0){
         if(current.prev == null){
            head = current.next;
         }
         else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
         }
      }
   }
   public boolean check(String check){
      node current = head;
      while(current.next != null && current.d.compareTo(check) < 0){
         current = current.next;
      }
      if(current.d.compareTo(check) == 0) return true;
      else return false;
   }
}