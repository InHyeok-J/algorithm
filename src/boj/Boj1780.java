package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1780 {

  static int[][] paper;
  static int minus = 0;
  static int zero = 0;
  static int plus = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int v = Integer.parseInt(st.nextToken());
        paper[i][j] = v;
      }
    }
    divid(0, 0, N);
    System.out.println(minus);
    System.out.println(zero);
    System.out.println(plus);
  }

  public static boolean check(int low, int col, int size) {
    int pa = paper[low][col];
    for (int i = low; i < low + size; i++) {
      for (int j = col; j < col + size; j++) {
        if (paper[i][j] != pa) {
          return false;
        }
      }
    }
    return true;
  }

  public static void divid(int low, int col, int size) {
    if (check(low, col, size)) {
      int v = paper[low][col];
      if (v == 0) {
        zero++;
      } else if (v == 1) {
        plus++;
      } else {
        minus++;
      }
    } else {
      int sub = size / 3;
      divid(low, col, sub);
      divid(low, col + sub, sub);
      divid(low, col + 2 * sub, sub);

      divid(low + sub, col, sub);
      divid(low + sub, col + sub, sub);
      divid(low + sub, col + 2 * sub, sub);

      divid(low + 2 * sub, col, sub);
      divid(low + 2 * sub, col + sub, sub);
      divid(low + 2 * sub, col + 2 * sub, sub);
    }
  }
}
