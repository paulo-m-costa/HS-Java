//Paulo Costa
//12/18/2011
//Evaluator class that evaluates Postfix Expressions and returns a double.

import java.util.*;
import java.math.*;
public class evaluator{
   public static double evaluate(String a) throws Exception{ //evaluates a String (Postfix expression) that is taken as a parameter.
      ZeroError z = new ZeroError("Undefined Result."); //handles dividing by zero and 0^0.
      Stack nums = new Stack(a.length());
      double d;
      for(int b = 0; b < a.length(); b++){
         char c = a.charAt(b); //reads each character of the String.
         switch (c){
            default: d = c - '0'; nums.push2(d); break;
            case '+': nums.push2(nums.pop2() + nums.pop2()); break; //handles addition.
            case '-': nums.push2(-(nums.pop2() - nums.pop2())); break; //handles subtraction.
            case '*': nums.push2(nums.pop2()*nums.pop2()); break; //handles multiplication.
            case '/': double q = nums.pop2(); if(q == 0) throw z;double u = nums.pop2(); nums.push2(u/q); break; //handles division.
            case '^': double x1 = nums.pop2(); double x2 = nums.pop2(); if(x1 == 0 && x2 == 0) throw z; nums.push2(Math.pow(x2, x1)); break; //handles exponentiation.
         }
      }
      double e = nums.pop2(); //e is the last double remaining in the Stack and is therefore the evaluated expression.
      return e;
   }
}