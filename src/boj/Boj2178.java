package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {

  static int[][] maze;
  static int[][] visited;
  static int XMAX;
  static int YMAX;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    XMAX = N;
    YMAX = M;
    maze = new int[N][M];
    visited = new int[N][M];
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      char[] chars = input.toCharArray();
      for (int j = 0; j < chars.length; j++) {
        if (chars[j] == '1') {
          maze[i][j] = 1;
        } else {
          maze[i][j] = 0;
        }
      }
    }
    BFS();
    System.out.println(visited[XMAX - 1][YMAX - 1]);
  }

  static int[] xoffsets = {1, 0, -1, 0};
  static int[] yoffsets = {0, 1, 0, -1};

  public static void BFS() {
    Queue<int[]> stack = new LinkedList<>();

    stack.offer(new int[]{0, 0});
    visited[0][0] = 1;

    while (!stack.isEmpty()) {
      int[] pop = stack.poll();
      int x = pop[0];
      int y = pop[1];
      for (int i = 0; i < 4; i++) {
        int xOffset = xoffsets[i];
        int yOffset = yoffsets[i];

        int X = x + xOffset;
        int Y = y + yOffset;
        if (X >= 0 && X < XMAX && Y >= 0 && Y < YMAX && visited[X][Y] == 0 && maze[X][Y] == 1) {
          stack.offer(new int[]{X, Y});
          visited[X][Y] = visited[x][y] + 1;
        }
      }
    }
  }


  public static void print() {
    for (int[] ar : visited) {
      for (int i : ar) {
        System.out.print("   " + i + "   ");
      }
      System.out.println();
    }
  }

}
