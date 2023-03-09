package cz.mawa;

public class AoC7TreeNode {

    protected String name;
    protected AoC7TreeNode parent;

    public AoC7TreeNode() {}

    public AoC7TreeNode(String name) {
        this.name = name;
    }

    public AoC7TreeNode getNode() {
        return this;
    }

    public void setNode(String name) {
        this.name = name;
    }

    protected void setParent(AoC7TreeNode parent) {
        this.parent = parent;
    }

    public AoC7TreeNode getParent() {
        return parent;
    }
}