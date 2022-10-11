package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj1159 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    HashMap<String, Integer> hashMap = new HashMap<>();
    while (N-- > 0) {
      String s = br.readLine();
      String key = s.substring(0, 1);
      if (hashMap.containsKey(key)) {
        Integer integer = hashMap.get(key);
        int k = integer + 1;
        hashMap.put(key, k);
      } else {
        hashMap.put(key, 1);
      }
    }
    Boolean isFail = true;
    for (String key : hashMap.keySet()) {
      Integer integer = hashMap.get(key);
      if (integer >= 5) {
        isFail = false;
        sb.append(key);
      }
    }

    if(isFail){
      System.out.println("PREDAJA");
    }else{
      System.out.println(sb);
    }
  }
}
