package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.DomainException;
import lotto.exception.ExceptionCode;

public class InputReader {

    public Integer readMoney() {
        getMoneyAnnouncement(Announcement.INPUT_MONEY);
        String rawInput = Console.readLine();
        return convertRawInput(rawInput);
    }

    private void getMoneyAnnouncement(Announcement announcement) {
        String message = announcement.getMessage();
        System.out.println(message);
    }

    private Integer convertRawInput(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new DomainException(ExceptionCode.INVALID_MONEY_INPUT_TYPE);
        }
    }


    public List<Integer> readCombination() {
        getMoneyAnnouncement(Announcement.INPUT_COMBINATION);
        String rawInput = Console.readLine();
        return convertCombinationInput(rawInput);
    }

    private List<Integer> convertCombinationInput(String rawInput) {
        try {
            return getCollect(rawInput);
        } catch (NumberFormatException e) {
            throw new DomainException(ExceptionCode.INVALID_INPUT_DELIMITER);
        }
    }

    private List<Integer> getCollect(String rawInput) {
        return Arrays.stream(rawInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer readBonusNumber() {
        getMoneyAnnouncement(Announcement.INPUT_BONUS_NUMBER);
        String rawInput = Console.readLine();
        return convertBonusInput(rawInput);
    }

    private Integer convertBonusInput(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new DomainException(ExceptionCode.INVALID_INPUT_BONUS_NUMBER);
        }
    }


}
