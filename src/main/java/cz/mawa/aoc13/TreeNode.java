package cz.mawa.aoc13;

public abstract class TreeNode {

    protected Integer index;
    protected TreeNode parent;

    public TreeNode() {
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
