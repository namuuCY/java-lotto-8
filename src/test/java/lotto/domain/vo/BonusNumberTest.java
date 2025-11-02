package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 주어진 범위를 넘으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            -1, 0, 55
    })
    void 보너스_번호가_주어진_범위를_넘으면_예외(Integer number) {
        assertThatThrownBy(() -> BonusNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
