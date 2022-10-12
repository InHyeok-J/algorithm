package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1026 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arrA = new int[N];
    int[] arrB = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arrA[i] = Integer.parseInt(st.nextToken());
    }
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arrB[i] = Integer.parseInt(st2.nextToken());
    }

    Arrays.sort(arrA);
    Arrays.sort(arrB);
    int result = 0;
    for(int i = 0 ; i < N ; i++){
      int A = arrA[i];
      int B = arrB[N-1-i];
      result += A*B;
    }
    System.out.println(result);
  }
}
