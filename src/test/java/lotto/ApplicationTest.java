package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Test
    void 구입_금액_예외_처리_후_재시도_테스트() {
        assertSimpleTest(() -> {
            runException("1000j",   // [예외] 숫자가 아님
                    "1001",    // [예외] 1000원으로 나눠지지 않음
                    "500",     // [예외] 1000원 미만
                    "101000",  // [예외] 10만원 초과
                    "1000",    // [성공]
                    "1,2,3,4,5,6", // (이후 정상 진행)
                    "7");

            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "1개를 구매했습니다.", // <-- 재시도 후 성공 증거
                    "당첨 통계" // <-- 프로그램 끝까지 실행 증거
            );
        });
    }

    @Test
    void 당첨_번호_예외_처리_후_재시도_테스트() {
        assertSimpleTest(() -> {
            runException("1000", // (정상 구매)
                    "1,2,3,4,5",
                    "1,2,3,4,5,6,7",
                    "1,1,2,3,4,5",
                    "1,2,3,4,5,46",
                    "1,2,3,4,5,6",
                    "7");

            assertThat(output()).contains(
                    "1개를 구매했습니다.", // <-- 1단계 통과 증거
                    ERROR_MESSAGE,
                    "보너스 번호를 입력해 주세요." // <-- 재시도 후 성공 증거
            );
        });
    }
}
