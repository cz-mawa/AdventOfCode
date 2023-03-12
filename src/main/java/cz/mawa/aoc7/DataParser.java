package cz.mawa.aoc7;

public class DataParser {

    private final Directory rootDirectory = new Directory("root");

    private Directory currentDirectory = rootDirectory;

    private void cd_in(String name) {

        currentDirectory = currentDirectory.getChild(name);

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
            if (descriptor.equals("")) continue;
            if (descriptor[0].equals("dir")) {
                currentDirectory.addChild(new Directory(descriptor[1]));
            } else {
                currentDirectory.addChild(new File(descriptor[1], Long.parseLong(descriptor[0])));
            }
        }
    }

    public void parse(String data) {

        String[] lines = data.split("\\$ ");
        for (String line : lines) {
            if (line.equals("")) continue;
            line = line.strip();
            if (line.startsWith("cd")) {
                String[] command = line.split(" ");
                if (command[1].equals("..")) {
                    cd_out();
                } else if (command[1].startsWith("/")) {
                    cd_root();
                } else {
                    cd_in(command[1]);
                }
            } else {
                ls(line.substring(3));
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

