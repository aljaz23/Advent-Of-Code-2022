import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day5 {
    public void supplyStacks_pt1_or_pt2(int whichPart) throws IOException {
        String file = "src/input/d5.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<String> cargoList = new ArrayList<>();
        cargoList.add("RSLFQ");
        cargoList.add("NZQGPT");
        cargoList.add("SMQB");
        cargoList.add("TGZJHCBQ");
        cargoList.add("PHMBNFS");
        cargoList.add("PCQNSLVG");
        cargoList.add("WCF");
        cargoList.add("QHGZWVPM");
        cargoList.add("GZDLCNR");

        /*
        List<String> cargoList = new ArrayList<>();
        cargoList.add("ZN");
        cargoList.add("MCD");
        cargoList.add("P");
        */

        while (true) {
            String currLine = reader.readLine();
            if (currLine.equals("stop")) {
                String message = displayMessage(cargoList);
                System.out.printf("Day5_pt%s result: %s\n", whichPart, message);
                break;
            }
            // move 1 from 2 to 1
            List<Integer> positions = CargoPositions(currLine);
            int howManyCargosToMove = positions.get(0);
            int fromWhichPosition = positions.get(1) - 1;
            int endPosition = positions.get(2) - 1;

            if (whichPart == 1) {
                cargoManipulation_pt1(cargoList, howManyCargosToMove, fromWhichPosition, endPosition);
            }
            if (whichPart == 2) {
                cargoManipulation_pt2(cargoList, howManyCargosToMove, fromWhichPosition, endPosition);
            }
        }
    }
    public static List<Integer> CargoPositions(String line) {
        List<Integer> positionList = new ArrayList<>();

        int beginIndexFirstNum = line.indexOf("e") + 2;
        int endIndexFirstNum = line.indexOf("f") - 1;
        int firstNumber = Integer.parseInt(line.substring(beginIndexFirstNum, endIndexFirstNum));
        positionList.add(firstNumber);

        int beginIndexSecondNum = line.lastIndexOf("m") + 2;
        int endIndexSecondNum = line.indexOf("t") - 1;
        int secondNumber = Integer.parseInt(line.substring(beginIndexSecondNum, endIndexSecondNum));
        positionList.add(secondNumber);

        int beginIndexThirdNum = line.indexOf("t") + 3;
        int endIndexThirdNum = line.length();
        int thirdNumber = Integer.parseInt(line.substring(beginIndexThirdNum, endIndexThirdNum));
        positionList.add(thirdNumber);

        return positionList;
    }

    public static String displayMessage(List<String> list) {
        String message = "";
        for (int i = 0; i < list.size(); i++) {
            String cargoOnTop = String.valueOf(list.get(i).charAt(list.get(i).length() - 1));
            message = message + cargoOnTop;
        }
        return message;
    }
    public static void cargoManipulation_pt1(List<String> cargoList, int howManyCargosToMove, int fromWhichPosition, int endPosition) {
        String currCargo = cargoList.get(fromWhichPosition);
        for (int i = 0; i < howManyCargosToMove; i++) {
            if (i < howManyCargosToMove) {
                String cargoToReplace = String.valueOf(currCargo.charAt(currCargo.length() - 1));
                currCargo = currCargo.substring(0, currCargo.length() - 1);
                cargoList.set(fromWhichPosition, currCargo);

                String endPositionCargo = cargoList.get(endPosition);
                endPositionCargo = endPositionCargo + cargoToReplace;
                cargoList.set(endPosition, endPositionCargo);
            }
        }
    }
    public static void cargoManipulation_pt2(List<String> cargoList, int howManyCargosToMove, int fromWhichPosition, int endPosition) {
        String currCargo = cargoList.get(fromWhichPosition);
        for (int i = 0; i < 1; i++) {
            String cargoToReplace = currCargo.substring(currCargo.length() - howManyCargosToMove);
            currCargo = currCargo.substring(0, currCargo.length() - howManyCargosToMove);
            cargoList.set(fromWhichPosition, currCargo);

            String endPositionCargo = cargoList.get(endPosition);
            endPositionCargo = endPositionCargo + cargoToReplace;
            cargoList.set(endPosition, endPositionCargo);
        }
    }
}