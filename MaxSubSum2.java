import java.util.Scanner;
public class MaxSubSum2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    if (N <= 100000){
      String[] input = sc.nextLine().split(" ");
      int[] Seq = new int[N];
      boolean helper = false;
      int first = Seq[0];
      int last = Seq[N-1];
      for (int i = 0; i < N; i++) {
        Seq[i] = Integer.parseInt(input[i]);
        if (Seq[i] > 0){
          helper = true;
        }
      }
      int MaxSum = 0;
      if(helper) {
        int ThisSum = 0;
        
        for(int i = 0; i < N; i++) {
          for(int j = i; j < N; j++) {
            ThisSum = ThisSum + Seq[j];
            if (ThisSum > MaxSum) {
              MaxSum = ThisSum;
              first = Seq[i];
              last = Seq[j];
            }else if(ThisSum < 0) {
              ThisSum = 0;
              break;
            }
          }
          
        }
        
      }
      
      
      String output = MaxSum + " " + first + " " + last;
      
      System.out.println(output);
    }
    sc.close();
  }
}