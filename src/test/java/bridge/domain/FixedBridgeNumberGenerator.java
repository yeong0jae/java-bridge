package bridge.domain;

public class FixedBridgeNumberGenerator implements BridgeNumberGenerator {

    @Override
    public int generate() {
        return 1;
    }
}
