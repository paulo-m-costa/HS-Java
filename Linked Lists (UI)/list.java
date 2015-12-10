import java.util.*;

public class list implements Iterable{
   public node head;
   public Iterator iterator(){
      return new listiter();
   }
   public class listiter implements Iterator{
      node n;
      public listiter(){
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
   public void delete(String removed){
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
   public boolean check(String check){
      node current = head;
      while(current.next != null && current.d.compareTo(check) < 0){
         current = current.next;
      }
      if(current.d.compareTo(check) == 0) return true;
      else return false;
   }
}