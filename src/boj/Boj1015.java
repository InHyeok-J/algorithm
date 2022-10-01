package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  수열 정렬
 */
class Boj1015 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;
    int SIZE = Integer.parseInt(br.readLine());

    int[] P = new int[SIZE];
    int[] A = new int[SIZE];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < SIZE; i++) {
      int a = Integer.parseInt(st.nextToken());
      P[i] = a;
      A[i] = a;
    }
    Arrays.sort(A);

    for (int i = 0; i < SIZE; i++) {
      int a = P[i];
      for (int j = 0; j < SIZE; j++) {
        int avalue = A[j];
        if (avalue == a) {
          sb.append(j + " ");
          A[j] = 0;
          break;
        }
      }
    }
    System.out.println(sb);
  }
}
