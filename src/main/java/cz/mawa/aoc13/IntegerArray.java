package cz.mawa.aoc13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerArray extends TreeNode {

    public List<TreeNode> children = new ArrayList<>();

    public IntegerArray() {
    }

    public IntegerArray(TreeNode... children) {
        this.children = Arrays.asList(children);
    }

    @Override
    public String toString() {
        return children.toString();
    }

    @Override
    public int compareTo(TreeNode object) {
        if (object instanceof IntegerArray integerArray) {
            /*if (this.children.size() > integerArray.children.size()) {
                return 1;
            }*/
                for (int i = 0; i < Math.min (this.children.size(), integerArray.children.size()); i++) {
                    if (this.children.get(i).compareTo(integerArray.children.get(i)) == 0) {
                        continue;
                    } else return this.children.get(i).compareTo(integerArray.children.get(i));
                }
            } else if (object instanceof IntegerValue integerValue) {
                return this.compareTo(new IntegerArray(integerValue));
            } else {
                throw new IllegalArgumentException("Cannot compare " + this + " with " + object);
            }
        return 0;
        }

    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChildren(List<TreeNode> children) {
        for (TreeNode child : children) {
            child.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public IntegerArray getParent() {
        return (IntegerArray) parent;
    }

}
