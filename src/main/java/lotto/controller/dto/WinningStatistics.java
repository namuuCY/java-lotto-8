package lotto.controller.dto;

import java.util.LinkedHashMap;
import lotto.domain.vo.ProfitRate;
import lotto.domain.vo.Rank;
import lotto.domain.vo.Statistics;

public record WinningStatistics(
        LinkedHashMap<Rank, Integer> stats,
        Double profitRate
) {
    public static WinningStatistics of(Statistics statistics) {
        LinkedHashMap<Rank, Integer> orderedStats = new LinkedHashMap<>();

        orderedStats.put(Rank.FIFTH, statistics.showCounts(Rank.FIFTH));
        orderedStats.put(Rank.FOURTH, statistics.showCounts(Rank.FOURTH));
        orderedStats.put(Rank.THIRD, statistics.showCounts(Rank.THIRD));
        orderedStats.put(Rank.SECOND, statistics.showCounts(Rank.SECOND));
        orderedStats.put(Rank.FIRST, statistics.showCounts(Rank.FIRST));

        ProfitRate profitRate = statistics.getProfitRate();

        return new WinningStatistics(orderedStats, profitRate.getRate());
    }

}
