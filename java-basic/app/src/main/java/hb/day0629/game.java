package hb.day0629;

import java.util.*;

public class game {

  Scanner sc = new Scanner(System.in);

  private int floor;
  private int room;
  private String[][] name=new String[3][5];
  private String title;

  public game() { }
  public game(String name) { }
  public game(String name, int year) { }

  public void process() {

    int sel =9;
    for(int i=0; i<3; i++) {
      for(int j=0; j<5; j++) {
        name[i][j]="\t";
      }
    }

    while (true) {
      System.out.print("\n 1.입실 2.퇴실 3.map 4.list 9.종료");
      sel=Integer.parseInt(sc.nextLine());
      if (sel==9) {
        System.out.println("호텔예약 프로그램이 종료 되었습니다.");
        System.exit(1);
      }

      switch(sel) {
        case 1 : checkIn(); break;
        case 2 : checkOut(); break;
        case 3 : map(); break;
        case 4 : list(); break;
      }
    }
  }

  public void checkIn() {
    while (true) {
      System.out.print("몇층에 입실?");
      String f = sc.nextLine();
      try {
        floor =Integer.parseInt(f);
        System.out.println("숫자만 입력해주세요");
        System.out.print("몇호에 입실?");
        String r =sc.nextLine();
        room = Integer.parseInt(r);
        break;
      }catch (Exception e) {System.out.println("숫자만 입력해주세요");}
      continue;
    }
    if(name[floor-1][room-1] != "\t") {
      System.out.println("예약 불가능 합니다");
    }else {
      System.out.print("성함은?");
      name[floor-1][room-1]=sc.nextLine();
      System.out.printf("%s님 예약 되었습니다.",name[floor-1][room-1]);


    }
  }
  public void checkOut() {
    System.out.println("몇층?");
    String f= sc.nextLine();
    floor = Integer.parseInt(f);
    System.out.println("몇호?");
    String r= sc.nextLine();
    room = Integer.parseInt(r);

    if (name[floor-1][room-1] != "\t") {
      System.out.println("성함은?");
      name[floor-1][room-1]=sc.nextLine();
      System.out.printf("%s님 퇴실되었습니다. 안녕히 가세요!",name[floor-1][room-1]);
      name[floor-1][room-1]="\t";
    }else if(name[floor-1][room-1]=="\t") {
      System.out.println("비어있는 방이여서 퇴실을 할수 없습니다.");
    }
  }

  public void map() {
    System.out.println("\t실시간 호텔예약 현황 \n"+"\t⬛: 예약 불가  ⬜:예약가능");
    /*for(int i=0; i<3; i++) {
      for(int j=0; j<5; j++) {
        System.out.printf("\t%d0%d ",i+1, j+1);
      }
    }*/
    for(int i=0; i<3; i++) {
      for(int k=0; k<5; k++) {
        if(name[i][k] == "\t") {
          System.out.printf("\t□ %d0%d ", i+1, k+1);
        }else {
          System.out.printf("\t■ %d0%d ", i+1, k+1);
        }
      }
      for(int j=0; j<5; j++) {
        System.out.printf("\t%s", name[i][j]);
      }
      System.out.println("\n-------------------------------------------------------------");
    }
  }


  public void list() {
    for (int i=0; i<3; i++) {
      for (int j=0; j<5; j++) {
        System.out.printf("\n\t%d0%d호 \t%s고객님",i+1, j+1, name[i][j]);
      }
    }
    /*for(int i=0; i<3; i++) {
      for(int j=0; j<5; j++) {
        System.out.printf("\t%s", name[i][j]);
      }
    }*/
  }
  public static void main(String[] args) {
    game h = new game();
    h.process();
  }
}