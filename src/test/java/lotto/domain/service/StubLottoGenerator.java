package lotto.domain.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lotto.domain.vo.Lotto;

public class StubLottoGenerator implements LottoGenerator {

    Queue<Lotto> lottos;

    public StubLottoGenerator(List<Lotto> lottos) {
        Queue<Lotto> Q = new LinkedList<>(lottos);
        this.lottos = Q;
    }

    @Override
    public Lotto generate() {
        return lottos.poll();
    }
}
