package all;

import java.io.IOException;

public class Test {

  public static void main(String[] args) throws IOException {
    int n = 10;
    String input = "  tRy hello  WORLD";
    System.out.println("\""+solution(input)+"\"");
  }

  public static String solution(String s) {
    StringBuilder sb = new StringBuilder();
    String replace = s.replace(" ", "_");

    int start = 0;
    String[] split = replace.split("");
    for(int i = 0; i < split.length; i++){
      String temp = split[i];
      if(temp.equals("_")){
        start = 0;
      }else{
        if(start % 2 == 0){
          split[i] = temp.toUpperCase();
        }else {
          split[i] = temp.toLowerCase();
        }
        start++;
      }
      sb.append(split[i]);
    }
    String str = sb.toString();
    System.out.println(str);
    return str.replace("_"," ");
  }
}
