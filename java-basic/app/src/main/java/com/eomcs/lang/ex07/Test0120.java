package com.eomcs.lang.ex07;

//# 메서드 : 사용 전
//
public class Test0120{

  static void hello(String... names) {
    for(int i =0; i < names.length; i++) {
      System.out.printf("%s님 반갑습니다.\n", names[i]);
    }
  }
  static void hello2(String[] names) {
    for(int i = 0; i < names.length; i++) {
      System.out.printf("%s님 반갑습니다.\n", names[i]);
    }
  }
  public static void main(String[] args) {
    hello("홍길동", "임꺽정", "유관순");
    System.out.println("---------------");

    String[] arr = {"김구", "안중근", "윤봉길", "유관순"};

    hello(arr);
    System.out.println("---------------");

    String[] arr2 = {"김구", "안중근", "윤봉길", "유관순"};
    hello2(arr2);
    System.out.println("---------------");
  }
}    

