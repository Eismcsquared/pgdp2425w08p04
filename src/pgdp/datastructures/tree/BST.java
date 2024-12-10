package pgdp.datastructures.tree;

import java.util.LinkedList;
import java.util.List;

public class BST<T extends Comparable<T>> {

    private BSTNode<T> root;


    /**
     * Checks if the binary search tree is empty.
     *
     * @return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns the total number of nodes in the binary search tree.
     *
     * @return the size of the tree.
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return root.size();
    }


    /**
     * Checks if the given value is present in the tree.
     *
     * @param value The value to search for in the tree.
     * @return true if the value is found, false otherwise.
     */
    public boolean contains(T value) {
        if (isEmpty()) {
            return false;
        }
        return root.contains(value);
    }

    /**
     * Inserts the given value into the binary search tree, following the BST property.
     *
     * @param value The value to insert into the tree.
     */
    public void insert(T value) {
        if (isEmpty()) {
            root = new BSTNode<>(value);
        } else {
            root.insert(value);
        }
    }

    /**
     * Returns a list of all the values in the tree in sorted (in-order) order.
     *
     * @return a list of tree values in sorted order.
     */
    public List<T> toList() {
        if (isEmpty()) {
            return new LinkedList<>();
        }
        return root.toList(Order.IN);
    }


    /**
     * Returns a string representation of the tree, in-order.
     *
     * @return a string representing the tree.
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        return root.toString();
    }
}
