import java.util.*;

public class Stack{
   ArrayList path;
   public Stack(){
      path = new ArrayList();
   }
   public void insert(Object a){
      path.add(a);
   }
   public Object pop(){
      return path.remove(path.size()-1);
   }
   public boolean isEmpty(){
      return (path.isEmpty());
   }
}