package lotto.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.vo.Lotto;

public class RandomLottoGenerator implements LottoGenerator {
    private static final Integer START_INCLUSIVE_INDEX = 1;
    private static final Integer END_INCLUSIVE_INDEX = 45;
    private static final Integer COUNT_NUMBER = 6;

    @Override
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                START_INCLUSIVE_INDEX,
                END_INCLUSIVE_INDEX,
                COUNT_NUMBER
        );
        return Lotto.of(numbers);
    }
}
