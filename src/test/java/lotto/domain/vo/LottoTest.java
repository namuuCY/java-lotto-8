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

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 번호가 주어진 범위를 넘으면 예외가 발생한다.")
    @Test
    void 로또_번호가_주어진_범위를_넘으면_예외() {
        assertThatThrownBy(() -> Lotto.of(List.of(0, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호 순서가 오름차순이 아니면 예외가 발생한다")
    @Test
    void 번호_순서가_오름차순이_아니면_예외() {
        assertThatThrownBy(() -> Lotto.of(List.of(5, 2, 9, 7, 3, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 숫자가 조합에 포함되어 있는지 테스트")
    @ParameterizedTest
    @MethodSource("generateMockData")
    void 특정_숫자가_조합에_포함되어_있는지_테스트(List<Integer> numbers, Integer target, Boolean expected) {
        // given
        Lotto lotto = Lotto.of(numbers);
        // when
        Boolean result = lotto.isIncluding(target);
        // then
        assertThat(expected).isEqualTo(result);
    }

    static Stream<Arguments> generateMockData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3, true),
                Arguments.of(List.of(11, 22, 33, 34, 35, 36), 7, false)
        );
    }
}
