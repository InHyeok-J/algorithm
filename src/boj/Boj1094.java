package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  막대기
 */
public class Boj1094 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int sum = 64;
    int size = 0;
    while (N > 0) {
      if (sum > N) {
        sum = sum / 2;
      }else {
        size++;
        N -= sum;
      }
    }

    System.out.println(size);
  }

}
