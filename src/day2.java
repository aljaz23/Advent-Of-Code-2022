import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2 {

    public void elfRockPaperScissors_pt1() throws IOException {
        String file = "src/input/d2.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currLine;
        int totalScore = 0;
        while (true) {
            currLine = reader.readLine();
            if (currLine.equals("stop")) {
                System.out.println("Day2_pt1 result: " + totalScore);
                break;
            }
            char elfsTurn = currLine.charAt(0);
            char myTurn = currLine.charAt(2);

            if (myTurn == 'X') {
                totalScore += 1;
            }
            if (myTurn == 'Y') {
                totalScore += 2;
            }
            if (myTurn == 'Z') {
                totalScore += 3;
            }
            if (elfsTurn == 'A') {
                if (myTurn == 'X') {
                    totalScore += 3;
                } else if (myTurn == 'Y') {
                    totalScore += 6;
                }
            } else if (elfsTurn == 'B') {
                if (myTurn == 'Y') {
                    totalScore += 3;
                } else if (myTurn == 'Z') {
                    totalScore += 6;
                }
            } else if (elfsTurn == 'C') {
                if (myTurn == 'Z') {
                    totalScore += 3;
                } else if (myTurn == 'X') {
                    totalScore += 6;
                }
            }
        }
    }

    public void elfRockPaperScissors_pt2() throws IOException {
        String file = "src/input/d2.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currLine;
        int totalScore = 0;
        while (true) {
            currLine = reader.readLine();
            if (currLine.equals("stop")) {
                System.out.println("Day2_pt2 result: " + totalScore + "\n");
                break;
            }
            char elfsTurn = currLine.charAt(0);
            char myTurn = currLine.charAt(2);

            if (elfsTurn == 'A') {
                if (myTurn == 'Y') {
                    totalScore += 3 + 1;
                } else if (myTurn == 'Z') {
                    totalScore += 6 + 2;
                } else {
                    totalScore += 3;
                }
            } else if (elfsTurn == 'B') {
                if (myTurn == 'Y') {
                    totalScore += 3 + 2;
                } else if (myTurn == 'Z') {
                    totalScore += 6 + 3;
                } else {
                    totalScore += 1;
                }
            } else if (elfsTurn == 'C') {
                if (myTurn == 'Y') {
                    totalScore += 3 + 3;
                } else if (myTurn == 'Z') {
                    totalScore += 6 + 1;
                } else {
                    totalScore += 2;
                }
            }

        }
    }
}

