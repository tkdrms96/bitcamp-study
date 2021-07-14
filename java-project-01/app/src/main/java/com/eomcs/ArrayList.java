package com.eomcs;

public class ArrayList {

  //배열의 최대 크기를 지정하는 변수는 모든 인스턴스가 같다.
  // => 각 인스턴스 마다 이 변수를 가질 필요는 없다.
  // => 그러니 그냥 이 변수는 그냥 클래스 변수로 둔다.
  // - > 보통 상수 변수 는 클래스변수로 선언한다.
  static final int MAX_LENGTH = 100;
  //각 인스턴스 마다 개별적으로 관리해야 하는 변수는 인스턴스변수로 선언한다.

  Object[] list = new Object[MAX_LENGTH];
  static int size = 0;

  //인스턴스 변수 (예 : list , size)를 사용하는 메서드는 인스터스 메서드로 전환한다.
  // 인스턴스 메서드는 인스턴스 주소를 받는 this라는 이름의 레퍼런스를 내포하고 있다.
  //static을 없애고 that -> this로 바꿈 ArrayList의 주소지값을 삭제함
  void append(Object obj) { // 사이즈가 있는 변수의 장소를 알아야 사용함
    this.list[this.size++] = obj;
  }
  Object[] toArray() { //Arraylist that 삭제하고 that이라고 주소지값을 정해져있는걸 삭제하고 this
    Object[] arr = new Object[this.size];
    for(int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr; 
    /*현재 배열에 들어가있는 개수만큼만 담을 새로운 배열을 만들고 기존배열의값을 
      복사해서 값만들어있는 새로만든배열만리턴
     */

  }

  Object retrieve(int index) {
    return this.list[index];
  }

  void remove(int index) {
    for (int i = index; i < ArrayList.size - 1; i++) {
      this.list[i] = this.list[i + 1];
    }

    this.size--;
  }
}
