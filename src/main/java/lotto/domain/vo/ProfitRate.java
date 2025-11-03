package lotto.domain.vo;

import lotto.exception.DomainException;
import lotto.exception.ExceptionCode;

public class ProfitRate {

    private final Double rate;

    private ProfitRate(Double rate) {
        validate(rate);
        this.rate = rate;
    }

    public static ProfitRate from(Double rate) {
        return new ProfitRate(
                rate
        );
    }

    private void validate(Double rate) {
        if (rate >= 0) {
            return;
        }
        throw new DomainException(ExceptionCode.PROFIT_RATE_INVALID);
    }

    public Double getRate() {
        return rate;
    }


}
