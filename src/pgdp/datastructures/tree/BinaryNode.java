package pgdp.datastructures.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryNode<T> extends Node<T> {

    public BinaryNode(T value) {
        super(value, null, null);
    }

    public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
        super(value, left, right);
    }

    public BinaryNode<T> getLeft() {
        return (BinaryNode<T>) getChild(0);
    }

    public BinaryNode<T> getRight() {
        return (BinaryNode<T>) getChild(1);
    }

    public void setLeft(BinaryNode<T> c) {
        setChild(0, c);
    }

    public void setRight(BinaryNode<T> c) {
        setChild(1, c);
    }
    /**
     * Returns a list containing the values of nodes starting from the root BinaryNode.
     *
     * @param order The list should return in the elements in this order.
     */
    @Override
    public List<T> toList(Order order) {
        List<T> result = new LinkedList<>();
        List<T> leftList = getLeft() != null ? getLeft().toList(order) : new LinkedList<>();
        List<T> rightList = getRight() != null ? getRight().toList(order) : new LinkedList<>();
        switch (order) {
            case IN -> {
                result.addAll(leftList);
                result.add(getValue());
                result.addAll(rightList);
            }
            case PRE -> {
                result.add(getValue());
                result.addAll(leftList);
                result.addAll(rightList);
            }
            case POST -> {
                result.addAll(leftList);
                result.addAll(rightList);
                result.add(getValue());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return toString(Order.IN);
    }

    /**
     * Returns a String representation of the node.
     *
     * @param order The elements should be returned in the given order.
     */
    public String toString(Order order) {
        if (isLeaf()) {
            return "[" + getValue() + "]";
        }
        String leftString = getLeft() != null ? getLeft().toString(order) : "-";
        String rightString = getRight() != null ? getRight().toString(order) : "-";
        return switch (order) {
            case IN -> "[" + leftString + ", " + getValue() + ", " + rightString + "]";
            case PRE -> "[" + getValue() + ", " + leftString + ", " + rightString + "]";
            case POST -> "[" + leftString + ", " + rightString + ", " + getValue() + "]";
        };
    }
}
