package lotto;

import lotto.configuration.AppConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoController controller = AppConfig.initController();

        controller.init();
    }
}
