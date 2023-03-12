package cz.mawa.aoc7;

public class File extends TreeNode {

    public Long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public Long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
