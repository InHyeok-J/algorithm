package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1100 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    int N = -1;
    int result = 0;
    while (N++ < 7) {
      st = new StringTokenizer(br.readLine());
      String str = st.nextToken();
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        boolean isOk = isWhiteBlockStatus(i, N, ch);
        if (isOk) {
          result++;
        }
      }
    }
    System.out.println(result);
  }

  public static boolean isWhiteBlockStatus(int x, int y, char ch) {
    if ((x + y) % 2 == 0) {
      return ch == 'F';
    }
    return false;
  }

}
