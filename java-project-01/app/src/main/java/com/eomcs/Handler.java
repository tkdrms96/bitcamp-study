package com.eomcs;


// 메뉴를 처리할 클래스가 반드시 만들어야 하는 메서드의 시그너처를 정한다.
// 패키지 우클릭 - new - interface 로 인터페이스만들음
interface Handler {
  void execute();
  //규칙이기때문에 메서드 몸체 {} 가 있으면 안됌
}


//인터페이스 = 호출하는쪽 , 호출당하는쪽에서 지켜야할 규칙을 정하는것을 interface