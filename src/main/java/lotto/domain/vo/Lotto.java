package lotto.domain.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DomainException;
import lotto.exception.ExceptionCode;

// 이 클래스를 사용해야 한다.
public class Lotto {
    // 아래 필드의 접근제어자는 private 이어야 하며, 이 필드 이외의 필드가 있어서는 안된다.
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = sortAscend(numbers);
        this.numbers = sortedNumbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateCombination(numbers);
        validateElements(numbers);
    }

    // TODO: 추가 기능 구현

    private void validateCombination(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    private List<Integer> sortAscend(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }


    private void validateDuplicate(List<Integer> numbers) {
        Integer numbersSize = numbers.size();
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        Integer distinctNumbersSize = distinctNumbers.size();
        judgeDuplicate(numbersSize, distinctNumbersSize);
    }

    private void judgeDuplicate(Integer numbersSize, Integer distinctNumbersSize) {
        if (numbersSize.equals(distinctNumbersSize)) {
            return;
        }
        throw new DomainException(ExceptionCode.LOTTO_NUMBERS_DUPLICATED);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() == 6) {
            return;
        }
        throw new DomainException(ExceptionCode.NOT_ENOUGH_LOTTO_NUMBERS);
    }


    private void validateElements(List<Integer> numbers) {
        numbers.forEach(this::checkOutOfBound);
    }

    private void checkOutOfBound(Integer number) {
        if (number >= 1 && number <= 45) {
            return;
        }
        throw new DomainException(ExceptionCode.OUT_OF_BOUND_NUMBER);
    }

    public Boolean isIncluding(Integer target) {
        return numbers.stream()
                .anyMatch(number -> number.equals(target));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
