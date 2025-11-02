package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
