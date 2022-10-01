package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 *  터렛
 */
public class Boj1002 {

  public static class XYZ {

    int x;
    int y;
    int z;

    public XYZ(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }

    @Override
    public String toString() {
      return "[" +
          "x=" + x +
          ", y=" + y +
          ", z=" + z +
          ']';
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    List<XYZ> arr = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int z1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int z2 = Integer.parseInt(st.nextToken());
      arr.add(new XYZ(x1, y1, z1));
      arr.add(new XYZ(x2, y2, z2));
    }
    for (int i = 0; i < arr.size(); i += 2) {
      XYZ lee = arr.get(i);
      XYZ jo = arr.get(i + 1);
      int solution = solution(lee, jo);
      sb.append(solution).append("\n");
    }
    System.out.println(sb);
  }

  public static int solution(XYZ lee, XYZ jo) {
    // 두 점 사이의 거리
    int distance = (int) ((int) Math.pow(lee.x - jo.x, 2) + Math.pow(lee.y - jo.y, 2));
    int circleDistance = (int) Math.pow(lee.z + jo.z, 2);
    int circleRadius = (int) Math.pow(lee.z - jo.z, 2);
    if ((lee.x == jo.x) && (lee.y == jo.y) && (lee.z == jo.z)) {
      //같은 좌표에 길이가 같음 => 원 무한대
      return -1;
    } else if (distance > circleDistance) {
      // 두 원이 아예 안만날 때
      return 0;
    } else if (distance < circleRadius) {
      // 원이 내접하는데, 안 만나는 경우
      return 0;
    } else if (distance == circleRadius) {
      //내접하는 경우
      return 1;
    } else if (distance == circleDistance){
      // 외접하는 경우
      return  1;
    }else{
      return 2;
    }
  }

}
