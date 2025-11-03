package lotto.controller;

import java.util.List;
import java.util.Optional;
import lotto.controller.dto.PurchasedLotto;
import lotto.controller.dto.WinningStatistics;
import lotto.exception.DomainException;
import lotto.service.LottoService;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

public class LottoController {
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final LottoService lottoService;

    public LottoController(InputReader inputReader, OutputWriter outputWriter, LottoService lottoService) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.lottoService = lottoService;
    }

    public void init() {
        purchasePhase();
        statisticsPhase();
    }

    private void purchasePhase() {
        Optional<PurchasedLotto> purchased = Optional.empty();
        while (purchased.isEmpty()) {
            purchased = attemptPurchase();
        }
        outputWriter.writePurchased(purchased.get());
    }

    private Optional<PurchasedLotto> attemptPurchase() {
        try {
            Integer money = inputReader.readMoney();
            PurchasedLotto purchased = lottoService.purchase(money);
            return Optional.of(purchased);
        } catch (DomainException e) {
            outputWriter.printError(e.getMessage());
            return Optional.empty();
        }
    }

    private void statisticsPhase() {
        Optional<WinningStatistics> statistics = Optional.empty();
        while (statistics.isEmpty()) {
            statistics = attemptStatistics();
        }
        outputWriter.writeStatistics(statistics.get());
    }

    private Optional<WinningStatistics> attemptStatistics() {
        try {
            List<Integer> winningNumbers = inputReader.readCombination();
            Integer bonusNumber = inputReader.readBonusNumber();

            WinningStatistics statistics = lottoService.aggregate(
                    winningNumbers,
                    bonusNumber
            );
            return Optional.of(statistics);
        } catch (DomainException e) {
            outputWriter.printError(e.getMessage());
            return Optional.empty();
        }
    }
}
