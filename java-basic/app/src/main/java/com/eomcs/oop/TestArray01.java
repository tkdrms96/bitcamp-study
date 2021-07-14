package com.eomcs.oop;

public class TestArray01 {

  public static void main(String[] args) {
    //배열의 초기화
    //배열의 장단점
    String[] dong = new String[5];
    for(int i = 0; i < dong.length; i++) {
      System.out.print(dong[i] + " ");
    }
    System.out.println();

    boolean[] camp = new boolean[5];
    for(int i = 0; i < camp.length; i++) {
      System.out.print(camp[i] + " ");
    }
    System.out.println();
    double[] pi = new double[5];
    for(int i = 0; i < pi.length; i++) {
      System.out.print(pi[i] + " ");
    }
    System.out.println();
    //배열의 최대 단점 배열은 같은 타입으로만 구성, 크기 사이즈 고정
    //채팅구성원에대한정보 이름String, 나이int, 성별boolean => 배열구성비권장
    //웹web플젝 게시판 글쓴이, 제목, 내용, 이미지, 조회수, 날짜
    //채팅, 쇼핑몰, 게시판 구성할때 배열의 한계 collection모음 List계열
    //java.util패키지 List인터페이스 상속 - ArrayList클래스 , Vector클래스
    //java.util패키지 Map인터페이스, Set인터페이스, List인터페이스
    //같은타입구성, 크기고정인 배열의 단점을 List인터페이스 상속
    //같은타입구성, 크기고정인 1차열 blooean[] camp = new boolean;로 실습해봄
    //배열 및 문자열 시작위치 0번째부터입니다.
    //자바에서 표준출력 모니터 System.out 표준 입력 키보드 System.in == > Scanner클래스
    //
  }//end
}//class END
