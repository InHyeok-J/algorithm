package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11053 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    int[] memo = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    memo[0] = 1;
    int result = 1;
    for (int i = 1; i < N; i++) {
      int max = 0;
      for(int j = 0; j< i; j++){
        if(arr[j] < arr[i]){
          max = Math.max(memo[j], max);
        }
      }
      memo[i] = max+1;
      result = Math.max(result, memo[i]);
    }
    System.out.println(result);
  }
}
