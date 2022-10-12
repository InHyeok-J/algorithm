package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630 {

  static int[][] paper;
  static int white = 0;
  static int blue = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        String s = st.nextToken();
        if (s.equals("1")) {
          paper[i][j] = 1;
        }
      }
    }
    divid(0, 0, N);
    System.out.println(white);
    System.out.println(blue);
  }

  public static boolean check(int low, int col, int size) {
    int isFirst = paper[low][col];
    for (int i = low; i < low + size; i++) {
      for (int j = col; j < col + size; j++) {
        if (paper[i][j] != isFirst) {
          return false;
        }
      }
    }
    return true;
  }

  public static void divid(int low, int col, int size) {
    if (check(low, col, size)) {
      int i = paper[low][col];
      if (i == 0) {
        white++;
      } else {
        blue++;
      }
    } else {
      // [0 7] [ 0 7]
      // [0~3] [0~3] [4~7][0~3] [ 0~3][4~7][ 4~7][4~7]
      int subSize = size / 2;
      divid(low, col, subSize);
      divid(low + subSize, col, subSize);
      divid(low, col + subSize, subSize);
      divid(low + subSize, col + subSize, subSize);
    }
  }

}
