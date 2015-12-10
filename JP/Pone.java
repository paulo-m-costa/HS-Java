import java.io.*;

import java.math.*;

import java.util.*;


public class Pone {
    
public static ArrayList<Mass> masses = new ArrayList<Mass>();
  
  public static ArrayList<Anchor> anchors = new ArrayList<Anchor>();

	public static double eq = 0;
   
 public static double force = 0;
	
public static void main(String args[]) {
   
         masses.add(new Mass(1, 0.0, -3.0));

	        masses.add(new Mass(1, 0.0, 3.0));
 
           masses.add(new Mass(1,0.0,-6.0));
        
    masses.add(new Mass(1,0.0,6.0));
   
     	anchors.add(new Anchor(-1.5));
	
        anchors.add(new Anchor(1.5));
   
         for (int i=0; i<anchors.size(); i++) eq = eq + anchors.get(i).x;
 
           eq = eq/anchors.size();
    
        double lim=0;
     
       for (int i=0; i<masses.size(); i++) lim = lim + Math.abs(masses.get(i).v);
 
           lim = lim/masses.size();
 
           force = ((eq+(Math.abs(anchors.get(0).x)+anchors.get(1).x)/(anchors.size() + masses.size()) - masses.get(0).x)+(masses.get(1).x-eq+(Math.abs(anchors.get(0).x)+anchors.get(1).x)/(anchors.size() + masses.size())))*0.5-1;
	
	while (Math.abs(force) > 0.001 || lim > 0.001) {

			for(int i=0; i<masses.size(); i++){
     
           if (i%2==0) System.out.print((i+1) +": "+ -1*Math.abs(masses.get(i).x) + " ");
              
  else System.out.print((i+1) + ": " + Math.abs(masses.get(i).x) + " ");
            }
    
        System.out.println();
	
		force = ((eq+(Math.abs(anchors.get(0).x)+anchors.get(1).x)/(anchors.size() + masses.size()) - masses.get(0).x)+(masses.get(1).x-eq+(Math.abs(anchors.get(0).x)+anchors.get(1).x)/(anchors.size() + masses.size())))*0.5 - (Math.abs(anchors.get(0).x)+anchors.get(1).x)/anchors.size();
	
		for (int i=0; i<masses.size(); i++){
      
         if (i%2==0) masses.get(i).v = (masses.get(i).v + force)*0.8;
     
           else masses.get(i).v = (masses.get(i).v-force)*0.8;
     
           masses.get(i).x = masses.get(i).x + masses.get(i).v;
  
          }
          
  for (int i=0; i<masses.size(); i++) lim = lim + Math.abs(masses.get(i).v);

            lim = lim/masses.size();
	
	}

	}

}
