package bridge.domain;

import java.util.List;

public class Player {

    private List<String> moveStatus;

    public Player(List<String> moveStatus) {
        this.moveStatus = moveStatus;
    }

    public boolean isFailed() {
        return moveStatus.get(moveStatus.size() - 1).equals("X");
    }

    public List<String> getMoveStatus() {
        return moveStatus;
    }

    public boolean isEnd(int bridgeSize) {
        return moveStatus.size() == bridgeSize;
    }

    public void addSuccess() {
        moveStatus.add("O");
    }

    public void addFailure() {
        moveStatus.add("X");
    }
}
