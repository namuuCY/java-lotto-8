package lotto.exception;

public class DomainException extends IllegalArgumentException {

    private static final String PREFIX = "[ERROR] ";

    public DomainException(ExceptionCode exceptionCode) {
        super(PREFIX + exceptionCode.getMessage());
    }
}
