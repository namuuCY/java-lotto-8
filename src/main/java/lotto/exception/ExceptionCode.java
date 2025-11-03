package lotto.exception;

public enum ExceptionCode {
    TEST("예외 테스트용 메세지 입니다."),
    LOTTO_NUMBERS_NOT_ASCENDING("로또 숫자가 오름차순이 아닙니다."),
    LOTTO_NUMBERS_DUPLICATED("로또 숫자중에 중복된 숫자가 존재합니다."),
    NOT_ENOUGH_LOTTO_NUMBERS("로또 번호는 6개여야 합니다."),
    OUT_OF_BOUND_NUMBER("로또 숫자는 1 이상 45 이하여야 합니다."),
    BONUS_NUMBER_DUPLICATED("보너스 숫자가 로또 숫자와 중복되고 있습니다."),
    PROFIT_RATE_INVALID("수익률은 0 이상의 double 값이어야 합니다."),
    OUT_OF_BOUND_MONEY("구입 액수는 1000 이상 100000 이하여야 합니다."),
    INVALID_MONEY_INPUT("구입 액수는 1000의 배수여야 합니다."),
    UNEXPECTED_ERROR("예상치 못한 에러입니다. 로직을 확인해주세요"),
    INVALID_MONEY_INPUT_TYPE("액수의 입력 값은 숫자여야 합니다."),
    INVALID_INPUT_DELIMITER("당첨 번호는 쉼표로 구분된 유효한 숫자 목록이어야 합니다."),
    INVALID_INPUT_BONUS_NUMBER("보너스 번호는 유효한 숫자여야 합니다.");

    private final String message;

    public String getMessage() {
        return message;
    }

    ExceptionCode(String message) {
        this.message = message;
    }
}
