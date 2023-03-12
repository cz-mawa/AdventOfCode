package cz.mawa.aoc7;

public abstract class TreeNode {

    protected String name;
    protected TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(String name) {
        this.name = name;
    }

    public TreeNode getNode() {
        return this;
    }

    public void setNode(String name) {
        this.name = name;
    }

    protected void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }

    public abstract Long getSize();
}