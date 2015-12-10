import java.util.*;

public class node{
   Comparable weight;
   Object name;
   public node(){
      weight = 0;
      name = null;
   }
   public node(Comparable a, Object b){
      weight = a;
      name = b;
   }
   public void setWeight(Comparable a){
      weight = a;
   }
   public void setName(Object a){
      name = a;
   }
   public Comparable getWeight(){
      return weight;
   }
   public Object getName(){
      return name;
   }
} 