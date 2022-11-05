package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj16918 {

  static int R;
  static int C;
  static int N;

  static char[][][] booms;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    booms = new char[R][C][2];

    for (int i = 0; i < R; i++) {
      String input = br.readLine();
      char[] chars = input.toCharArray();
      for (int j = 0; j < C; j++) {
        char ch = chars[j];
        booms[i][j][0] = ch;
        if (ch == '.') {
          booms[i][j][1] = 0;
        } else {
          booms[i][j][1] = 1;
        }
      }
    }
//
//    System.out.println("[INPUT]");
//    print();
//    System.out.println("----");

    int count = 1;
    while (count < N) {
      count++;
      if (count % 2 == 0) {
        // 3번 => 폭탄 설치\
        for (int i = 0; i < R; i++) {
          for (int j = 0; j < C; j++) {
            char ch = booms[i][j][0];
            if (ch == '.') {
              booms[i][j][0] = 'O';
              booms[i][j][1] = 0;
            } else {
              booms[i][j][1]++;

            }
          }
        }
      } else {
        // 4번 => 폭탄 터트리기.
        List<int[]> boomList = new ArrayList<>();
        for (int i = 0; i < R; i++) {
          for (int j = 0; j < C; j++) {
            char ch = booms[i][j][0];
            char time = ++booms[i][j][1];
            if (time == 3) {
              boomList.add(new int[]{i, j});
            }
          }
        }
        for (int i = 0; i < boomList.size(); i++) {
          int[] ints = boomList.get(i);
          boom(ints[0], ints[1]);
        }
      }
    }
    fprint();
  }

  static int[] xOffset = {0, 0, -1, 1};
  static int[] yOffset = {1, -1, 0, 0};

  public static void boom(int x, int y) {
    booms[x][y][0] = '.';
    booms[x][y][1] = 0;
    for (int i = 0; i < 4; i++) {
      int dx = x + xOffset[i];
      int dy = y + yOffset[i];

      if (dx >= 0 && dx < R && dy >= 0 && dy < C) {
        booms[dx][dy][0] = '.';
        booms[dx][dy][1] = 0;
      }
    }
  }

  public static void print() {
    for (char[][] arr2 : booms) {
      for (char[] arr : arr2) {
        System.out.print(arr[0] + "[" + (int) arr[1] + "]" + " ");
      }
      System.out.println();
    }
  }

  public static void fprint() {
    for (char[][] arr2 : booms) {
      for (char[] arr : arr2) {
        sb.append(arr[0]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
