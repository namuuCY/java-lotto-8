package lotto.domain.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.service.LottoGenerator;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.Payment;
import lotto.domain.vo.Rank;
import lotto.domain.vo.Statistics;
import lotto.domain.vo.WinningLotto;

public class Customer {

    private final Payment payment;
    private final List<Lotto> lottoBundle;

    private Customer(Payment payment) {
        this.payment = payment;
        this.lottoBundle = new ArrayList<>();
    }

    public static Customer from(Integer payment) {
        return new Customer(
                Payment.from(payment)
        );
    }

    // LottoGenerator : 외부에서 주입받음.
    public void purchaseLotto(LottoGenerator lottoGenerator) {
        Integer trials = payment.createLottoCount();

        for (int i = 0; i < trials; i++) {
            Lotto retrieved = lottoGenerator.generate();
            lottoBundle.add(retrieved);
        }
    }

    public List<Lotto> printLottoBundle() {
        return this.lottoBundle;
    }

    public Statistics aggregateResults(WinningLotto winningLotto) {

        List<Rank> winningResults = lottoBundle.stream()
                .map(winningLotto::judgeRank)
                .toList();

        return Statistics.of(payment, winningResults);
    }

}
