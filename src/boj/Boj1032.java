package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  명령 프롬프트
 */
public class Boj1032 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String[] strs = new String[N - 1];
    String str = br.readLine();
    for (int i = 0; i < N - 1; i++) {
      strs[i] = br.readLine();
    }

    String result = "";
    for (int i = 0; i < str.length(); i++) {
      boolean isNotMatch = false;
      char c = str.charAt(i);
      for (String str1 : strs) {
        if (!(str1.charAt(i) == c)) {
          isNotMatch = true;
        }
      }

      if (isNotMatch) {
        result += "?";
      }else{
        result += c;
      }
    }
    System.out.println(result);
  }
}
