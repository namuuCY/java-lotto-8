package lotto.controller.dto;

import java.util.List;
import lotto.domain.vo.Lotto;

public record PurchasedLotto(Integer size, List<List<Integer>> lottoBundles) {

    public static PurchasedLotto from(List<Lotto> lottos) {
        Integer size = lottos.size();

        List<List<Integer>> bundles = lottos.stream()
                .map(Lotto::getNumbers)
                .toList();

        return new PurchasedLotto(
                size,
                bundles
        );
    }
}
