package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PaymentTest {

    @ParameterizedTest
    @ValueSource(ints = {
            -100,
            0,
            2000000
    })
    void 정해진_숫자_범위를_벗어난_경우_예외(Integer money) {
        assertThatThrownBy(() -> Payment.from(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {
            3100,
            45600
    })
    void 천_단위_숫자가_아닌_경우_예외(Integer money) {
        assertThatThrownBy(() -> Payment.from(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "12000,12",
            "1000,1"
    })
    void 구매한_만큼_로또_카운트_계산(Integer money, Integer expectCount) {
        Payment payment = Payment.from(money);

        Integer result = payment.createLottoCount();

        assertThat(result).isEqualTo(expectCount);
    }

}
