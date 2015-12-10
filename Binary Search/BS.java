import java.io.*;

public class BS{
   public static String[] input(){
      String array[] = new String[1123];
      int i = 0;
      try{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String s = br.readLine();
         while(s != null && i < array.length){
            array[i] = s;
            s = br.readLine();
            i++;
         }
         br.close();
      }
      catch(Exception e){
         System.out.println("An Error Occurred.");
      }
      String[] shortarray = new String[i];
      for(int q = 0; q < i; q++){
         shortarray[q] = array[q];
      }
      return shortarray;
   }

   public static int partition(Comparable[] arraybit, int left, int right){
      Comparable temp;
      int i = left - 1;
      for(int j = left; j < right; j++){		
         if(arraybit[j].compareTo(arraybit[right]) <= 0) {
            i++;
            temp = arraybit[i];
            arraybit[i] = arraybit[j];
            arraybit[j] = temp;
         }
      }
      temp = arraybit[i + 1];
      arraybit[i + 1] = arraybit[right];
      arraybit[right] = temp;
      return i + 1;
   }

   public static void RecurQS(Comparable[] array, int L, int R){   
      if(R > L){
         int m = partition(array, L, R);
         RecurQS(array, L, m - 1);
         RecurQS(array, m + 1, R);
      }
   }

   public static void QS(String array[], int L, int R){
      RecurQS(array, 0, array.length - 1);
   }

   public static int binary(String[] afterQS, int first, int last, String toFind){
      int median = first + (last - first)/2;
      String mid = afterQS[median];
      if(first < last){
         if(toFind.compareTo(mid) < 0) return binary(afterQS, first, median, toFind);
         else if(toFind.compareTo(mid) > 0) return binary(afterQS, median + 1, last, toFind);
         else return median;
      }
      return -1;
   }

   public static void main(String[] args){
      String first = args[0];
      String[] in = input();
      BS BS1 = new BS();
      QS(in, 0, in.length-1);
      System.out.println("Index of Element: " + binary(in, 0, in.length, first));
   }
}