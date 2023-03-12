package cz.mawa.aoc13;

public class DataParser {
    private Integer indexes;
    private final IntegerArray root = new IntegerArray();

    public DataParser() {
        indexes = 0;
    }

    public void parseData(String data) {

        String[] pairs = data.split("\\n\\n");
        for (String pair : pairs) {
            parsePair(pair);
        }

    }

    public void parsePair(String pair) {
        String[] packet = pair.split("\\n");
        for (String line : packet) {
            parseLine(line);
        }
    }

    public void parseLine(String line) {
        if (line.startsWith("[") && line.chars().filter(c -> c == '[').count() == 1) {
            // to do
            TreeNode node = new IntegerArray();
            line = line.substring(1, line.length() - 1);
            String[] parts = line.split(",");
        } else if (line.startsWith("[") && line.chars().filter(c -> c == '[').count() > 1) {
            // to do
        } else if (Character.isDigit(line.charAt(0)) && line.chars().filter(c -> c == '[').count() == 0) {
            // to do
        }
    }

}
