package com.eomcs;

import java.util.*;

public class MemberHandler implements Handler{
  static Scanner keyScan; // keyScan을 사용하기위해 static으로 선언한다. app에서만든 스캐너를 같이쓰겠다

  // 사용자 정의 데이터타입
  // => 도메인 객체(domain)
  // 값 객체(value object)
  // 데이터 전송객체(Date Transfer Object; DTO)
  // 모델객체(model)

  static class Member{
    String name;
    String email;
    String password;
    boolean working;
    Date registeredDate;
  }
  static ArrayList memberList = new ArrayList();

  public void execute() {

    loop: while (true) {
      System.out.print("회원관리 > ");
      String command = keyScan.nextLine();


      switch (command) { //게시글관리목록을 복사해서 스위치 케이스1안에 들어옴 메뉴선택하면
        // 이 게시글관리 리스트가 나옴
        case "list": list(); break;
        case "add": add(); break;
        case "update": update(); break;
        case "delete": delete(); break;
        case "view": view();  break;
        case "back": // 이전메뉴로 돌아간다 Loop(다시[메뉴])로 돌아감
          break loop;
        default:
          System.out.println("지원하지 않는 명령입니다.");
      }
      System.out.println(""); // 명령을 실행한후 줄바꿈
      //오른쪽 마우스 누르고 refactoring -> extract method 해서 이름을 정하면 메서드를 이클립스가 만들어줌
    } //게시글관리를 App에서 BoardHandler로 옮긴다
  }

  static void add() {
    System.out.println("[회원 등록]");

    if (ArrayList.size == ArrayList.MAX_LENGTH) {
      System.out.println("더이상 게시글을 추가할 수 없습니다.");
      return;
    }

    // 한 개의 회원 데이터를 저장할 변수를 준비한다.
    Member member = new Member(); // =>  Member 설계도에 따라 변수를 만들고 그 주소를 리턴한다.


    System.out.print("이름: ");
    member.name = keyScan.nextLine();
    //멤버 레퍼런스로 저장된 주소를 찾아가서 name에 저장
    System.out.print("내용: ");
    member.email = keyScan.nextLine();
    //멤버 레퍼런스로 주소를 찾아가서 email을 저장
    System.out.print("비밀번호: ");
    member.password = keyScan.nextLine();
    //멤버 레퍼런스로 주소를 찾아가서 password을 저장
    System.out.print("재직여부:(y/N)");
    if(keyScan.nextLine().equals("y")){
      member.working = true;
    } else { // y라고하면 true로 저장 아니라고하면 false로 저장함
      member.working = false;
    }
    member.registeredDate = new Date(); // 현재의 날짜와 시간을 생성하여 배열에 저장한다.
    //멤버 레퍼런스로 주소를 찾아가서 registeredDate 날짜를 저장 =new date 로 현재날짜를 가지고옴

    memberList.append(member); // 사용자가 저장한 정보를 최종적으로 배열에 담는것

    System.out.println("회원을 등록했습니다.");
  }
  static void list() {
    System.out.println("[회원 목록]");

    Object[] arr = memberList.toArray();
    for (int i = 0; i <arr.length; i++) {
      //Member member = (member) arr[i]  는 arr[i]의값은 오브젝트지만 저장값을 member에 저장함
      System.out.printf("%d, %s, %s, %b\n",
          i,
          ((Member)arr[i]).name, //오브젝트라는 클래스 arr이기때문에 member로 형변환하고 name의 값을 꺼냄
          String.format("%1$tY-%1$tm-%1$td", ((Member)arr[i]).registeredDate),
          ((Member)arr[i]).working); 

      //오브젝트라는 클래스의 arr이기때문에 member로 형변환하고 name의 값을 꺼냄
      //(Member)arr[i].working만 하면 뒤에있는 working 변수만 형변환됌
      // object는 모든레퍼런스를 다 담는다. 

    }
  }
  static void view() {
    System.out.println("[회원 조회]");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if (index < 0 || index >= ArrayList.size) {
      System.out.println("무효한 회원 번호입니다.");
      return;
    } // index < 0 || 0보다 인덱스값이 작거나 인덱스값이 사이즈보다크면 오류남

    Member member = (Member) memberList.retrieve(index); //board에서 Member로 바꿔와야함

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("등록일: %1$tY-%1$tm-%1$td\n", member.registeredDate);
    System.out.printf("재직여부: %s\n", member.working ? "예" : "아니오"); 
  }
  // true = 예 false = 아니오를 출력함 

  static void update() {
    System.out.println("[회원 변경]");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if (index < 0 || index >= memberList.size) {
      System.out.println("무효한 회원 번호입니다.");
      return;
    }

    Member member = (Member) memberList.retrieve(index);

    System.out.printf("이름(%s)? ", member.name);
    String name = keyScan.nextLine();

    System.out.printf("이메일(%s)? ", member.email);
    String email = keyScan.nextLine();

    System.out.printf("암호?   ");
    String password = keyScan.nextLine();

    System.out.printf("재직중(%s) (y/N)? ", member.working ? "예" : "아니오");
    //member.working이 true 일경우(y) = 예 출력 그이외 아니오를 출력함
    boolean working = false; //기본을 false값으로저장함
    if(keyScan.nextLine().equals("y")) { //기본은 false인데 y일경우 true로 바꿔줌 맞을경우 예를 출력
      working = true;
    }
    System.out.print("정말 변경하시겠습니까?(y/N) ");
    if (!keyScan.nextLine().equals("y")) {
      System.out.println("회원 변경을 최소하였습니다.");
      return;
    }
    member.name = name;
    member.email = email;
    member.password = password;
    member.working = working; // member       의 working을 임시변수 working 값으로 변경한다는 의미

    System.out.println("회원을 변경하였습니다.");
  }

  static void delete() {
    System.out.println("[회원 삭제]");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if (index < 0 || index >= ArrayList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }

    System.out.print("정말 삭제하시겠습니까?(y/N) ");
    if (!keyScan.nextLine().equals("y")) {
      System.out.println("회원 삭제를하였습니다.");
      return;
    } 
    memberList.remove(index);
    System.out.println("회원을 삭제하였습니다");
  }
}
