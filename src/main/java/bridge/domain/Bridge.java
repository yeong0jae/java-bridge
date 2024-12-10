package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> squares;

    public Bridge(List<String> bridge) {
        this.squares = bridge;
    }

    public List<String> getSquares() {
        return squares;
    }
}
