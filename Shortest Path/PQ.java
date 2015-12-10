//Paulo Costa
//3/16/2012
//Priority queue class.

import java.util.*;

public class PQ{
   ArrayList<node> heap;
   public PQ(){ //constructor method.
      heap = new ArrayList<node>();
      heap.add(0, null);
   }
   public boolean checkParent(int tracker){
      if(tracker <= 1 || tracker >= heap.size()) return true;
      if(heap.get(tracker) == null || getParent(tracker) == null) return true;
      if(getParent(tracker).getWeight().compareTo((heap.get(tracker).getWeight())) > 0) return false;
      return true;
   }
   public node getParent(int tracker){ //obtains the parent node.
      node parent = heap.get((tracker-1)/2);
      return parent;
   }
   public void insert(node n){ //insertion method.
      node tmp;
      int trace = heap.size();
      heap.add(n);
      node parent = getParent(trace);
      while(!checkParent(trace)){
         if(checkParent(trace)) break;
         tmp = new node(parent.weight, parent.name);
         parent.setWeight(n.weight);
         parent.setName(n.name);
         n.setWeight(tmp.weight);
         n.setName(tmp.name);
         trace = (trace-1)/2;
         parent = getParent(trace);
      }
   }
   public node pop(){ //removes node at the top of the heap.
      node popped = heap.remove(1);
      return popped;
   }
   public node peek(){ //returns node at the top of the heap.
      return heap.get(1);
   }
   public boolean isEmpty(){ //checks if the heap is empty.
      return (heap.size()==1);
   }
}