package lotto.view;

public enum Announcement {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    OUTPUT_COUNT("개를 구매했습니다."),
    INPUT_COMBINATION("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_STATISTICS("당첨 통계\n---");

    private final String message;

    Announcement(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
