package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String rawInputValue = Console.readLine();
        return Integer.parseInt(rawInputValue);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
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
