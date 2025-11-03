package lotto.service;

import java.util.List;
import lotto.controller.dto.PurchasedLotto;
import lotto.controller.dto.WinningStatistics;
import lotto.domain.entity.Customer;
import lotto.domain.service.LottoGenerator;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.Statistics;
import lotto.domain.vo.WinningLotto;

public class LottoService {

    private final LottoGenerator lottoGenerator;
    private Customer customer;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    // use case 1) 돈을 받고, 로또 dto를 생성
    public PurchasedLotto purchase(Integer money) {
        initCustomer(money);

        customer.purchaseLotto(lottoGenerator);
        List<Lotto> bundles = customer.printLottoBundle();
        return PurchasedLotto.from(bundles);
    }

    // use case 2) 당첨번호 + 보너스 번호를 받고 통계 dto를 생성
    public WinningStatistics aggregate(List<Integer> winningNumbers, Integer bonusNumber) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Statistics statistics = customer.aggregateResults(winningLotto);
        return WinningStatistics.of(statistics);
    }

    private void initCustomer(Integer money) {
        Customer customer = Customer.from(money);
        this.customer = customer;
    }

}
