package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day3 {

    public void rucksackReorganization_pt1() throws IOException {
        String file = "src/days/input/d3.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currLine;
        int sumItems = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        while (true) {
            currLine = reader.readLine();
            if (currLine.equals("stop")) {
                break;
            }
            int halfOfString = currLine.length() / 2;
            String firstPart = currLine.substring(0, halfOfString);
            String secondPart = currLine.substring(halfOfString);

            for (int i = 0; i < firstPart.length(); i++) {
                char sameItem = firstPart.charAt(i);
                if (secondPart.contains(String.valueOf(sameItem))) {
                    if (Character.isUpperCase(sameItem)) {
                        String upperCaseAlph = alphabet.toUpperCase();
                        int valuePosition = upperCaseAlph.indexOf(sameItem) + 1;
                        sumItems += valuePosition + 26;
                    } else {
                        int valuePosition = alphabet.indexOf(sameItem) + 1;
                        sumItems += valuePosition;
                    }
                    break;
                }
            }
        }
        System.out.println("Day3_pt1 result: " + sumItems);
    }
    public void rucksackReorganization_pt2() throws IOException {
        String file = "src/days/input/d3.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String firstLine, secondLine, thirdLine;
        int sumItems = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        while (true) {
            firstLine = reader.readLine();
            if (firstLine.equals("stop")) {
                break;
            }
            secondLine = reader.readLine();
            thirdLine = reader.readLine();

            for (int i = 0; i < firstLine.length(); i++) {
                char currWord = firstLine.charAt(i);
                if (secondLine.contains(String.valueOf(currWord)) && thirdLine.contains(String.valueOf(currWord))) {
                    if (Character.isUpperCase(currWord)) {
                        String upperCaseAlph = alphabet.toUpperCase();
                        int valuePosition = upperCaseAlph.indexOf(currWord) + 1;
                        sumItems += valuePosition + 26;
                    } else {
                        int valuePosition = alphabet.indexOf(currWord) + 1;
                        sumItems += valuePosition;
                    }
                    break;
                }
            }
        }
        System.out.println("Day3_pt2 result: " + sumItems + "\n");
    }
}