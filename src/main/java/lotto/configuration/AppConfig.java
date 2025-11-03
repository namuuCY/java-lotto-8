package lotto.configuration;

import lotto.controller.LottoController;
import lotto.domain.service.RandomLottoGenerator;
import lotto.service.LottoService;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

public class AppConfig {

    public static LottoController initController() {
        return new LottoController(
                new InputReader(),
                new OutputWriter(),
                injectStrategyToService()
        );
    }

    private static LottoService injectStrategyToService() {
        return new LottoService(
                new RandomLottoGenerator()
        );
    }
}
