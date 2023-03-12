package cz.mawa.aoc13;

public class IntegerValue extends TreeNode {

    public Integer value;

    public IntegerValue(Integer value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
