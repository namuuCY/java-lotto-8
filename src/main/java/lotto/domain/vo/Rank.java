package lotto.domain.vo;

public enum Rank {
    FIRST(2_000_000_000L),
    SECOND(30_000_000L),
    THIRD(1_500_000L),
    FOURTH(50_000L),
    FIFTH(5_000L),
    MISS(0L);

    private final Long prizeMoney;

    Rank(Long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(Integer matchCount, Boolean bonusMatch) {
        return classification(matchCount, bonusMatch);
    }

    private static Rank classification(Integer matchCount, Boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5) {
            return checkBonusMatched(bonusMatch);
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return MISS;
    }

    private static Rank checkBonusMatched(Boolean bonusMatch) {
        if (bonusMatch) {
            return SECOND;
        }
        return THIRD;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }
}
