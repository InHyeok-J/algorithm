package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1021 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    LinkedList<Integer> deque = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      deque.offer(i);
    }

    List<Integer> arr = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      arr.add(Integer.parseInt(st.nextToken()));
    }

    int count = 0;
    for (int i = 0; i < arr.size(); i++) {
      Integer v = arr.get(i);
      while (!deque.isEmpty()) {
        int middle = deque.size() / 2 + 1;
        int targetIndex = deque.indexOf(v);

        if (targetIndex < middle) {
          if (deque.peekFirst() == v) {
            deque.pollFirst();
            break;
          } else {
            Integer temp = deque.pollFirst();
            deque.offerLast(temp);
            count++;
          }
        } else {
          if (deque.peekFirst() == v) {
            deque.pollFirst();
            break;
          } else {
            Integer temp = deque.pollLast();
            deque.offerFirst(temp);
            count++;
          }
        }
      }

    }

    System.out.println(count);
  }
}
