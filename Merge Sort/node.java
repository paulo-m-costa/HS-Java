public class node{
   public Object d;
   public node next;
   node(Object md){
      d = md;
      next = null;
   }
   public node(Object md, node mnext){
      d = md;
      next = mnext;
   }
}