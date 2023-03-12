package cz.mawa.aoc13;

import java.util.List;

public class DataParser {

    public String pair1;
    public String pair2;

    public List<Integer> list1;
    public List<Integer> list2;

    private IntegerArray currentArray;
    private final IntegerArray root = new IntegerArray("root");

    private void cd_root() {

        currentArray = root;
    }

    public void parse(String data) {

        String[] pairs = data.split("\\n\\n");
        for (String pair : pairs) {
            String[] packet = pair.split("\\n");
            for (String line : packet) {

            }
            if (packet[0].startsWith("[")) {
                /*create new IntegerArray*/
            } else if (packet[0].charAt().isDigit()){
                /*create new IntegerValue*/
            }
        }

    }
}
