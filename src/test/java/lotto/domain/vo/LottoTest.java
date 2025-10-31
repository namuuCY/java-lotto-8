package lotto.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 번호가 주어진 범위를 넘으면 예외가 발생한다.")
    @Test
    void 로또_번호가_주어진_범위를_넘으면_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호 순서가 오름차순이 아니면 예외가 발생한다")
    @Test
    void 번호_순서가_오름차순이_아니면_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(5, 2, 9, 7, 3, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
