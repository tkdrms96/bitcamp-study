package com.eomcs;

import java.util.*;

public class BoardHandler implements Handler{ 

  //implements 약속등을 이행 실시하다 인터페이스 규칙에 맞춰서 라는듯
  //Handler의 요구사항, 규칙등을 채운다
  //Handler인터페이스에 정의된 규칙을 이행안할시 오류뜸 EX) 22번 void execute2 할시 오류 

  static class Board {  
    String title;
    String content;
    String password;
    int viewCount;
    Date createdDate;
  }
  Scanner keyScan;
  //BoardHandler에서 사용할 ArrayList 인스턴스를 준비한다.
  ArrayList boardList = new ArrayList();

  //규칙에 따라 만든 메서드는 스태틱을 못붙이고 public붙여야함
  public void execute() {
    loop: while (true) {
      System.out.print("게시글관리 ");
      String command = keyScan.nextLine();

      switch (command) { //게시글관리목록을 복사해서 스위치 케이스1안에 들어옴 메뉴선택하면
        // 이 게시글관리 리스트가 나옴
        case "list": list(); break;
        case "add": add(); break;
        case "update": update(); break;
        case "delete": delete(); break;
        case "view": view(); break;
        case "back": // 이전메뉴로 돌아간다 Loop(다시[메뉴])로 돌아감
          break loop;
        default:
          System.out.println("지원하지 않는 명령입니다.");
      }
      System.out.println(""); // 명령을 실행한후 줄바꿈
      //오른쪽 마우스 누르고 refactoring -> extract method 해서 이름을 정하면 메서드를 이클립스가 만들어줌
    } //게시글관리를 App에서 BoardHandler로 옮긴다
  }




  void list() { //인스턴스의 주소를 적어준다.
    System.out.println("[게시글 목록]");

    Object[] arr = this.boardList.toArray(); 
    int i = 0;
    for (Object item : arr) { // Object item의 값을 arr까지 저장해라
      Board board = (Board) item;
      System.out.printf("%d, %s, %s, %d\n", 
          i++, 
          board.title, 
          String.format("%1$tY-%1$tm-%1$td", board.createdDate),
          board.viewCount);
    }
  }

  void add() {
    System.out.println("[게시글 등록]");

    if (this.boardList.size == ArrayList.MAX_LENGTH) {
      System.out.println("더이상 게시글을 추가할 수 없습니다.");
      return;
    }

    // 한 개의 게시글 데이터를 저장할 변수를 준비한다.
    Board board = new Board(); // Board 설계도에 따라 변수를 만들고 그 주소를 리턴한다.

    System.out.print("제목: ");
    board.title = this.keyScan.nextLine();

    System.out.print("내용: ");
    board.content = this.keyScan.nextLine();

    System.out.print("비밀번호: ");
    board.password = this.keyScan.nextLine();

    board.createdDate = new Date(); // 현재의 날짜와 시간을 생성하여 배열에 저장한다.

    boardList.append(board);

    System.out.println("게시글을 등록했습니다.");
  }

  void update() {
    System.out.println("[게시글 변경]");

    System.out.print("번호? ");
    int index = Integer.parseInt(this.keyScan.nextLine());

    if (index < 0 || index >= ArrayList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }

    Board board = (Board) this.boardList.retrieve(index);

    System.out.printf("제목(%s)? ", board.title);
    String title = this.keyScan.nextLine();

    System.out.printf("내용(%s)? ", board.content);
    String content = this.keyScan.nextLine();

    System.out.print("정말 변경하시겠습니까?(y/N) ");
    if (!this.keyScan.nextLine().equals("y")) {
      System.out.println("게시글 변경을 최소하였습니다.");
      return;
    } 

    board.title = title;
    board.content = content;

    System.out.println("게시글을 변경하였습니다.");
  }

  void delete() {
    System.out.println("[게시글 삭제]");

    System.out.print("번호? ");
    int index = Integer.parseInt(this.keyScan.nextLine());

    if (index < 0 || index >= this.boardList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }

    System.out.print("정말 삭제하시겠습니까?(y/N) ");
    if (!keyScan.nextLine().equals("y")) {
      System.out.println("게시글 삭제를 최소하였습니다.");
      return;
    } 


    this.boardList.remove(index);

    System.out.println("게시글을 삭제하였습니다.");
  }

  void view() {
    System.out.println("[게시글 조회]");

    System.out.print("번호? ");
    int index = Integer.parseInt(this.keyScan.nextLine());

    if (index < 0 || index >= ArrayList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }

    Board board = (Board) this.boardList.retrieve(index);

    board.viewCount++;

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("등록일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.createdDate);
  }
}