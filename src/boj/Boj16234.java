package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj16234 {

  static int N;
  static int L;
  static int R;

  static int[][] nation;
  static boolean[][] visited;
  static int[] xOffset = {0, 0, 1, -1};
  static int[] yOffset = {1, -1, 0, 0};
  static int count = 0;
  static List<int[]> nations = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    nation = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        nation[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = 0;
    while (true) {
      visited = new boolean[N][N];
      boolean isNext = false;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j]) {
            int sum = BFS(j, i);
            if (nations.size() > 1) {
              isNext = true;
              change(sum);
            }
          }
        }
      }
      if(!isNext) break;
      result++;
    }
    System.out.println(result);
  }

  public static void change(int sum){
    int avg = sum / nations.size();
    for(int[] point : nations){
      int x = point[0];
      int y = point[1];
      nation[y][x] = avg;
    }
    nations = new ArrayList<>();
  }


  public static int BFS(int x, int y) {
    Stack<int[]> stack = new Stack<>();

    stack.push(new int[]{x, y});
    visited[y][x] = true;
    int sum = 0;
    while (!stack.isEmpty()) {
      int[] pop = stack.pop();
      int popX = pop[0];
      int popY = pop[1];
      for (int i = 0; i < 4; i++) {
        int dx = popX + xOffset[i];
        int dy = popY + yOffset[i];
        if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
          int diff = Math.abs(nation[dy][dx] - nation[popY][popX]);
          if (diff >= L && diff <= R && !visited[dy][dx]) {
            if (sum == 0) {
              sum = nation[dy][dx] + nation[popY][popX];
              nations.add(new int[]{popX, popY});
              nations.add(new int[]{dx, dy});
            } else {
              sum += nation[dy][dx];
              nations.add(new int[]{dx, dy});
            }
            stack.push(new int[]{dx, dy});
            visited[dy][dx] = true;
          }
        }
      }
    }
    return sum;
  }

}
