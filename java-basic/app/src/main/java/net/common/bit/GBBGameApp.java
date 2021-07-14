package net.common.bit;

import java.util.*;

public class GBBGameApp {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("가위바위보 게임입니다. 가위, 바위, 보중에 입력하세요");
    System.out.println("상근이 >> ");
    String a = s.nextLine();
    System.out.println("찬희 >> ");
    String b = s.nextLine();
    if(a.equals("가위")) {
      if(b.equals("가위")) {
        System.out.println("비겼습니다.");
      }
      else if(b.equals("바위")) {
        System.out.println("상근이가 이겼습니다");
      }
      else {
        System.out.println("찬희가이겼습니다.");
      }
    }
    else if(a.equals("바위")) {
      if(b.equals("바위")) {
        System.out.println("비겼습니다.");
      }
      else if(b.equals("가위")) {
        System.out.println("상근이가 이겼습니다.");
      }
      else if(b.equals("보")) {
        System.out.println("상근이가 졌습니다");
      }
    }
    else if(a.equals("보")) {

    }
  }
}