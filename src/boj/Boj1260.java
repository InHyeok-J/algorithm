package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1260 {

  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int NodeN = Integer.parseInt(st.nextToken());
    int LineN = Integer.parseInt(st.nextToken());
    int StartNode = Integer.parseInt(st.nextToken());

    //node init
    for (int i = 1; i <= NodeN; i++) {
      graph.put(i, new ArrayList<>());
    }
    // LineInit
    for (int i = 0; i < LineN; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int Node = Integer.parseInt(st2.nextToken());
      int ConnectNode = Integer.parseInt(st2.nextToken());
      graph.get(Node).add(ConnectNode);
      graph.get(ConnectNode).add(Node);
    }
    ArrayList<Integer> dfs = DFS(StartNode);
    for (int i : dfs) {
      sb.append(i + " ");
    }
    sb.append("\n");
    ArrayList<Integer> bfs = BFS(StartNode);
    for (int i : bfs) {
      sb.append(i + " ");
    }
    System.out.println(sb);
  }

  public static ArrayList<Integer> DFS(int startNode) {
    ArrayList<Integer> visited = new ArrayList<>();
    Stack<Integer> needVisted = new Stack<>();
    needVisted.push(startNode);

    while (!needVisted.empty()) {
      int node = needVisted.pop();
      if (!visited.contains(node)) {
        visited.add(node);
        ArrayList<Integer> nodes = graph.get(node);
        Collections.sort(nodes, Collections.reverseOrder());
        needVisted.addAll(nodes);
      }
    }
    return visited;
  }

  public static ArrayList<Integer> BFS(int startNode) {
    Queue<Integer> needVisted = new LinkedList<>();
    ArrayList<Integer> visited = new ArrayList<>();
    needVisted.add(startNode);
    while (needVisted.size() > 0) {
      int node = needVisted.poll();
      if (!visited.contains(node)) {
        visited.add(node);
        ArrayList<Integer> nodes = graph.get(node);
        // 작은 순서대로 넣어야 함
        Collections.sort(nodes);
        needVisted.addAll(nodes);
      }
    }
    return visited;
  }

}
