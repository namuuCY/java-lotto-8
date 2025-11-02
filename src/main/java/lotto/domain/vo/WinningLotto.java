package lotto.domain.vo;

import java.util.List;
import lotto.exception.DomainException;
import lotto.exception.ExceptionCode;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateCombinations(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, Integer bonusNumber) {
        return new WinningLotto(
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
