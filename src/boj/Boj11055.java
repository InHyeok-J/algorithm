package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11055 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    int[] memo = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i < N ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
      memo[i] = arr[i];
    }
    int max = 0;
    for(int i = 1; i < N ; i++){
      int preMax = 0;
      for(int j = 0; j < i; j++){
        if(arr[i] > arr[j]){
          // 증가하는 부분 수열일 떄. 기존 값들 중에서 가장 큰 값을 가져온다.
          preMax = Math.max(preMax, memo[j]);
        }
      }
      memo[i] += preMax;
      max = Math.max(memo[i], max);
    }
    for(int i : memo){
      System.out.print(i +" ");
    }
    System.out.println();
    if(max > memo[0]){
      System.out.println(max);
    }else {
      System.out.println(memo[0]);
    }
  }
}
