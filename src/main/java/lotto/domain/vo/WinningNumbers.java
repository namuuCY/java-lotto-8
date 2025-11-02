package lotto.domain.vo;

import java.util.List;
import lotto.exception.DomainException;
import lotto.exception.ExceptionCode;

public class WinningNumbers {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningNumbers(Lotto lotto, BonusNumber bonusNumber) {
        validateCombinations(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(List<Integer> numbers, Integer bonusNumber) {
        return new WinningNumbers(
                Lotto.of(numbers),
                BonusNumber.from(bonusNumber)
        );
    }

    private void validateCombinations(Lotto lotto, BonusNumber bonusNumber) {
        Integer targetNumber = bonusNumber.getBonusNumber();
        if (!lotto.isIncluding(targetNumber)) {
            return;
        }
        throw new DomainException(ExceptionCode.BONUS_NUMBER_DUPLICATED);
    }

}
