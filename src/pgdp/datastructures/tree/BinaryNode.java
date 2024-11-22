package pgdp.datastructures.tree;

import java.util.List;

public class BinaryNode<T> extends Node<T> {

    public BinaryNode() {
        // TODO 2.1: Implement the 1. constructor.
        super(null);
    }

    // TODO 2.1.1: Implement the 2. constructor. Implement getters & setters for left & right children.

    /**
     * Returns a list containing the values of nodes starting from the root BinaryNode.
     *
     * @param order The list should return in the elements in this order.
     */
    @Override
    public List<T> toList(Order order) {
        // TODO 2.2: Implement recursively.
        return null;
    }

    @Override
    public String toString() {
        // TODO 2.3: Should return a String representation of in-order traversal.
        return null;
    }

    /**
     * Returns a String representation of the node.
     *
     * @param order The elements should be returned in the given order.
     */
    public String toString(Order order) {
        // TODO 2.3.1: Implement recursively.
        return null;
    }
}
