public class node{
   public String d;
   public node next;
   node(String md){
      d = md;
      next = null;
   }
   public node(String md, node mnext){
      d = md;
      next = mnext;
   }
}