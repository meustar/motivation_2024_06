package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.system.controller.SystemController;

public class App {

    public App() {

    }
    public void run() {
        System.out.println("== motivation execution ==");


        SystemController systemController = new SystemController();
        MotivationController motivationControlle = new MotivationController();


        while (true) {
            System.out.print("command) ");
            String cmd = Container.getScanner().nextLine().trim();


            if (cmd.equals("exit")) {   // String 끼리의 비교는 서로 주소값을 비교하기 때문에 무한루프에 빠짐.
                systemController.exit();
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명력어를 입력해주세요. :)");
                continue;
            }

            if (cmd.equals("add")) {
                motivationControlle.add();
            } else if (cmd.equals("list")) {
                motivationControlle.list();
            } else if (cmd.equals("del")) {
                motivationControlle.delete();
            } else if (cmd.startsWith("delete")) {
                // parsing

                Rq rq = new Rq(cmd);

                System.out.println(rq.getActionMethod());
                System.out.println(rq.getParams("id"));
                System.out.println(rq.getParams("source"));
                System.out.println(rq.getParams("motivation"));

//                motivationController.delete();
            } else {
                System.out.println("사용할 수 없는 명령어입니다");
            }
        }
    }
}

