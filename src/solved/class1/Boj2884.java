package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2884 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int H = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    if (M < 45) {
      int temp = 45 - M;
      M = 60 - temp;
      H--;
    } else {
      M = M - 45;
    }

    if (H < 0) {
      H = 23;
    }
    System.out.println(H + " " + M);
  }
}
