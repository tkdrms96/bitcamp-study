package com.eomcs;

import java.util.*;

//01. main(): 프로그램 entry point
//02. 사용자로부터 명령어 입력 받기
//03. 사용자로부터 계속 명령어 입력 받기
//04. quit 명령어를 입력 받았을 때 반복 종료하기
//05. 명령어 별로 실행을 분기하기
//06. 게시글 입력 받기
//07. 배열을 이용하여 여러 개의 게시글 보관하기
//08. 상수(final 변수)를 이용하여 배열의 크기를 다루기
//09. 게시글 목록 출력하기
//10. 게시글 상세 조회
//11. 게시글 조회수 추가하기
//12. 게시글 등록일 추가하기
//13. 게시글 변경하기
//14. 게시글 삭제하기
//15. 메서드 문법을 이용하여 기능 별로 명령어를 묶어 관리하기
//16. 클래스를 이용하여 새 데이터타입을 정의하기
//17. 클래스를 이용하여 메서드를 분류하기 
//18. 데이터목록을 다루는 클래스를 재사용하기쉽게 분류
//19. 메뉴 선택 기능을 추가
//20. 리팩토링: extract method 메서드 추출 => 게시글 관리 메뉴 처리 코드를 별도의 메서드로 분류한다
//21. 리팩토링: 
//              move method 메서드 이동 => 게시글을 다루는 일은 BoardHandler에게 맡긴다.
//              클래스 이동 => Board 클래스를 사용하는 BoardHandler로 이동 시킨다.
//22. 메뉴 추가하기
//      - 회원 관리 기능을 추가하기 MemberHandler(미완성)
//      - 계산기 기능 추가하기(완성)
//23. 메뉴를 실행하는 핸들러의 사용 규칙을 통일하기 : 인터페이스 문법의 용도
//      - 규칙 정의 : Handler
//      - 규칙을 이행(implement) : BoardHandler, MemberHandler, ComputeHandler 모두
//24. 회원 관리 기능 완성하기
//      -회원 정보를 담을 데이터 타입을 새로 설계한다. => Member
//      -회원등록, 목록조회, 상세조회, 변경, 삭제
//      -게시글과 회원데이터를 함께 보관할 때의 문제점 확인하기
//25. 회원 데이터를 별도의 목록으로 관리하기 ( 단순한 방법 = 유지보수가 어렵다)
//      - 기존의 ArrayList 클래스를 복사하여 ArrayList2로 만들어 사용한다
//26. 인스턴스 변수로 배열을 관리하기
//      -ArrayList2.java는 삭제한다.
//      -ArrayList2.java의 변수를 인스턴스 변수로 전환한다.
//      -메서드에 작업할 때 사용할 변수의 주소를 인스턴스 주소의 파라미터로 받는다.
//      -BoardHandler.java와 MemberHandler.java 변경
//      -각 핸들러가 사용할 ArrayList의 인스턴스 따로 생성한다.
//      -ArrayList 메서드를 호출할 때마다 인스턴스의 주소를 전달한다.
//27. 인스턴스 변수를 사용하는 메서드는 인스턴스 메서드로 사용하기
//      -ArrayList의 메서드를 클래스 메서드에서 인스턴스 메서드로 전환한다.
//      -BoardHandler 와 MemberHandler 에서 ArrayList 의 인스턴스 메서드를 호출할때
//28. 게시판추가하기(클래스를 복제해서 만들기 유지보수가 어렵다)
//      -BoardHandler를 복제하여 BoardHandler2를 만든다.
//29. 여러개의 게시파늘 다를수 있도록 BoardHandler의 변수를 인스턴스 변수로 전환한다.
//      -또한 메서드도 인스턴스메서드로 전환한다.
//      -BoardHandler2는 삭제
public class App {

  // 한 개의 게시글을 담을 복합 데이터의 변수를 설계


  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {

    // App 클래스에서 만든 Scanner 인스턴스를 BoardHandler.keyScan emberHandler와 같이 쓴다.
    MemberHandler.keyScan = keyScan; // 멤버핸들러도 사용할수있음
    ComputeHandler.keyScan = keyScan; // compute 핸들러서도 사용할수있음


    // 규칙에 따라 만든 클래스에 대해
    // 규칙에서 정의한 메서드를 호출하려면
    // 먼저 그 클래스의 인스턴스를 생성한 후
    // 그 인스턴스를 이용하여 메서드를 호출해야한다.
    BoardHandler boardHandler = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();
    ComputeHandler computeHandler = new ComputeHandler();

    menuLoop: while (true) {
      System.out.println("[메뉴]"); //메인메소드 실행시 메뉴실행으로함
      System.out.println(" 1: 게시글 관리");
      System.out.println(" 2: 게시글 관리2");
      System.out.println(" 3: 회원 관리"); 
      System.out.println(" 4: 계산기");
      //메뉴를 보여주기위해 화일문 안으로 집어넣음 
      System.out.print("메뉴를 선택하시오 (종료:quit) [1..4]");
      String menuNo = keyScan.nextLine(); // 문자열로 받아서 메뉴를 받음 Integer로 변환 하는거 마음임

      switch (menuNo) {
        case "1": 
          boardHandler.execute(); //규칙을 따르게되면 클래스이름으로 호출하면안됌 BoardHnadler -> boardHandler
          break;
        case "2": 
          boardHandler2.execute(); //규칙을 따르게되면 클래스이름으로 호출하면안됌 BoardHnadler -> boardHandler
          break;
        case "3":
          memberHandler.execute(); // 회원관리 메뉴를 누르면 멤버핸들러로가서 service를 실행한다
          break;
        case "4":
          computeHandler.execute();// 클래스 이름으로 말고 레퍼런스주소를 저장한 변수를 실행하면 됌
          break;
        case "quit":
          break   menuLoop; // menuLoop로 화일문만 나가야함
        default :
          System.out.println("메뉴번호가 옳지않습니다.");
      }
      System.out.println();

    }


    keyScan.close();

    System.out.println("안녕히 가세요!");
  }


}