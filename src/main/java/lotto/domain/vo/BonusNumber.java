package lotto.domain.vo;

import lotto.exception.DomainException;
import lotto.exception.ExceptionCode;

public class BonusNumber {

    private final Integer LOWER_BOUND = 1;
    private final Integer UPPER_BOUND = 45;
    private final Integer bonusNumber;

    private BonusNumber(Integer bonusNumber) {
        checkOutOfBound(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(Integer bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void checkOutOfBound(Integer bonusNumber) {
        if (bonusNumber >= LOWER_BOUND
                && bonusNumber <= UPPER_BOUND) {
            return;
        }
        throw new DomainException(ExceptionCode.OUT_OF_BOUND_NUMBER);
    }
}
