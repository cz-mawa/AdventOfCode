package cz.mawa.aoc13;

public abstract class TreeNode {

    private static Integer indexStart = 0;

    protected Integer index;
    protected TreeNode parent;

    public TreeNode() {
        index = indexStart++;
    }

    public TreeNode getNode() {
        return this;
    }

    protected void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }

}
