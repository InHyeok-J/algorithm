package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 {

  static int N;
  static int M;
  static int[][] wall;
  static int[][] copy_wall;
  static int result = 0;
  static int[] xOffset = {0, 0, 1, -1};
  static int[] yOffset = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    wall = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < M; j++) {
        int input = Integer.parseInt(st.nextToken());
        wall[i][j] = input;
      }
    }
    findSetWall(0);
    System.out.println(result);
  }

  public static void BFS() {
    Queue<int[]> queue = new LinkedList<>();
    copy_wall = new int[N][M];

    //copy
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        copy_wall[i][j] = wall[i][j];
      }
    }

    //바이러스 찾기.
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (copy_wall[i][j] == 2) {
          queue.offer(new int[]{j, i});
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];
      for (int i = 0; i < 4; i++) {
        int dx = x + xOffset[i];
        int dy = y + yOffset[i];
        if (dx >= 0 && dx < M && dy >= 0 && dy < N) {
          if (copy_wall[dy][dx] == 0) {
            copy_wall[dy][dx] = 2;
            queue.offer(new int[]{dx, dy});
          }
        }
      }
    }
    getResult();
  }

  public static void findSetWall(int depth) {
    if (depth == 3) {
      BFS();
      return;
    } else {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (wall[i][j] == 0) {
            //벽 세우기
            wall[i][j] = 1;
            //세운체로 다음 벽 찾기
            findSetWall(depth + 1);

            //벽 돌리기
            wall[i][j] = 0;
          }
        }
      }
    }
  }

  public static void getResult() {
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (copy_wall[i][j] == 0) {
          count++;
        }
      }
    }

    result = Math.max(count, result);
  }

}
