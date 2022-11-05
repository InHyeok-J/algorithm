package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj2667 {

  static int[][] map;
  static int[][] visited;
  static List<Integer> result = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    visited = new int[N][N];
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      char[] chars = input.toCharArray();
      for (int j = 0; j < N; j++) {
        char ch = chars[j];
        if (ch == '1') {
          map[i][j] = 1;
        } else {
          map[i][j] = 0;
        }
      }
    }

    while (true) {
      int[] ints = searchNextNode();
      if (ints[0] == -1) {
        break;
      }
      BFS(ints[0], ints[1]);
    }

    Collections.sort(result);
    sb.append(result.size()).append("\n");
    for(int i : result){
      sb.append(i).append("\n");
    }
    System.out.println(sb);
  }

  static int[] xOffset = {0, 0, 1, -1};
  static int[] yOffset = {1, -1, 0, 0};

  public static void BFS(int startX, int startY) {
    Queue<int[]> queue = new LinkedList<>();
    visited[startX][startY] = 1;
    queue.offer(new int[]{startX, startY});
    int maxSearch = 1;
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];
      for (int i = 0; i < 4; i++) {
        int X = xOffset[i] + x;
        int Y = yOffset[i] + y;
        if (X >= 0 && X < map.length && Y >= 0 && Y < map.length && visited[X][Y] == 0
            && map[X][Y] != 0) {
          queue.offer(new int[]{X, Y});
          visited[X][Y] = maxSearch + 1;
          maxSearch++;
        }
      }
    }
    result.add(maxSearch);
  }

  public static int[] searchNextNode() {
    int[] nextNode = {-1, -1};
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map.length; j++) {
        if (map[i][j] == 1 && visited[i][j] == 0) {
          nextNode = new int[]{i, j};
          break;
        }
      }
    }
    return nextNode;
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
