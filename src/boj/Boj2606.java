package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {

  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int NodeN = Integer.parseInt(br.readLine());
    int LineN = Integer.parseInt(br.readLine());

    for(int i =1 ; i <= NodeN; i++){
      graph.put(i,new ArrayList<>());
    }

    for(int i = 0 ; i < LineN; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b=  Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    System.out.println(BFS(1)-1);
  }

  public static int BFS(int startNode){
    ArrayList<Integer> visited = new ArrayList<>();
    Queue<Integer> needVistied = new LinkedList<>();

    needVistied.offer(startNode);
    while (!needVistied.isEmpty()){
      Integer node = needVistied.poll();
      if(!visited.contains(node)) {
        visited.add(node);
        ArrayList<Integer> integers = graph.get(node);
        needVistied.addAll(integers);
      }
    }
    return visited.size();
  }
}
