import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class day1 {

    public void elfCalories_pt1() throws IOException {
        String file = "src/input/d1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int largestSum = 0;
        int currSum = 0;
        String currCal;

        while (true) {
            currCal = reader.readLine();
            if (currCal.equals("stop")) {
                break;
            }
            if (currCal.equals("")) {
                if (currSum > largestSum) {
                    largestSum = currSum;
                }
                currSum = 0;
                continue;
            }
            currSum = currSum + Integer.parseInt(currCal);
        }
        System.out.println("Day1_pt1 result: " + largestSum);
    }
    public void elfCalories_pt2() throws IOException {
        String file = "src/input/d1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int sumOfFirstThree = 0;
        int currSum = 0;
        String currCal;
        List<Integer> allSums = new ArrayList<>();

        while (true) {
            currCal = reader.readLine();
            if (currCal.equals("stop")) {
                break;
            }
            if (currCal.equals("")) {
                allSums.add(currSum);
                currSum = 0;
                continue;
            }
            currSum = currSum + Integer.parseInt(currCal);
        }
        Collections.sort(allSums);
        int firstLargestSum = allSums.get(allSums.size() - 1);
        int secondLargestSum = allSums.get(allSums.size() - 2);
        int thirdLargestSum = allSums.get(allSums.size() - 3);
        sumOfFirstThree = firstLargestSum + secondLargestSum + thirdLargestSum;
        System.out.println("Day1_pt2 result: " + sumOfFirstThree + "\n");
    }
}
