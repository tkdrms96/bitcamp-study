package net.common.bit;

import java.util.*;

public class ChangeMoney {
  final static int 오만원 = 50000;
  final static int 만원 = 10000;
  final static int 천원 = 1000;
  final static int 오백원 = 500;
  final static int 백원 = 100;
  final static int 오십원 = 50;
  final static int 십원 = 10;
  final static int 일원 = 1;
  public static void main(String[] args) {
    int res;
    int money;
    Scanner sin = new Scanner(System.in);
    System.out.print("금액을 입력하시오>>");
    money = sin.nextInt();
    res = money/오만원; // 오만원권 개수 계산
    money = money%오만원; // money 갱신
    if(res > 0) {
      System.out.println("오만원권 "+ res + "매"); // 오만원권 매수 표시
    }
    res = money/만원; // 만원권 개수 계산
    money = money%만원; // money 갱신
    if(res > 0) {
      System.out.println("만원권" + res + "매");
    }
  }
}