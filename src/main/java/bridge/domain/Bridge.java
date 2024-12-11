package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> squares;

    public Bridge(List<String> squares) {
        validateSize(squares);
        this.squares = squares;
    }

    private void validateSize(List<String> squares) {
        int len = squares.size();
        if (len < 3 || len > 20) {
            throw new IllegalArgumentException("다리의 길이는 3 이상, 20 이하만 가능합니다.");
        }
    }

    public List<String> getSquares() {
        return squares;
    }

    public int getSize() {
        return squares.size();
    }
}
