package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> moveStatus) {
        int mapSize = moveStatus.size();
        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();
        up.append("[");
        down.append("[");
        for (int i = 0; i < mapSize; i++) {
            if (moveStatus.get(i).equals("O")) {
                if (bridge.get(i).equals("U")) {
                    up.append("O");
                    up.append("|");
                } else {
                    down.append("O");
                    down.append("|");
                }
            }
        }
        up.setCharAt(up.length() - 1, ']');
        down.setCharAt(down.length() - 1, ']');
        System.out.println(up);
        System.out.println(down);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
