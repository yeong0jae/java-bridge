package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeGameController(InputView inputView, OutputView outputView,
                                BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void run() {
        Bridge bridge = ready();
        play(bridge);
    }

    public Bridge ready() {
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> squares = bridgeMaker.makeBridge(bridgeSize);

        return new Bridge(squares);
    }

    private void play(Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String direction = inputView.readMoving();


    }

}
