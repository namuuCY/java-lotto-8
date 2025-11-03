package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ProfitRateTest {

    @Test
    void 수익률을_double로_값을_올바르게_저장() {
        // given
        double rateValue = 62.5;

        // when
        ProfitRate profitRate = ProfitRate.from(rateValue);

        // then
        assertThat(profitRate.getRate()).isEqualTo(62.5);
    }

    @Test
    void 수익률이_음수일_경우_예외() {
        double rateValue = -62.5;

        assertThatThrownBy(() -> ProfitRate.from(rateValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
