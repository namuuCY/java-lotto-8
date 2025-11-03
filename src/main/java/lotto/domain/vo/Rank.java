package lotto.domain.vo;

public enum Rank {
    FIRST(2_000_000_000L, "6개 일치"),
    SECOND(30_000_000L, "5개 일치, 보너스 볼 일치"),
    THIRD(1_500_000L, "5개 일치"),
    FOURTH(50_000L, "4개 일치"),
    FIFTH(5_000L, "3개 일치"),
    MISS(0L, "낙첨"); // MISS도 설명을 가질 수 있음

    private final Long prizeMoney;
    private final String description; // 2. 필드 선언

    Rank(Long prizeMoney, String description) { // 3. 생성자 수정
        this.prizeMoney = prizeMoney;
        this.description = description;
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

    public String getDescription() {
        return description;
    }
}
