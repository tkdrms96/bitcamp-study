package com.eomcs;



class Calculator3 {
  int result;

  //non-static 메서드= 인스턴스메서드 일경우 주소를 받는변수가 자동으로 생김
  //인스턴스 주소를 받는 this 라는 이름의 변수가 내장되어있다.
  // 따라서 개발자가 인스턴스주소를 받는 변수를 파라미터로 선언할 필요가 없다.
  void plus(int value) {
    this.result  += value; // 앞에 this가 인스턴스 주소를 받는주소인데 생략가능함
    //기존에 result를 더하는것
  }
}
public class test3 {

  public static void main(String[] args) {

    Calculator3 obj1 = new Calculator3();
    Calculator3 obj2 = new Calculator3();


    obj1.plus(100); //Calculator3.plus 가 아닌 메서드를 호출할때 앞에 주소를 주고
    obj1.plus(200); // 인스턴스 메서드를 호출 후 값을줌 
    obj1.plus(300);// 그러면 메서드에 내장된 this라는 변수에 전달됌


    obj2.plus(111);
    obj2.plus(222);

    System.out.println(obj1.result);
    System.out.println(obj2.result);





  }

}
