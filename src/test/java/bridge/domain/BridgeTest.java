package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    @DisplayName("다리의 길이가 3 미만, 20 초과이면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void bridgeTest(int squareSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new FixedBridgeNumberGenerator());
        List<String> squares = bridgeMaker.makeBridge(squareSize);

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Bridge(squares)
        ).withMessage("다리의 길이는 3 이상, 20 이하만 가능합니다.");
    }

}