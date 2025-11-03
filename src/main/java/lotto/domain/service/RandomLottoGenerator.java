package lotto.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.vo.Lotto;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return Lotto.of(numbers);
    }
}
