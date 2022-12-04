import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class day4 {
    public void campCleanup_pt1_or_pt2(int whichPart) throws IOException {
        String file = "src/input/d4.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int sumOfSamePairs = 0;

        while (true) {
            String currLine = reader.readLine();
            if (currLine.equals("stop")) {
                break;
            }
            int halfSplit = currLine.indexOf(",");

            String firstPart = currLine.substring(0, halfSplit);
            String secondPart = currLine.substring(halfSplit + 1);

            List<Integer> firstInterval = getValuesFromInterval(firstPart);
            List<Integer> secondInterval = getValuesFromInterval(secondPart);

            if (whichPart == 1) {
                sumOfSamePairs += (firstInterval.containsAll(secondInterval) || secondInterval.containsAll(firstInterval)) ? 1 : 0;
            }
            if (whichPart == 2) {
                firstInterval.retainAll(secondInterval);
                if (!(firstInterval.size() == 0)) {
                    sumOfSamePairs += 1;
                }
            }
        }
        System.out.printf("Day4_pt%s result: %s\n", whichPart, sumOfSamePairs);
    }
    public static List<Integer> getValuesFromInterval(String interval) {
        int splitInterval = interval.indexOf("-");
        int startNumber = Integer.parseInt(interval.substring(0, splitInterval));
        int endNumber = Integer.parseInt(interval.substring(splitInterval + 1));

        List<Integer> numList = new ArrayList<>();
        if (startNumber == endNumber) {
            numList.add(startNumber);
            return numList;
        } else {
            for (int i = startNumber; i <= endNumber; i++) {
                numList.add(i);
            }
        }
        return numList;
    }
}
