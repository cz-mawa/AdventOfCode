package cz.mawa.aoc7;

public class DataParser {

    private Directory currentDirectory;
    private final Directory rootDirectory = new Directory("root");

    private void cd_in(Directory directory) {

        currentDirectory = directory;

    }

    private void cd_out() {

        if (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParentDirectory();
        }
    }

    private void cd_root() {

        currentDirectory = rootDirectory;
    }

    private void ls(String data) {

        String[] lines = data.split("\\R");
        for (String line : lines) {
            String[] descriptor = line.split(" ");
            if (descriptor[0].equals("dir")) {
                currentDirectory.addChild(new Directory(descriptor[1]));
            } else {
                currentDirectory.addChild(new File(descriptor[1], Long.parseLong(descriptor[0])));
            }
        }
    }

    public void parse(String data) {

        String[] lines = data.split("\\$");
        for (String line : lines) {
            String[] command = line.split(" ");
            if (command[0].equals("cd")) {
                if (command[1].equals("..")) {
                    cd_out();
                } else if (command[1].equals("/")) {
                    cd_root();
                } else {
                    cd_in(currentDirectory);
                }
            } else {
                ls(line.substring(5));
            }

        }
    }

    public Long result(Long limit) {

        return Directory.flat(rootDirectory)
                .map(Directory::getSize)
                .filter(size -> size <= limit)
                .reduce(Long::sum)
                .orElse(0L);
    }
}

