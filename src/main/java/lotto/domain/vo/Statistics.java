package lotto.domain.vo;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final ProfitRate profitRate;
    private final Map<Rank, Integer> results;

    public static Statistics of(Payment payment, List<Rank> winningResults) {
        return new Statistics(payment, winningResults);
    }

    private Statistics(Payment payment, List<Rank> winningResults) {
        this.results = upsertResults(winningResults);
        Long totalPrize = aggregateTotalPrice();
        this.profitRate = aggregateProfitRate(payment, totalPrize);
    }

    private Map<Rank, Integer> upsertResults(List<Rank> winningResults) {
        Map<Rank, Integer> initResults = initResults();

        winningResults.forEach(rank -> {
            initResults.merge(rank, 1, Integer::sum);
        });

        return initResults;
    }

    private Map<Rank, Integer> initResults() {
        Map<Rank, Integer> stats = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            stats.put(rank, 0);
        }
        return stats;
    }

    public Long aggregateTotalPrice() {
        return this.results.entrySet()
                .stream()
                .mapToLong(entry ->
                        entry.getKey().getPrizeMoney() * entry.getValue()
                )
                .sum();
    }

    private ProfitRate aggregateProfitRate(Payment payment, Long totalPrize) {
        Long paymentLongValue = payment.toLongValue();
        return ProfitRate.from(((double) totalPrize / paymentLongValue) * 100.0);
    }

    public ProfitRate getProfitRate() {
        return profitRate;
    }

    public Integer showCounts(Rank rank) {
        return results.get(rank);
    }
}
