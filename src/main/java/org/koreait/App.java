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

        int lastId = 0;

//        Motivation motivation0 = null;
//        Motivation motivation1 = null;        하나씩 하기엔 무식함.
//        Motivation motivation2 = null;

//        Motivation[] motivations = new Motivation[3]; // 정해진 배열만큼만 들어감...

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
//                motivation.id = id;
//                motivation.body = body;
//                motivation.source = source;


//                if (motivation.id == 1) {
//                    motivation0 = motivation;
//                } else if (motivation.id == 2) {
//                    motivation1 = motivation;
//                } else if (motivation.id == 3) {
//                    motivation2 = motivation;
//                }

//                motivations[id - 1] = motivation;

                motivations.add(motivation);


                System.out.printf("%d번 motivation이 등록 되었습니다.\n", id);
                lastId++;
            // 번호를 구현해보자. 2024_06_27
            } else if (cmd.equals("list")) {
                System.out.println("== motivation list ==");
                System.out.printf("    id    //   motivation   //   source   \n");
                System.out.println("=".repeat(40));
//                System.out.println(motivation2.toString());
//                System.out.println(motivation1.toString());
//                System.out.println(motivation0.toString());
                for(Motivation motivation : motivations) {
                    System.out.println(motivation.toString());
                }

                if (motivations.size() == 0) {
                    System.out.println("등록된 motivation 없음");
                } else {
                    System.out.println("있음");
                    System.out.println("등록된 motivation 갯수 : " + motivations.size());
                }


            }
        }

    }
}

