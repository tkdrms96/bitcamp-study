package hb.day0629;

import java.util.*;

public class HotelExam {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("전체 객실수를 입력하세요.");

    int room = scan.nextInt();        // 전체 객실수 (할당할 배열의 크기)

    System.out.println("전체 객실수는 " + room + "개 입니다.");

    int roomNum = 0;                          // 입력받는값 저장 : 입실할 호실
    String[] nameList = new String[room];                     // 해당 호실의 투숙객 성함을 저장해놓을 배열 : 투숙객 리스트
    int opt = 0;                                  // 입력받을 1~4중 하나의 값 저장 

    while (opt != 4) {                                                // 4를 입력할때까지 무한반복
      System.out.println("=============================================");
      System.out.println("<< 1.입실, 성함 입력    2.퇴실   3.전체현황    4.프로그램 종료  >>");
      System.out.println("=============================================");

      opt = scan.nextInt();                                    // 입력받은 1~4중 하나의 값 저장

      switch (opt) {                                             // 입력받은 1~4중 해당되는 case문 실행
        case 1:
          System.out.println("입실할 호실을 입력하세요.");
          roomNum = scan.nextInt();                    // 입력받은 호실의 값을 임시 저장

          if (nameList[roomNum - 1] == null) {            // 입력받은 해당 호실이 비었을 때 해당 if문 실행
            System.out.println("투숙객 성함을 입력하세요.");
            nameList[roomNum - 1] = scan.next();            // 입력받은 투숙객 성함을 투숙객 리스트에 저장

            System.out.println(roomNum + "호실, " + nameList[roomNum - 1] + "님 예약되셨습니다.");
            break;

          } else {                                // 입력받은 호실에 누군가 존재할때 해당 else문 실행
            System.out.println(roomNum + "호실은 입실할 수 없습니다.");
            break;
          }

        case 2:
          System.out.println("퇴실할 호실을 입력하세요");
          roomNum = scan.nextInt();            // 입력받은 호실의 값을 임시 저장 

          if (nameList[roomNum - 1] != null) {        // 입력받은 해당 호실에 누군가 존재할때 해당 if문 실행
            System.out.println(roomNum + "호실, 퇴실 완료되었습니다.");
            nameList[roomNum - 1] = null;    // 입실 조치후 해당 호실 투숙객 유/무 리스트에 아무도 없다고 초기화
            break;

          } else {
            System.out.println(roomNum + "호실은 아무도 투숙하고 있지 않습니다.");
            break;
          }

        case 3:
          for (int i = 0; i < room; i++) {            // 존재하는 호실까지 탐색 (for문 반복)
            if (nameList[i] == null) {
              System.out.println((i+1) + "호실이 비어있습니다.");
            } else {
              System.out.println((i+1) + "호실의 투숙객 : " + nameList[i]);
            }
          }
          break;

        case 4:
          System.out.println("프로그램을 종료합니다. 감사합니다");
          break;

        default:
          System.out.println("입력된 숫자에 해당되는 항목이 없습니다. 1~4까지의 숫자를 입력해주세요.");
          opt = 0;
          break;
      }
    }
  }
}

