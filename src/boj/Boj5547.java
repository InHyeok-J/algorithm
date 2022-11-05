package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5547 {

  static int DX;
  static int DY;

  static int[][] arr;
  static boolean[][] visited;

  static int[][] odd = {
      {0, -1}, {-1, 0}, {0, 1}, {1, 1}, {1, 0}, {1, -1}
  };
  static int[][] even = {
      {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 0}, {0, -1}
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    DX = Integer.parseInt(st.nextToken());
    DY = Integer.parseInt(st.nextToken());

    //넉넉히 + 2개씩 할당.
    arr = new int[DY + 2][DX + 2];
    visited = new boolean[DY + 2][DX + 2];

    for (int y = 1; y <= DY; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 1; x <= DX; x++) {
        int xx = Integer.parseInt(st.nextToken());
        arr[y][x] = xx;
      }
    }
    BFS();

  }

  private static void BFS() {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{0, 0});
    visited[0][0] = true;
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];

      for (int i = 0; i < 6; i++) {
        int dx;
        int dy;
        if (y % 2 == 0) {
          dx = x + even[i][0];
          dy = y + even[i][1];
        } else {
          dx = x + odd[i][0];
          dy = y + odd[i][1];
        }
        if (dx >= 0 && dx <= DX + 1 && dy >= 0 && dy <= DY + 1) {
          if (!visited[dy][dx]) {
            if (arr[dy][dx] == 0) {
              visited[dy][dx] = true;
              queue.offer(new int[]{dx, dy});
            }
          }
        }
      }
    }

    int sum = 0;
    for (int i = 1; i <= DY; i++) {
      for (int j = 1; j <= DX; j++) {
        if (arr[i][j] == 0) {
          continue;
        }
        for (int t = 0; t < 6; t++) {
          int nx;
          int ny;
          if (i % 2 == 0) {
            nx = j + even[t][0];
            ny = i + even[t][1];
          } else {
            nx = j + odd[t][0];
            ny = i + odd[t][1];
          }
          if (visited[ny][nx]) {
            System.out.println("Y = " + ny + " X = " + nx  );
            sum++;
          }
        }
      }
    }
    System.out.println(sum);
  }


  static void print() {
    for (boolean[] arr2 : visited) {
      for (boolean i : arr2) {
        System.out.print(i + "     ");
      }
      System.out.println();
    }
  }

  static void print2() {
    for (int i = 1; i < arr.length - 1; i++) {
      for (int j = 1; j < arr[0].length - 1; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}
