//Paulo Costa
//12/15/2011
//Basic Stack class, customized to handle both characters and doubles for the push and pop methods.
public class Stack{
   private char[] stackArray; //array of characters.
   private double[] dubArray; //array of doubles.
   private int top;
   public Stack(int max){  //Stack constructor.
      stackArray = new char[max];
      dubArray = new double[max];
      top = -1;
   }
   public void push(char c){ //character insertion.
      stackArray[++top] = c;
   }
   public void push2(double d){ //double insertion.
      dubArray[++top] = d;
   }
   public char pop(){  //references the character at the top of the Stack.
      return stackArray[top--];
   }
   public double pop2(){
      return dubArray[top--]; //references the double at the top of the Stack.
   }
   public char peek(){  //checks top element in Stack.
      return stackArray[top];
   }
   public boolean isEmpty(){ //checks if Stack is empty.
      return (top == -1);
   }
}