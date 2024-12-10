package bridge.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("플레이어가 올바르게 이동한다.")
    @Test
    void moveTest() {
        List<String> bridge = List.of("U", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move("U");
        bridgeGame.move("U");
        List<String> moveStatus = bridgeGame.move("U");

        Assertions.assertThat(moveStatus).isEqualTo(List.of("O", "O", "X"));
    }
}