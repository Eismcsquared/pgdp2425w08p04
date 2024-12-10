package pgdp.datastructures.tree;

public class BSTNode<T extends Comparable<T>> extends BinaryNode<T> {
    public BSTNode(T value) {
        super(value);
    }

    public BSTNode(T value, BSTNode<T> left, BSTNode<T> right) {
        super(value, left, right);
    }


    /**
     * Compares the given value to the tree's nodes and inserts it in the correct position.
     *
     * @param value The value to be inserted to the tree.
     */
    public void insert(T value) {
        if (value.compareTo(getValue()) < 0) {
            if (getLeft() == null) {
                setLeft(new BinaryNode<>(value));
            } else {
                ((BSTNode<T>) getLeft()).insert(value);
            }
        } else if (value.compareTo(getValue()) > 0) {
            if (getRight() == null) {
                setRight(new BinaryNode<>(value));
            } else {
                ((BSTNode<T>) getRight()).insert(value);
            }
        }
    }


    /**
     * @param value The value to be checked for existence in the tree.
     * @return true if the value is found, false otherwise.
     */
    public boolean contains(T value) {
        if (value.compareTo(getValue()) == 0) {
            return true;
        }
        if (value.compareTo(getValue()) < 0) {
            if (getLeft() == null) {
                return false;
            }
            return ((BSTNode<T>) getLeft()).contains(value);
        } else {
            if (getRight() == null) {
                return false;
            }
            return ((BSTNode<T>) getRight()).contains(value);
        }
    }

}
