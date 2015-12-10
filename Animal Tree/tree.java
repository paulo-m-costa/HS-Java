public class tree{

public class node{ //nested class.
   Object d;
   node yes;
   node no;
   public node(Object md, node myes, node mno){
      d = md;
      yes = myes;
      no = mno;
   }
   public String toString(){ //translates d into a String.
      return d.toString();
   }
}

node root;
node tracker;
node trackprev;
public tree(){
   root = new node("tiger", null, null);
   tracker = root;
   trackprev = null;
}
public void yes(){
   trackprev = tracker;
   tracker = tracker.yes;
}
public void no(){
   trackprev = tracker;
   tracker = tracker.no;
}
public Object gety(){
   return tracker == null ? null : tracker.yes;
}
public Object getn(){
   return tracker == null ? null : tracker.no;
}
public void restart(){
   tracker = root;
}
public void makeNode(Object diff, Object in){
   node input = new node(in, null, null);
   node differ = new node(diff, input, tracker);
   if(tracker == root){ //handles the program at the beginning.
      root = differ;
   }
   else if(tracker == trackprev.yes){
      trackprev.yes = differ;
   }
   else{trackprev.no = differ;}
}
public Object returnTrack(){
   return tracker;
}
public String returnRoot(){
   if (root.no == null && root.yes == null){
      return "Are you thinking of a(n) " + root + "?";
   }
   else return (String) tracker.d;
}
}
   