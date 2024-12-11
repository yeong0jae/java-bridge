package bridge.view;

import bridge.util.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String rawInputValue = Console.readLine();
        if (!rawInputValue.matches("\\d")) {
            throw new IllegalArgumentException(ErrorMessage.prefix + "다리의 길이는 숫자만 가능합니다.");
        }
        return Integer.parseInt(rawInputValue);
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.prefix + "이동할 칸은 U와 D만 가능합니다.");
        }
        return moving;
    }

    public boolean readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        if (Console.readLine().equals("R")) {
            return true;
        }
        if (Console.readLine().equals("Q")) {
            return false;
        }
        throw new IllegalArgumentException("재시도 실패: 잘못된 값을 입력하였습니다.");
    }
}
