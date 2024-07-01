package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.system.controller.SystemController;

public class App {

    byte system_status = 1;

    public void run() {
        System.out.println("== motivation execution ==");


        SystemController systemController = new SystemController();
        MotivationController motivationControlle = new MotivationController();


        while (system_status == 1) {
            System.out.print("command) ");
            String cmd = Container.getScanner().nextLine().trim();


//            if (cmd.equals("exit")) {   // String 끼리의 비교는 서로 주소값을 비교하기 때문에 무한루프에 빠짐.
//                systemController.exit();
//                break;
//            } else

            if (cmd.length() == 0) {
                System.out.println("명력어를 입력해주세요. :)");
                continue;
            }

            Rq rq = new Rq(cmd);

            switch (rq.getActionMethod()) {
                case "exit" :
                    systemController.exit();
                    system_status = 0;
                    break;
                case "add" :
                    motivationControlle.add();
                    break;
                case "list" :
                    motivationControlle.list();
                    break;
                case "delete" :
                    motivationControlle.delete();
                default:
                    System.out.println("사용할 수 없는 명령어입니다.");
                    break;
            }
        }
    }
}

