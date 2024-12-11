package bridge.domain;

import java.util.ArrayList;

public class BridgeGame {

    private final Player player;
    private final Bridge bridge;
    private static int tryNumber;
    private boolean isFinish;

    public BridgeGame(Bridge bridge) {
        this.player = new Player(new ArrayList<>());
        this.bridge = bridge;
        tryNumber = 1;
        this.isFinish = false;
    }

    public void move(String moving) {
        if (isMovable(moving)) {
            player.addSuccess();
            if (player.isEnd(bridge.getSize())) {
                isFinish = true;
            }
        } else {
            player.addFailure();
        }
    }

    public int getCurrentPosition() {
        return player.getMoveStatus().size();
    }

    public void retry() {
        tryNumber++;
    }

    public Player getPlayer() {
        return player;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public boolean isFinish() {
        return isFinish;
    }

    private boolean isMovable(String moving) {
        int currentPosition = player.getMoveStatus().size();
        String square = bridge.getSquares().get(currentPosition);
        return moving.equals(square);
    }
}
