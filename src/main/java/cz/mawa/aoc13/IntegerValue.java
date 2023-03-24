package cz.mawa.aoc13;

public class IntegerValue extends TreeNode {

    public Integer value;

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compareTo(TreeNode object) {
        if (object instanceof IntegerArray integerArray) {
            return new IntegerArray(this).compareTo(integerArray);
        } else if (object instanceof IntegerValue integerValue) {
            /*return integerValue.getValue().compareTo(this.getValue());*/
            return this.getValue().compareTo(integerValue.getValue());
        } else {
            throw new IllegalArgumentException("Cannot compare " + this + " with " + object);
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
