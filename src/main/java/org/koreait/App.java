package org.koreait;

import org.koreait.motivation.entity.Motivation;

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

        int lastId = 0;


        List<Motivation> motivations = new ArrayList<>();   // 저장소 (db)의 역할

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
                int id = lastId + 1;
                System.out.print("body : ");
                String body = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();

                Motivation motivation = new Motivation(id, body, source);

                motivations.add(motivation);

                System.out.printf("%d번 motivation이 등록 되었습니다.\n", id);
                lastId++;
            // 번호를 구현해보자. 2024_06_27
            } else if (cmd.equals("list")) {
                if (motivations.size() == 0) {
                    System.out.println("등록된 motivation 없음");
                    continue;
                }
                System.out.println("== motivation list ==");
                System.out.printf("    id    //   source   //   body   \n");
                System.out.println("=".repeat(40));

                for (int i = motivations.size() -1; i >= 0; i--) {
                    Motivation motivation = motivations.get(i);

                    // 3. 글자수가 너무 많으면..?
                    // 보여줄때만 보여주고, 인스턴스 변수 자체의 데이터가 훼손 되어서는 안됌.
                    if (motivation.getSource().length() > 7) {
                        System.out.printf("    %d    //   %s   //   %s   \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getBody());
                        continue;
                    }

                    System.out.printf("    %d    //   %s   //   %s   \n", motivation.getId(), motivation.getSource(), motivation.getBody());
                }


            }
        }

    }
}

