package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
* 잃어버린 괄호
* 그리디
*/
public class Boj1541 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String inputStr = br.readLine();
    /*
     *  55-50+40
     */
    String[] split = inputStr.split("-");
    List<Integer> intList = new ArrayList<>();
    for (int i = 0; i < split.length; i++) {
      String str = split[i];
      String[] split1 = str.split("\\+");
      int sum = 0;
      for(int k = 0; k< split1.length; k++ ){
        int temp = Integer.parseInt(split1[k]);
        sum += temp;
      }
      intList.add(sum);
    }

    int result = intList.remove(0);
    for(int i = 0 ; i < intList.size(); i++){
      result -= intList.get(i);
    }
    System.out.println(result);
  }

}
