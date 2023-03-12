package cz.mawa.aoc13;

import java.util.List;

public class IntegerValue extends TreeNode {

    public Integer value;

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compareTo(TreeNode o) {
        if (o instanceof IntegerArray integerArray) {
            return new IntegerArray(this).compareTo(integerArray);
        } else if (o instanceof IntegerValue integerValue) {
            if (this.getValue().compareTo(integerValue.getValue()) == 1){
                return -1;
            } else if (this.getValue().compareTo(integerValue.getValue()) == 0){
                return 0;
            } else return 1;
        } else {
            throw new IllegalArgumentException("Cannot compare " + this + " with " + o);
        }
    }


    public IntegerValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
