package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

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

    public void run() { // 게임 시작
        outputView.printStartMessage(); // 게임 시작 안내

        Bridge bridge = ready(); // 다리 준비
        play(bridge);
    }

    public Bridge ready() {
        int bridgeSize = retryUntilValid(inputView::readBridgeSize); // 다리 길이 입력 받기

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator); // 다리 생성기 생성
        List<String> squares = bridgeMaker.makeBridge(bridgeSize); // 다리 생성

        return new Bridge(squares); // 다리 생성, 다리 길이 유효성 검사
    }

    private void play(Bridge bridge) {
        System.out.println(bridge.getSquares().toString());

        // 시작 시점으로 돌아온다.
        attempt(bridge);
    }

    private void attempt(Bridge bridge) {
        // 다리 게임 생성. 내부에 moveStatus, retryNumber 생성.
        BridgeGame bridgeGame = retryUntilValid(() -> new BridgeGame(bridge));

        while (true) {
            String moving = retryUntilValid(inputView::readMoving); // 이동 방향 U/D 입력
            bridgeGame.move(moving); // 이동
            if (bridgeGame.isFinish()) {
                outputView.printResult(bridge.getSquares(), "성공", bridgeGame.getTryNumber());
                break;
            } else {
                if (bridgeGame.getPlayer().isFailed()) {
                    outputView.printMap(bridge.getSquares(), bridgeGame.getPlayer().isFailed(),
                            bridgeGame.getCurrentPosition());
                    if (retryUntilValid(inputView::readGameCommand)) {
                        bridgeGame.retry(); // tryNumber ++
                        attempt(bridge);
                    } else {
                        outputView.printResult(bridge.getSquares(), "실패", bridgeGame.getTryNumber());
                        break;
                    }
                } else {
                    outputView.printMap(bridge.getSquares(), bridgeGame.getPlayer().isFailed(),
                            bridgeGame.getCurrentPosition());
                }
            }
        }

    }

    private <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
