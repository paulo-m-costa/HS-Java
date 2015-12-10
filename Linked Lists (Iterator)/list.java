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
         if(n != null){
            return true;
         }
         else{
            return false;
         }
      }
      public void remove(){
         node r = head;
         node r2 = null;
         if(r2.next == null){
            head = r.next;
         }
         else{
            r2.next = r.next;
         }
      }
   }
   public void insert(Comparable md){
      node current = head;
      node previous = null;
         while(current != null && current.d.compareTo(md) < 0){
            previous = current;
            current = current.next;
         }
      node newt = new node(md, current);
      if(previous == null){
         head = newt;
         }
      else{
         previous.next = newt;
      }
   }
}