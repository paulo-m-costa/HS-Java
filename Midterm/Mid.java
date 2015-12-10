import java.io.*;
	
public class Mid{

public static void main(String args[]){
   System.out.print('\n' + "1st Numerator: ");
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   String s ="";
   try{
      s = br.readLine();
   }
   catch(Exception e){
      System.out.println(e);
   }
   Rational r = new Rational(0,1);
   r.setNum(Integer.parseInt(s));
   System.out.print("1st Denominator: ");
   try{
      s = br.readLine();
   }
   catch(Exception e){
      System.out.println(e);
   }
   r.setDen(Integer.parseInt(s));
   System.out.println("The fraction is: " + r.toString());
   System.out.println("GCF: " + r.GCF());
   System.out.println("LCM: " + r.LCM());
   System.out.println("Simplified Fraction: " + r.simplify() + '\n');
   System.out.print("2nd Numerator: ");
   try{
      s = br.readLine();
   }
   catch(Exception e){
      System.out.println(e);
   }
   Rational r2 = new Rational(0,1);
   r2.setNum(Integer.parseInt(s));
   System.out.print("2nd Denominator: ");
   try{
      s = br.readLine();
   }
   catch(Exception e){
      System.out.println(e);
   }
   r2.setDen(Integer.parseInt(s));
   System.out.println("The fraction is: " + r2.toString());
   System.out.println("GCF: " + r2.GCF());
   System.out.println("LCM: " + r2.LCM());
   System.out.println("Simplified Fraction: " + r2.simplify() + '\n');
   System.out.println("The sum of the two fractions is: " + r.add(r, r2));
   System.out.println("The difference of the two fractions is: " + r.subtract(r, r2));
   r.equals(r, r2); 
}

}