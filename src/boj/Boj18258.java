package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj18258 {

  static List<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());
      String type = st.nextToken();
      switch (type) {
        case "push":
          int i = Integer.parseInt(st.nextToken());
          push(i);
          break;
        case "pop":
          int pop = pop();
          sb.append(pop).append("\n");
          break;
        case "front":
          int front = front();
          sb.append(front).append("\n");
          break;
        case "size":
          int size = size();
          sb.append(size).append("\n");
          break;
        case "empty":
          int empty = empty();
          sb.append(empty).append("\n");
          break;
        case "back":
          int back = back();
          sb.append(back).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }

  public static void push(int a) {
    queue.add(a);
  }

  public static int pop() {
    if (!queue.isEmpty()) {
      Integer remove = queue.remove(0);
      return remove;
    } else {
      return -1;
    }
  }

  public static int size() {
    return queue.size();
  }

  public static int empty() {
    if (queue.isEmpty()) {
      return 1;
    } else {
      return 0;
    }
  }

  public static int front() {
    if (!queue.isEmpty()) {
      return queue.get(0);
    } else {
      return -1;
    }
  }

  public static int back() {
    if (!queue.isEmpty()) {
      return queue.get(queue.size() - 1);
    } else {
      return -1;
    }
  }

}
