//Paulo Costa
//2/10/2012
//This is the Binary Search Tree class for my BST program. It contains all of the methods used in the user interface, which encompasses traversal and searching.

import java.util.*;

public class BST implements Iterable{  //The primary class, which implements the standard interface Iterable found under java.util.*. Without the implementation of Iterable, Iterator cannot be used.
   node root;
   public BST(){
      root = new node(" ", null, null);  //Initializes the root node.
   }
   public Iterator iterator(){
      return new treeiter();
   }
   public class treeiter implements Iterator{  //The sub class, which implements the standard interface Iterator found under java.util.*. Iterator requires the definition of three methods - Objext next(), boolean hasNext(), and void remove().
      node n;
      public treeiter(){
         n = root;
      }
      public Object next(){  //This method returns the data referenced by the current node and then moves on to the next node.
         Object t = null;
         if(n != null){
            if(n.left != null) n = n.left;
            else if(n.right != null) n = n.right;
            else t = n.d;
         }
         return t;
      }
      public boolean hasNext(){  //This method checks if there are next nodes available. If there is, it returns true; if not, false.
         if(n.checkChild() == true) return true;
         else return false;
      }
      public void remove(){  //Because my user interface does not use this method, I have defined this method as empty.
      }
   }
   public void insert(node node, Comparable md){ //This method creates a new node and places it appropriately in the tree my comparing the value of its referenced data with that of the other nodes. 
      if(md.compareTo(node.d) < 0){
         if(node.left != null) insert(node.left, md);
         else node.left = new node(md, null, null);
      }
      else if (md.compareTo(node.d)>0) {
         if (node.right != null) insert(node.right, md);
         else node.right = new node(md, null, null);
      }
   }
   public node delete(node r, Comparable n){  //This method 'removes' the node that references the data inputted by changing node references to essentially skip over it.
      if(r != null){
         if(r.d.compareTo(n) < 0) r.right = delete(r.right, n);
         else if(r.d.compareTo(n) > 0) r.left = delete(r.left, n);
         else{
            if(r.left == null && r.right == null) r = null;
            else if(r.left != null && r.right == null) r = r.left;
            else if(r.right != null && r.left == null) r = r.right;
            else{
               if(r.right.left == null){
                  r.right.left = r.left;
                  r = r.right;
               }
               else{
                  node b,a = r.right;
                  while(a.left.left != null){
		     a = a.left;
                     b = a.left;
                     a.left = b.right;
                     b.left = r.left;
                     b.right = r.right;
                     r = b;
                  }
               }
            }
         }
      }
      return r;
   }
   public boolean check(Comparable a){  //This method checks if there is a node that references the data inputted. If there is, it returns true; if not, false.
      node current = root;
      while(current.d != null){
         if(current.d.compareTo(a) == 0){
            return true;
         }
         else if(current.d.compareTo(a) < 0){
            if(current.right == null) return false;
            else current = current.right;
         }
         else{
            if(current.left == null) return false;
            else current = current.left;
         }
      }
      return false;	
   }
}