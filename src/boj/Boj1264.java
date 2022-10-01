package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
*  모음의 개수
*/

public class Boj1264 {

  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<String > strList = new ArrayList<>();
    while (true){
      String str = br.readLine();
      if(str.equals("#")){
        break;
      }
      strList.add(str.toUpperCase());
    }

    for(String a : strList){
      count(a);
    }
    System.out.println(sb);
  }

  public static void count(String str){
    String[] vowel = {"A","E","I","O","U"};
    int result = 0;
    for (int i = 0 ; i < vowel.length; i++){
     result +=  str.length() - str.replace(vowel[i],"").length();
    }
    sb.append(result+"\n");
  }
}
