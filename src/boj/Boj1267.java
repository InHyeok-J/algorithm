package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1267 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = 0;
    int Y = 0;

    while (N-- > 0) {
      int input = Integer.parseInt(st.nextToken());
      M += calM(input);
      Y += calY(input);
    }

    if (M < Y) {
      System.out.println("M " + M);
    } else if (M > Y) {
      System.out.println("Y " + Y);
    } else {
      System.out.println("Y M " + Y);
    }

  }

  public static int calY(int M) {
    int result = 1;
    result += M / 30;
    return result * 10;
  }

  public static int calM(int Y) {
    int result = 1;
    result += Y / 60;
    return result * 15;
  }
}
