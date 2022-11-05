package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10026 {

  static int N;
  static char[][] arr;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());

    arr = new char[N][N];
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      char[] chars = input.toCharArray();
      for (int j = 0; j < N; j++) {
        arr[i][j] = chars[j];
      }
    }
    int notRedGreenCount = 0;
    int redGreenCount = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          notRedGreen_BFS(j, i);
          notRedGreenCount++;
        }
      }
    }
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          redGreen_BFS(j, i);
          redGreenCount++;
        }
      }
    }
    System.out.println(notRedGreenCount + " " + redGreenCount);
  }

  static int[] xOffset = {0, 0, -1, 1};
  static int[] yOffset = {-1, 1, 0, 0};

  public static void notRedGreen_BFS(int startX, int startY) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{startX, startY});
    visited[startY][startX] = true;

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];

      char color = arr[y][x];
      for (int i = 0; i < 4; i++) {
        int dx = x + xOffset[i];
        int dy = y + yOffset[i];

        if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
          if (!visited[dy][dx] && arr[dy][dx] == color) {
            queue.offer(new int[]{dx, dy});
            visited[dy][dx] = true;
          }
        }
      }
    }
  }

  public static void redGreen_BFS(int startX, int startY) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{startX, startY});
    visited[startY][startX] = true;

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];

      char color = arr[y][x];
      for (int i = 0; i < 4; i++) {
        int dx = x + xOffset[i];
        int dy = y + yOffset[i];

        if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dy][dx]) {
          if ((color == 'R' || color == 'G') && (arr[dy][dx] == 'R' || arr[dy][dx] == 'G')) {
            queue.offer(new int[]{dx, dy});
            visited[dy][dx] = true;
          } else {
            if (color == arr[dy][dx]) {
              queue.offer(new int[]{dx, dy});
              visited[dy][dx] = true;
            }
          }
        }
      }
    }
  }

  static void print() {
    for (char[] charr : arr) {
      for (char ch : charr) {
        System.out.print(ch + " ");
      }
      System.out.println();
    }
  }

  static void visitedPrint() {
    for (boolean[] charr : visited) {
      for (boolean ch : charr) {
        System.out.print(ch + "     ");
      }
      System.out.println();
    }
  }
}
