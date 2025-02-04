package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.system.controller.SystemController;

public class App {

    byte system_status = 1;

    public void run() {
        System.out.println("== motivation execution ==");


        SystemController systemController = new SystemController();
        MotivationController motivationControlle = new MotivationController();

        // 메인 루프 -> 계속해서 명령어를 입력받는 역할.
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

            if (rq.getErrMsg().equals("오타 있음(id)")) {
                continue;
            }

            // 라우터 = 입력되어 가공된 명령어에 따라 맞는 기능에 넘기는 역할.
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
                    motivationControlle.delete(rq);
                    break;
                case "edit" :
                    motivationControlle.edit(rq);
                    break;
                default:
                    System.out.println("사용할 수 없는 명령어입니다.");
                    break;
            }
        }
    }
}

