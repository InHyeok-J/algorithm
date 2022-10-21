package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1991 {

  static StringBuilder sb = new StringBuilder();
  static HashMap<String, ArrayList<String>> tree = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int nodeN = Integer.parseInt(br.readLine());

    for (int i = 0; i < nodeN; i++) {
      st = new StringTokenizer(br.readLine());
      String key = st.nextToken();
      ArrayList<String> arr = new ArrayList<>();
      arr.add(0, st.nextToken());
      arr.add(1, st.nextToken());
      tree.put(key, arr);
    }
    preSearch("A");
    sb.append("\n");
    inSearch("A");
    sb.append("\n");
    postSearch("A");
    System.out.println(sb);
  }

  // 전위 : Root 노드를 먼저 탐색. Root -> Left, -> right
  public static void preSearch(String searchNode) {
    ArrayList<String> list = tree.get(searchNode);
    String left = list.get(0);
    String right = list.get(1);
    sb.append(searchNode);

    if (left.equals(".") && right.equals(".")) {
      return;
    }

    if (!left.equals(".")) {
      preSearch(left);
    }

    if (!right.equals(".")) {
      preSearch(right);
    }
  }

  // 중위 : Left 를 먼저 탐색, Left => Root => Middle
  // 접근 법 : 루트 노드부터 시작, 왼쪽 노드부터 먼저 가는데,
  public static void inSearch(String searchNode) {
    ArrayList<String> list = tree.get(searchNode);
    String left = list.get(0);
    String right = list.get(1);

    if (left.equals(".") && right.equals(".")) {
      sb.append(searchNode);
      return;
    }
    ;

    if (!left.equals(".")) {
      inSearch(left);
    }
    sb.append(searchNode);
    if (!right.equals(".")) {
      inSearch(right);
    }
  }

  public static void postSearch(String searchNode) {
    ArrayList<String> list = tree.get(searchNode);
    String left = list.get(0);
    String right = list.get(1);

    if (left.equals(".") && right.equals(".")) {
      sb.append(searchNode);
      return;
    }
    ;

    if (!left.equals(".")) {
      postSearch(left);
    }
    if (!right.equals(".")) {
      postSearch(right);
    }
    sb.append(searchNode);
  }


}
