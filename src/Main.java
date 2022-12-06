import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        day1 d1 = new day1();
        d1.elfCalories_pt1();
        d1.elfCalories_pt2();

        day2 d2 = new day2();
        d2.elfRockPaperScissors_pt1();
        d2.elfRockPaperScissors_pt2();

        day3 d3 = new day3();
        d3.rucksackReorganization_pt1();
        d3.rucksackReorganization_pt2();

        day4 d4 = new day4();
        d4.campCleanup_pt1_or_pt2(1);
        d4.campCleanup_pt1_or_pt2(2);

        day5 d5 = new day5();
        d5.supplyStacks_pt1_or_pt2(1);
        d5.supplyStacks_pt1_or_pt2(2);

        day6 d6 = new day6();
        d6.tuningTrouble_pt1_or_pt2(1);
        d6.tuningTrouble_pt1_or_pt2(2);

    }

}