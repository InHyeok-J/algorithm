package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1312 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
//    Double DA = Double.valueOf(String.valueOf(A));
//    Double DB = Double.valueOf(String.valueOf(B));
//    System.out.println(DA/DB);
    //3.5714285714285716
    int search = 0;
    while (true) {
      int a = A / B;
      int b = A % B;
      int temp = b * 10;
      A = temp;
      search++;
      if (search == N) {
        System.out.println(temp / B);
        break;
      }
    }
  }
}
