package lotto.exception;

public class DomainException extends IllegalArgumentException {

    public DomainException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }
}
