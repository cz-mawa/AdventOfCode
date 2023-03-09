package cz.mawa;

import java.util.ArrayList;
import java.util.List;

public class AoC7Directory extends AoC7TreeNode{

    public List<AoC7TreeNode> children = new ArrayList<>();

    public void addChild(AoC7TreeNode child) {

        child.setParent(this);
        this.children.add(child);
    }

    public void addChildren(List<AoC7TreeNode> children) {
        for (AoC7TreeNode item : children) {
            item.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<AoC7TreeNode> getChildren() {
        return children;
    }
}
