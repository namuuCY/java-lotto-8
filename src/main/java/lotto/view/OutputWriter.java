package lotto.view;

import java.util.Map;
import lotto.controller.dto.PurchasedLotto;
import lotto.controller.dto.WinningStatistics;
import lotto.domain.vo.Rank;

public class OutputWriter {
    public void writePurchased(PurchasedLotto purchased) {
        Announcement announcement = Announcement.OUTPUT_COUNT;
        System.out.println(purchased.size() + announcement.getMessage());

        purchased.lottoBundles()
                .forEach(System.out::println);
    }

    public void writeStatistics(WinningStatistics statistics) {
        Announcement announcement = Announcement.OUTPUT_STATISTICS;
        System.out.println(announcement.getMessage());

        for (Map.Entry<Rank, Integer> entry : statistics.stats().entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();

            writeByRankAndCount(rank, count);
        }
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", statistics.profitRate());
    }

    private void writeByRankAndCount(Rank rank, Integer count) {
        System.out.printf("%s (%,d원) - %d개\n",
                rank.getDescription(),
                rank.getPrizeMoney(),
                count
        );
    }


    public void printError(String message) {
        System.out.println(message);
    }

}
