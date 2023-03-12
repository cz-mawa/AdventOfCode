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
    public int compareTo(TreeNode o) {
        if (o instanceof IntegerArray integerArray) {
            for (int i = 0; i < this.children.size(); i++) {
                if (this.children.get(i).compareTo(integerArray.children.get(i)) == 0) {
                    continue;
                }
                else return this.children.get(i).compareTo(integerArray.children.get(i));
            }
            if (this.children.size() > integerArray.children.size()) {
                return 1;
            }
            return 0;
        } else if (o instanceof IntegerValue integerValue) {
            return this.compareTo(new IntegerArray(integerValue));
        } else {
            throw new IllegalArgumentException("Cannot compare " + this + " with " + o);
        }

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

    public IntegerArray getParentDirectory() {
        return (IntegerArray) parent;
    }

   /* public Long getSize() {

        if (size == null) {
            size = children.stream()
                    .map(TreeNode::getSize)
                    .reduce(0L, Long::sum);
        }
        return size;

    }*/

    /*public static Stream<IntegerArray> flat(IntegerArray array) {
        return Stream.concat(Stream.of(array),
                array
                        .getChildren()
                        .stream()
                        .filter(Array.class::isInstance)
                        .map (Array.class::cast)
                        .flatMap(IntegerArray::flat));
    }*/
}
