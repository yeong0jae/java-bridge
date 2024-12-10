package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeNumberGenerator;
import bridge.external.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView,
                bridgeRandomNumberGenerator);
        bridgeGameController.ready();
    }
}
