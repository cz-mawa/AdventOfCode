package cz.mawa.aoc13;

public abstract class TreeNode implements Comparable<TreeNode> {

    protected TreeNode parent;

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
