//Improved method O(n)
import java.util.Scanner;
public class MaxSubSum21 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    String[] input = sc.nextLine().split(" ");
    int[] Seq = new int[N];
    for (int i = 0; i < N; i++) {
      Seq[i] = Integer.parseInt(input[i]);
        
    }
    
    //integer property !!!
    int maxSum = -1;
    int thisSum = 0;
    int helper = 0;
    int first = 0;
    int last = N - 1;
    
    for(int i = 0; i < N; i++) {
      thisSum = thisSum + Seq[i];
      if(thisSum < 0) {
        thisSum = 0;
        helper = i + 1;
      }
      else if(thisSum > maxSum) {
        maxSum = thisSum;
        first = helper;
        last = i;
      }
        
    }
    // Really smart!
    if (maxSum == -1) {
      first = 0;
      last = N-1;
      maxSum = 0;
    }
    String output = maxSum + " " + Seq[first] + " " + Seq[last];
    System.out.print(output);
    sc.close();
  }
}