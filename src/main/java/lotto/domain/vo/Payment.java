package lotto.domain.vo;

import lotto.exception.DomainException;
import lotto.exception.ExceptionCode;

public class Payment {
    private static final Integer DIVISOR = 1000;
    private static final Integer MIN_BOUND = 1000;
    private static final Integer MAX_BOUND = 100000;

    private final Integer money;

    private Payment(Integer money) {
        validate(money);
        this.money = money;
    }

    public static Payment from(Integer money) {
        return new Payment(money);
    }

    private void validate(Integer money) {
        checkOutOfBound(money);
        validateRemain(money);
    }

    private void checkOutOfBound(Integer money) {
        if (money >= MIN_BOUND && money <= MAX_BOUND) {
            return;
        }
        throw new DomainException(ExceptionCode.OUT_OF_BOUND_MONEY);
    }

    private void validateRemain(Integer money) {
        Integer remain = money % DIVISOR;
        if (remain.equals(0)) {
            return;
        }
        throw new DomainException(ExceptionCode.INVALID_MONEY_INPUT);
    }

    public Integer createLottoCount() {
        return money / DIVISOR;
    }

    public Long toLongValue() {
        return (long) money;
    }
}
