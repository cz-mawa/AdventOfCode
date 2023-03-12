package cz.mawa.aoc13;

import java.util.ArrayList;
import java.util.List;

public class IntegerArray extends TreeNode {

    public List<TreeNode> children = new ArrayList<>();

    public List<Integer> values = new ArrayList<>();

    public IntegerArray(List<Integer> values) {
        this.values = values;
    }

    public IntegerArray() {
    }

    public IntegerArray(List<Integer> values, List<TreeNode> children) {
        this.values = values;
        this.children = children;
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
