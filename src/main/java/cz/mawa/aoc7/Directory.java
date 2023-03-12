package cz.mawa.aoc7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Directory extends TreeNode {

    public List<TreeNode> children = new ArrayList<>();
    private Long size;

    public Directory(String name) {
        super(name);
    }

    public Directory(String name, List<TreeNode> children) {
        super(name);
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

    public Directory getChild(String name) {

        for (TreeNode child : children) {
            if (child.getName().equals(name) && child instanceof Directory) {
                return (Directory) child;
            }
        }
        throw new IllegalArgumentException("No child with name " + name);
    }

    public Directory getParentDirectory() {
        return (Directory) parent;
    }

    @Override
    public Long getSize() {

        if (size == null) {
            size = children.stream()
                    .map(TreeNode::getSize)
                    .reduce(0L, Long::sum);
        }
        return size;
    }

    public static Stream<Directory> flat(Directory directory) {
        return Stream.concat(Stream.of(directory),
                directory
                        .getChildren()
                        .stream()
                        .filter(Directory.class::isInstance)
                        .map(Directory.class::cast)
                        .flatMap(Directory::flat));
    }
}
