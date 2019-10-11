package com.etoitau.designpatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Node<T>
{
    public T value;
    public Node<T> left, right, parent;

    public Node(T value)
    {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }

    public Iterator<Node<T>> preOrder()
    {
        return new PreOrderIterator<>(this);
    }


}

class PreOrderIterator<T> implements Iterator<Node<T>> {
    private Node<T> root, current;

    public PreOrderIterator(Node<T> root) {
        this.root = root;
        this.current = root;
    }

    private Node<T> nextNode(Node<T> from) {
        Node<T> cursor = from;

        Node<T> last = lastNode();
        if (cursor == last) { return null; }

        if (cursor.left != null) {
            // if can go left, go left
            return cursor.left;
        } else if (cursor.right != null) {
            // if cant' go left but can go right, go right
            return cursor.right;
        } else {
            // if no children
            // if at head with no children
            if (cursor.parent == null) { return null; }

            if (cursor == cursor.parent.left) {
                // if a left child, go up tree until head or first with right child
                while (cursor.parent != null) {
                    cursor = cursor.parent;
                    if (cursor.right != null) {
                        break;
                    }
                }
                // if head with no right, correctly returns null, else returns first right child above from
                return cursor.right;
            } else {
                // if a right child then go up tree until head or first with right child, skipping parent
                cursor = cursor.parent.parent;
                while (cursor.parent != null && cursor.parent.right == null) {
                    cursor = cursor.parent;
                }
                // if head with no right, correctly returns null, else returns first right child above from
                return cursor.right;
            }
        }
    }

    private Node<T> lastNode() {
        Node<T> cursor = root;
        while (cursor.left != null || cursor.right != null) {
            if (cursor.right != null) {
                cursor = cursor.right;
            } else {
                cursor = cursor.left;
            }
        }
        return cursor;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Node<T> next() {
        Node<T> toReturn = current;
        current = nextNode(current);
        return toReturn;
    }
}