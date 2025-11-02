package lotto.exception;

public enum ExceptionCode {
    TEST("예외 테스트용 메세지 입니다."),
    LOTTO_NUMBERS_NOT_ASCENDING("로또 숫자가 오름차순이 아닙니다."),
    LOTTO_NUMBERS_DUPLICATED("로또 숫자중에 중복된 숫자가 존재합니다."),
    NOT_ENOUGH_LOTTO_NUMBERS("로또 번호는 6개여야 합니다."),
    OUT_OF_BOUND_NUMBER("로또 숫자는 1 이상 45 이하여야 합니다."),
    BONUS_NUMBER_DUPLICATED("보너스 숫자가 로또 숫자와 중복되고 있습니다.");

    private final String message;

    public String getMessage() {
        return message;
    }

    ExceptionCode(String message) {
        this.message = message;
    }
}
