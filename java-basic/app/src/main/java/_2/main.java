package _2;

public class main {

  public static void main(String[] args) {

    int inputNum = 1232;
    int accSum = 0;

    while(inputNum > 0) {
      accSum += inputNum %10;
      inputNum /= 10;
    }
    System.out.println(accSum);





  }
}