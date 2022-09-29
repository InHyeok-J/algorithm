package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2920 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    List<Integer> inputs = new ArrayList<>();
    while (st.hasMoreTokens()) {
      int a = Integer.parseInt(st.nextToken());
      inputs.add(a);
    }

    Boolean isAscStart = false;
    Boolean isDscStart = false;
    Boolean isMixed = false;
    for (int i = 0; i < inputs.size(); i++) {
      Integer value = inputs.get(i);
      if (i == 0) {
        if (value == 8) {
          isDscStart = true;
        } else if (value == 1) {
          isAscStart = true;
        } else {
          isMixed = true;
        }
      }

      if (i <= 6) {
        Integer value2 = inputs.get(i + 1);
        int temp = value2 - value;
        if (temp == 1) {
          // 1 2 .. 이렇게 증가할 때
          // 역순은 이미 취소.
          isDscStart = false;
        } else if (temp == -1) {
          isAscStart = false;
        } else {
          isMixed = true;
          isAscStart = false;
          isDscStart = false;
        }
      }
    }

    if (isMixed) {
      System.out.println("mixed");
    } else {
      if (isAscStart) {
        System.out.println("ascending");
      } else if (isDscStart) {
        System.out.println("descending");
      }
    }

  }

}
