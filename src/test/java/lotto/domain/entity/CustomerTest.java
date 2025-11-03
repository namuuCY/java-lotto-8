package lotto.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.service.LottoGenerator;
import lotto.domain.service.StubLottoGenerator;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.Rank;
import lotto.domain.vo.Statistics;
import lotto.domain.vo.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private Customer customer;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {

        Lotto lotto1 = Lotto.of(List.of(1, 2, 3, 10, 11, 12)); // 3개 일치 (5등)
        Lotto lotto2 = Lotto.of(List.of(1, 2, 3, 4, 10, 11)); // 4개 일치 (4등)
        Lotto lotto3 = Lotto.of(List.of(10, 11, 12, 13, 14, 15)); // 0개 일치 (꽝)
        LottoGenerator stub = new StubLottoGenerator(
                Arrays.asList(lotto1, lotto2, lotto3)
        );
        customer = Customer.from(3000);

        customer.purchaseLotto(stub);

        // 당첨 번호: 1, 2, 3, 4, 5, 6 + 보너스 7
        winningLotto = WinningLotto.of(
                List.of(1, 2, 3, 4, 5, 6),
                7
        );
    }

    @Test
    void 당첨_번호와_비교하여_통계를_정확히_생성() {
//         when
        Statistics statistics = customer.aggregateResults(winningLotto);

        // then
        assertThat(statistics.showCounts(Rank.FIFTH)).isEqualTo(1);
        assertThat(statistics.showCounts(Rank.FOURTH)).isEqualTo(1);
        assertThat(statistics.showCounts(Rank.MISS)).isEqualTo(1);
        assertThat(statistics.showCounts(Rank.FIRST)).isEqualTo(0);
        assertThat(statistics.showCounts(Rank.SECOND)).isEqualTo(0);
        assertThat(statistics.showCounts(Rank.THIRD)).isEqualTo(0);
    }
}
