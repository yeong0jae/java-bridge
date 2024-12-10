package bridge.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("다리의 개수로 무작위 다리를 생성한다.")
    @Test
    void makeBridgeTest() {
        BridgeNumberGenerator fixedBridgeNumberGenerator = new FixedBridgeNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(fixedBridgeNumberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(3);

        Assertions.assertThat(bridge).isEqualTo(List.of("U", "U", "U"));
    }

}