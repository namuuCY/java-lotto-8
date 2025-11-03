package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {

    @DisplayName("보너스 번호와 로또 번호가 중복될 경우 예외 발생")
    @Test
    void 보너스_번호_로또_번호_중복_시_예외_발생() {
        assertThatThrownBy(() -> {
                    WinningLotto.of(
                            List.of(1, 3, 4, 7, 9, 13),
                            13
                    );
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateMockData")
    void 당첨_등수_확인_테스트(
            List<Integer> winningComb,
            Integer bonusNumber,
            List<Integer> targetComb,
            Rank expectedRank
    ) {
        WinningLotto winningLotto = WinningLotto.of(winningComb, bonusNumber);
        Lotto target = Lotto.of(targetComb);

        Rank result = winningLotto.judgeRank(target);

        assertThat(expectedRank).isEqualTo(result);
    }

    static Stream<Arguments> generateMockData() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(2, 3, 4, 5, 6, 7),
                        Rank.SECOND
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(12, 23, 24, 25, 26, 27),
                        Rank.MISS
                )
        );
    }
}
