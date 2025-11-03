package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

    private Statistics statistics;
    private Payment payment;

    @BeforeEach
    void setUp() {
//         5등 1개 (5,000원), 4등 1개 (50,000원)
        List<Rank> stats = new ArrayList<>();
        stats.add(Rank.FIFTH);
        stats.add(Rank.FOURTH);
        stats.add(Rank.MISS);
        payment = Payment.from(8000); // 8,000원 지불

        statistics = Statistics.of(payment, stats);

    }

    @Test
    void 통계_맵을_기반_총상금을_정확히_계산() {
        // given
        // 5,000원 (5등) + 50,000원 (4등)
        long expectedPrize = 55000L;

        // when
        long totalPrize = statistics.aggregateTotalPrice();

        // then
        assertThat(totalPrize).isEqualTo(expectedPrize);
    }

    @Test
    void 총상금과_구매_금액으로_수익률_객체를_생성() {
        // given
        // 총상금 55,000원 / 구매금액 8,000원 = 6.875
        // (6.875 * 100) = 687.5%
        double expectedRate = ((double) 55000L / 8000L) * 100.0;

        // when
        ProfitRate profitRate = statistics.getProfitRate();

        // then
        assertThat(profitRate.getRate()).isEqualTo(expectedRate);
    }

    @Test
    void 특정_등수의_당첨_개수를_반환() {
        // then
        assertThat(statistics.showCounts(Rank.FIFTH)).isEqualTo(1);
        assertThat(statistics.showCounts(Rank.FOURTH)).isEqualTo(1);
        assertThat(statistics.showCounts(Rank.MISS)).isEqualTo(1);
        assertThat(statistics.showCounts(Rank.FIRST)).isEqualTo(0); // 맵에 없으면 0
    }
}
