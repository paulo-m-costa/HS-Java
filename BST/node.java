import java.util.*;
import java.io.*;

public class node{
   public Comparable d;
   public node left;
   public node right;
   public node(){
      d = null;
      left = null;
      right = null;
   }
   public node(Comparable md, node mleft, node mright){
      d = md;
      left = mleft;
      right = mright;
   }
   public boolean checkChild(){
      if (left==null && right==null) return false;
      return true;
   }
}