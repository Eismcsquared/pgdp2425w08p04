package pgdp.datastructures.tree;

import java.util.List;

public abstract class Node<T> {

    private T value;
    private Node<T>[] children;

    @SafeVarargs
    public Node(T value, Node<T>... nodes) {
        this.value = value;
        children = nodes;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public Node<T>[] getChildren() {
        return children;
    }

    public Node<T> getChild(int i) {
        if (i < 0 || i >= children.length) {
            return null;
        }
        return children[i];
    }

    public void setChild(int i, Node<T> c) {
        if (i >= 0 && i < children.length) {
            children[i] = c;
        }
    }

    public boolean isLeaf() {
        for (Node<T> c: children) {
            if (c != null) {
                return false;
            }
        }
        return true;
    }
    public int height() {
        int maxChildHeight = 0;
        for (Node<T> c: children) {
            if (c != null) {
                if (c.height() > maxChildHeight) {
                    maxChildHeight = c.height();
                }
            }
        }
        return maxChildHeight + 1;
    }

    public int size() {
        int size = 1;
        for (Node<T> c: children) {
            if (c != null) {
                size += c.size();
            }
        }
        return size;
    }

    public abstract List<T> toList(Order order);
}
