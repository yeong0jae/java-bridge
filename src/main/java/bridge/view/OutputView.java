package bridge.view;

import java.util.List;

public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void printMap(List<String> squares, boolean isFailed, int currentPosition) {
        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();

        if (isFailed) {
            for (int i = 0; i < currentPosition - 1; i++) {
                if (squares.get(i).equals("U")) {
                    up.append("O");
                    down.append(" ");
                } else {
                    up.append(" ");
                    down.append("O");
                }
            }
            if (squares.get(currentPosition).equals("U")) {
                up.append(" ");
                down.append("X");
            } else {
                up.append("X");
                down.append(" ");
            }
        } else {
            for (int i = 0; i < currentPosition; i++) {
                if (squares.get(i).equals("U")) {
                    up.append("O");
                    down.append(" ");
                } else {
                    up.append(" ");
                    down.append("O");
                }
            }

        }
        System.out.println(up);
        System.out.println(down);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> squares, String gameResult, int tryNumber) {
        System.out.println("최종 게임 결과");

        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();

        for (String square : squares) {
            if (square.equals("U")) {
                up.append("O");
                down.append(" ");
            } else {
                up.append(" ");
                down.append("O");
            }
        }

        System.out.println(up);
        System.out.println(down);
        System.out.println();
        System.out.println("게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + tryNumber);
    }
}
