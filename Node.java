package dp;

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
        List<Node<T>> nodes = new ArrayList<>();
        traverse(this, nodes);
        return nodes.iterator();
    }

    public void traverse(Node<T> currentNode, List<Node<T>> nodes) {
        nodes.add(currentNode);
        if(currentNode.left != null) {
            traverse(currentNode.left, nodes);
        }
        if(currentNode.right != null) {
            traverse(currentNode.right, nodes);
        }
    }
}
