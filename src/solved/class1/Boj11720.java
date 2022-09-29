package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*  숫자의 합
*/
public class Boj11720 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int count = Integer.parseInt(st.nextToken());
    String inputString = br.readLine();
    int sum = 0;
    for(int i = 0; i < count; i++){
      int parseInt = Integer.parseInt(String.valueOf(inputString.charAt(i)));
      sum += parseInt;
    }
    System.out.println(sum);
  }
}
