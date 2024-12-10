package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> moveStatus = new ArrayList<>();
    private final Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void move(String direction) {
        if (isMovable(direction)) {
            moveStatus.add("O");
        }
        moveStatus.add("X");
    }

    private boolean isMovable(String direction) {
        int currentPosition = moveStatus.size();
        String square = bridge.getSquares().get(currentPosition);
        return direction.equals(square);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
