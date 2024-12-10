package pgdp.datastructures.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryNode<T> extends Node<T> {

    public BinaryNode(T value) {
        super(value, null, null);
    }

    // TODO 2.1.1: Implement the 2. constructor. Implement getters & setters for left & right children.

    public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
        super(value, left, right);
    }

    public Node<T> getLeft() {
        return getChild(0);
    }

    public Node<T> getRight() {
        return getChild(1);
    }

    public void setLeft(Node<T> c) {
        setChild(0, c);
    }

    public void setRight(Node<T> c) {
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
                result.add(this.getValue());
                result.addAll(rightList);
            }
            case PRE -> {
                result.add(this.getValue());
                result.addAll(leftList);
                result.addAll(rightList);
            }
            case POST -> {
                result.addAll(leftList);
                result.addAll(rightList);
                result.add(this.getValue());
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
        String leftString = getLeft() != null ? getLeft().toString() : "-";
        String rightString = getRight() != null ? getRight().toString() : "-";
        return switch (order) {
            case IN -> "[" + leftString + ", " + getValue() + ", " + rightString + "]";
            case PRE -> "[" + getValue() + ", " + leftString + ", " + rightString + "]";
            case POST -> "[" + leftString + ", " + rightString + ", " + getValue() + "]";
        };
    }
}
