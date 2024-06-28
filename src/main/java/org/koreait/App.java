package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    List<Integer> numbers = new ArrayList<>();
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }
    public void run() {
        System.out.println("== motivation execution ==");

        int lastId = 1;

        while (true) {
            System.out.print("command) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {   // String 끼리의 비교는 서로 주소값을 비교하기 때문에 무한루프에 빠짐.
                System.out.println("== motivation end ==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명력어를 입력해주세요. :)");
                continue;
            }



            // 찐 기능
            if (cmd.equals("add")) {
                System.out.print("motivation : ");
                String motivation = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();
                System.out.printf("%d번 motivation이 등록 되었습니다.\n", lastId);
                lastId++;
            // 번호를 구현해보자. 2024_06_27
            } else if (cmd.equals("list")) {
                System.out.println("== motivation list ==");
                System.out.printf("    id    //   motivation   //   source   \n");
                System.out.println("=".repeat(40));

            }
        }

    }
}
