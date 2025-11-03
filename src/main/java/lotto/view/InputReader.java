package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 유효한 숫자 목록이어야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 유효한 숫자여야 합니다.");
        }
    }


}
