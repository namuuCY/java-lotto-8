package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitRateTest {

    @Test
    void 수익률을_double로_값을_올바르게_저장() {
        // given
        double rateValue = 62.5;

        // when
        ProfitRate profitRate = new ProfitRate(rateValue);

        // then
        assertThat(profitRate.getRate()).isEqualTo(62.5);
    }


    @ParameterizedTest
    @CsvSource({
            "62.53333, '62.5%'",        // 기본
            "51.5414, '51.5%'",       // 반올림 (내림)
            "51.55, '51.6%'",       // 반올림 (올림)
            "1000000.0, '1,000,000.0%'" // 천 단위 쉼표
    })
    void 소수점_둘째_자리_포매팅된_문자열을_반환(double rateValue, String expectedString) {
        // given
        ProfitRate profitRate = new ProfitRate(rateValue);

        // when
        // (가정) getFormattedString() 또는 toString()에 구현
        String formatted = profitRate.getFormattedString();

        // then
        assertThat(formatted).isEqualTo(expectedString);
    }
}
