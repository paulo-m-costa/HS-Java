public class node{
   public String d;
   public node prev;
   public node next;
   node(String md){
      d = md;
      prev = null;
      next = null;
   }
   public node(String md, node p, node n){
      d = md;
      p = prev;
      n = next;
   }
}