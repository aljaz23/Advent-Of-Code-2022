import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class day6 {
    public void tuningTrouble_pt1_or_pt2(int whichPart) throws IOException {
        String file = "src/input/d6.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int condition = 0;

        if (whichPart == 1) {
            condition = 4;
        }
        if (whichPart == 2) {
            condition = 14;
        }
        while (true) {
            String currLine = reader.readLine();
            if (currLine.equals("stop")) {
                break;
            }
            int countChar = 0;
            String compare = "";
            int index = 0;

            for (int i = 0; i < currLine.length(); i++) {
                String currChar = String.valueOf(currLine.charAt(i));
                if (countChar == condition) {
                    int result = index;
                    System.out.printf("Day6_pt%s result: %s\n", whichPart, result);
                    break;
                }
                if (!compare.contains(currChar)) {
                    compare = compare + currChar;
                    countChar++;
                    index++;
                } else {
                    for (int j = 0; j < compare.length() + 2; j++) {
                        if (compare.contains(currChar)) {
                            compare = compare.substring(1);
                            countChar -= 1;
                        }
                    }
                    index++;
                    countChar++;
                    compare = compare + currChar;
                }
            }
        }
    }
}