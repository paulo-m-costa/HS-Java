//Paulo Costa
//1/15/2012
//Basic Queue class, customized to handle ArrayLists for the purposes of dealing with adjacency matrices.

import java.util.*;

public class Queue{
   private ArrayList <Object> aList;
   public Queue(){ //Queue constructor.
      aList = new ArrayList <Object>();
   }
   public void add(Object i){ //allows objects to be inserted into the Queue.
       aList.add(i);
   }
   public Object pop(){ //allows the top object to be retrieved from the Queue.
      Object o = aList.get(0);
      aList.remove(0);
      return o;
   }
   public Object peek(){ //checks the top object in the Queue.
      return aList.get(0);
   }
   public boolean isEmpty(){ //checks if the Queue is empty.
      return aList.isEmpty();
   }
}