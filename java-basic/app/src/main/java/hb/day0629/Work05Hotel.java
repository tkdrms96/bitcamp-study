package hb.day0629;

import java.util.*;

public class Work05Hotel {   

  private int floor ; //층=행 3층
  private int room ;  //호=열 5호  3층*5열=15방구성
  private String[][] name = new String[3][5];
  private String title = "";

  public Work05Hotel(){ }
  public Work05Hotel(String name){ }
  public Work05Hotel(String name, int year){ }


  public void process() {
    Scanner sc = new Scanner(System.in);
    int sel = 9;
    while(true) {
      System.out.print("\n1.투숙  2.퇴실  3.map  4.list 9.종료 >>>");
      sel = sc.nextInt();
      if(sel==9) { 
        System.out.println("호텔예약프로그램 종료합니다");
        System.exit(1);
      }
      switch(sel) {
        case 1 : checkIn(); break;
        case 2 : checkOut(); break;
        case 3 : map(); break;
        case 4 : list(); break;
        default : System.out.println("잘못입력하셨어요"); return;
      }//switch end
    }//while end
  }//end

  public void checkIn() {
    Scanner sc = new Scanner(System.in);
    System.out.print("층입력 >>");
    int floor = sc.nextInt();
    System.out.print("호수입력입력 >>");
    int room = sc.nextInt();
    System.out.print("이름입력>> ");
    String title = sc.nextLine();
    System.out.println(name[floor-1][room-1] +"님 안녕하세요?");
    if(name[floor-1][room-1]==null) {
      System.out.print("성함은?");
      name[floor-1][room-1] = sc.nextLine();
      System.out.println("추카합니다 예약되셨습니다.");
    }else if(name[floor-1][room-1]!=null){
      System.out.println("다른방번호를 입력해주세요");
      return;
    }
  }

  public void checkOut() {
    loop: System.out.println("퇴실 체크아웃을 선택하셨습니다.");
    Scanner sc = new Scanner(System.in);
    System.out.println("층입력 >>");
    int floor = sc.nextInt();
    System.out.println("호수입력입력 >>");
    int room = sc.nextInt();
    System.out.println("이름입력" + ">>");
    name[floor-1][room-1] = sc.nextLine();
    if(name[floor-1][room-1]==null) {
      System.out.println("잘못 입력하셨습니다. 다시입력해주세요");
    }else if(name[floor-1][room-1]!=null){
      System.out.println("안녕히가세요");
    }
    name[floor-1][room-1] = null;
  }

  public void map() { //printAll()=list()=display()

  }//end

  public void list() { //영림쌤 구현해서 보여드리겠습니다 ㅛ
    System.out.println("\n\t[ list ]");
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 5; j++){
        if(name[i][j] == null) {
          System.out.print( " " + (i+1)+"0"+(j+1) +"호"+"□\t" +"\t"); 
        }else {
          System.out.print( " " + (i+1)+"0"+(j+1) +"호"+"■\t" + name[i][j] + "\t"); 
        }
      } //j end
      System.out.println();
    }//for i end
  }//end

  public static void main(String[] args) { 
    Work05Hotel wh = new Work05Hotel();
    wh.process();
  }//end
}//class END



