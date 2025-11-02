package lotto.domain.vo;

import lotto.exception.DomainException;
import lotto.exception.ExceptionCode;

public class BonusNumber {

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
        if (bonusNumber >= 1 && bonusNumber <= 45) {
            return;
        }
        throw new DomainException(ExceptionCode.OUT_OF_BOUND_NUMBER);
    }
}
