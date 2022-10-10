package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {

  public static class Printer {

    int value;
    int index;

    public Printer(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int COUNT = Integer.parseInt(br.readLine());

    for (int i = 0; i < COUNT; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      List<Integer> arr = new ArrayList<>();
      Queue<Printer> queue = new LinkedList<>();
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int temp = Integer.parseInt(st.nextToken());
        arr.add(j, temp);
        queue.offer(new Printer(temp, j));
      }

      //오름차순 정렬 된 배열. 최대값을 갖고 있다.
      Collections.sort(arr, Collections.reverseOrder());
      int count = 0;

      while (true) {
        Printer poll = queue.poll();
        if (poll.index == M && arr.get(0) == poll.value) {
          count++;
          break;
        } else if (poll.value == arr.get(0)) {
          count++;
          arr.remove(0);
        } else {
          queue.offer(poll);
        }
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }
}
