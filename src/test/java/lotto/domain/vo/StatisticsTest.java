package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

    private Statistics statistics;
    private Payment payment;

    @BeforeEach
    void setUp() {
        // 5등 1개 (5,000원), 4등 1개 (50,000원), 나머지 0개
        Map<Rank, Integer> statsMap = new EnumMap<>(Rank.class);
        statsMap.put(Rank.FIFTH, 1);
        statsMap.put(Rank.FOURTH, 1);
        statsMap.put(Rank.MISS, 6); // 8개 구매 가정

        statistics = new Statistics(statsMap);
        payment = Payment.from(8000); // 8,000원 지불
    }

    @Test
    void 통계_맵을_기반_총상금을_정확히_계산() {
        // given
        // 5,000원 (5등) + 50,000원 (4등)
        long expectedPrize = 55000L;

        // when
        long totalPrize = statistics.calculateTotalPrizeMoney();

        // then
        assertThat(totalPrize).isEqualTo(expectedPrize);
    }

    @Test
    void 총상금과_구매_금액으로_수익률_객체를_생성() {
        // given
        // 총상금 55,000원 / 구매금액 8,000원 = 6.875
        // (6.875 * 100) = 687.5%
        double expectedRate = 687.5;

        // when
        ProfitRate profitRate = statistics.calculateProfitRate(payment);

        // then
        assertThat(profitRate.getRate()).isEqualTo(expectedRate);
    }

    @Test
    void 특정_등수의_당첨_개수를_반환() {
        // then
        assertThat(statistics.getCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(statistics.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(statistics.getCount(Rank.MISS)).isEqualTo(6);
        assertThat(statistics.getCount(Rank.FIRST)).isEqualTo(0); // 맵에 없으면 0
    }
}
