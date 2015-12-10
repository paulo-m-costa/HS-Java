//Paulo Costa
//12/16/2011
//Translator class for the conversion of an Infix expression to a Postfix expression.

import java.io.*;
import java.util.*;
public class translator{
   private Stack theStack;
   private String input;
   private String output = "";
   tests test = new tests();
   public translator(String in){ //constructor; takes inputted String as a parameter.
      input = in;  
      int stackSize = input.length();
      theStack = new Stack(stackSize); //creates Stack of length equal to the inputted String.
   }
   public static boolean integerCheck(char num){  //checks if a character is an integer between 0 and 9 inclusive.
      if(num > '0' && num < '9' || num == '0' || num == '9') return true;
      else return false;
   }
   public void operatorValue(char oper, int precedence){  //assigns operators corresponding precedences.
      while(!theStack.isEmpty()){
         char top = theStack.pop();
         if(top == '('){
            theStack.push(top);
            break;
         }
         else{
            int exprecedence; //exprecedence - precedence outside of the Stack.
            if(top == '+' || top == '-') exprecedence = 1;
            else if (top == '^') exprecedence = 3;
            else exprecedence = 2;
            if(exprecedence < precedence){
            theStack.push(top);
            break;
         }
         else output = output + top;
         }
      }
      theStack.push(oper);
   }
   public void bracketValue(char c){ //handles parentheses in accordance with the order of precedence.
      while(!theStack.isEmpty()){
         char brack = theStack.pop();
         if(brack == '(') break;
         else output = output + brack; 
      }
   }
   public String translate() throws Exception{ //carries out the translation and handles all relevant exceptions.
      EndError end = new EndError("Missing Operand(s).");
      if(!test.endChecks(input)) throw end;
      OpError op = new OpError("Multiple Consecutive Operators.");
      if(!test.opChecks(input)) throw op;
      DubError d = new DubError("Multi-digit Number(s) Present.");
      if(!test.dubChecks(input)) throw d;
      ParenError p = new ParenError("Mismatched Parentheses.");
      if(!test.brackChecks(input)) throw p;
      Exception e = new Exception();
      if(!test.impChecks(input)) throw e;
      for(int j = 0; j < input.length(); j++){
         char single = input.charAt(j);
         switch (single){
            default: output = output + single; break;
            case '+': case '-': operatorValue(single, 1); break;
            case '*': case '/': operatorValue(single, 2); break;
            case'^': operatorValue(single, 4); break;
            case '(': theStack.push(single); break;
            case ')': bracketValue(single); break;
         }
      }
      while(!theStack.isEmpty()){
         output = output + theStack.pop();
      }
      return output;
   }
}