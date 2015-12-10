import java.util.*;

public class Stack{
   private ArrayList <Object> aList;
   public Stack(){  //Stack constructor.
      aList = new ArrayList <Object> ();
   }
   public void add(Object j){ //character insertion.
      aList.add(j);
   }
   public Object pop(){  //references the character at the top of the Stack.
      Object o = aList.get(aList.size() - 1);
      aList.remove(aList.size() - 1);
      return o;
   }
   public Object peek(){  //checks top element in Stack.
      return aList.get(aList.size() - 1);
   }
   public boolean isEmpty(){ //checks if Stack is empty.
      return aList.isEmpty();
   }
}