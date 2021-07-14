package com.eomcs;



class Calculator2 {
  int result;

  // static 이 들어가면 1번만 만들어짐
  // static이 안들어가면 new라는 명령어가 주는만큼 만들어짐
  // 메서드를 실행할때는 어느 result를 쓸지 주소를 받도록해야함 밑에 Calculator2 c
  static void plus(Calculator2 c, int value) {
    c.result  += value;
    //기존에 result를 더하는것
  }
}
public class test2 {

  public static void main(String[] args) {

    Calculator2 obj1 = new Calculator2(); // 캘큘레이터 2 설계도에따라 obj1에 레퍼런스를 저장
    Calculator2 obj2 = new Calculator2();

    Calculator2.plus(obj1, 100);
    Calculator2.plus(obj1, 200);
    Calculator2.plus(obj1, 300);


    Calculator2.plus(obj2, 111);
    Calculator2.plus(obj2, 222);

    System.out.println(obj1.result);
    System.out.println(obj2.result);





  }

}
