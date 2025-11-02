package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "6, true, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "4, true, FOURTH",
            "3, false, FIFTH",
            "3, true, FIFTH",
            "2, false, MISS",
            "1, true, MISS",
            "0, false, MISS"
    })
    void 일치_개수와_보너스_여부로_정확한_등수_반환(int matchCount, boolean bonusMatch, Rank expectedRank) {
        // when
        Rank result = Rank.valueOf(matchCount, bonusMatch);

        // then
        assertThat(result).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @CsvSource({
            "FIRST, 2_000_000_000",
            "SECOND, 30_000_000",
            "THIRD, 1_500_000",
            "FOURTH, 50_000",
            "FIFTH, 5_000",
            "MISS, 0"
    })
    void 각_등수별_올바른_상금을_반환(Rank rank, long expectedPrize) {
        // when
        long prize = rank.getPrizeMoney();

        // then
        assertThat(prize).isEqualTo(expectedPrize);
    }
}
