package cz.mawa.aoc13;

public class DataParser {

    public DataParser() {
    }

    public int process(String data) {

        String[] pairs = data.split("\\n\\n");
        Integer sumOfIndexes = 0;
        Integer currentIndex = 1;
        for (String pair : pairs) {
            if (parsePair(pair) < 0) {
                sumOfIndexes += currentIndex; }
            currentIndex++;
        }
        return sumOfIndexes;
    }

    public int parsePair(String pair) {
        String[] packet = pair.split("\\n");
        return parsePacket(packet[0]).compareTo(parsePacket(packet[1]));
    }

    public IntegerArray parsePacket(String line) {
        String[] blob = line.split("((?<!\\d)|(?!\\d))");
        IntegerArray root = new IntegerArray();
        IntegerArray current = root;
        for (String character : blob) {
            if (character.equals("[")) {
                IntegerArray newNode = new IntegerArray();
                current.addChild(newNode);
                current = newNode;
            } else if (character.equals("]")) {
                current = current.getParent();
            } else if (character.equals(",")) { continue;
            } else {
                String[] numbers = character.split(",");
                for (String number : numbers) {
                    current.children.add(new IntegerValue(Integer.valueOf(number)));
                }
            }
        }
        return root;
    }
}
