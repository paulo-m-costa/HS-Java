public class node{
   public Comparable d;
   public node next;
   node(Comparable md){
      d = md;
      next = null;
   }
   public node(Comparable md, node mnext){
      d = md;
      next = mnext;
   }
}