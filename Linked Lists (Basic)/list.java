public class list{
   public static node head;
   public void construct(Comparable md){
      head = null;
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
   public void print(){
   node current = head;
      while(current != null){
         System.out.println(current.d);
         current = current.next;
      }
   }
}