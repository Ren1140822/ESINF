package BST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//#########################################################################
/**
 *
 * @author DEI-ESINF
 */
/*
public interface:

public BST()
public boolean isEmpty()
public int size()
public void insert(E element)
public void remove(E element)
public String toString()

public int height()
public smallestElement()
public Iterable<E> inOrder()
public Iterable<E> preOrder()
public Iterable<E> posOrder()
public Map<Integer,List<E>> nodesByLevel(){

 */
public class BST<E extends Comparable<E>> {

    /**
     * The root of the binary search tree
     */
    protected Node<E> root = null;     // root of the tree

    /**
     * Constructs an empty binary search tree.
     */
    public BST() {    // constructs an empty binary search tree
        root = null;
    }
//****************************************************************

    /**
     * Returns the root Node of the tree (or null if tree is empty).
     *
     * @return root Node of the tree (or null if tree is empty)
     */
    protected Node<E> root() {
        return root;
    }
//****************************************************************

    /**
     * Verifies if the tree is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }
//****************************************************************

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes in the tree
     */
    public int size() {
        return size(root);
    }

    private int size(Node<E> node) {
        if (node == null) {
            return 0;
        }
        int cont = 1;
        Node<E> esquerda = node.getLeft();
        if (esquerda != null) {
            cont += size(esquerda);
        }
        Node<E> direita = node.getRight();
        if (direita != null) {
            cont += size(direita);
        }
        return cont;

    }
//*************************************************************--

    public void insert(E element) {
        root = insert(element, root);
    }

    private Node<E> insert(E element, Node<E> node) {
        if (node == null) {
            node = new Node(element, null, null);
            return node;
        }
        //Node<E> novoNode = new Node(element, null, null);
        int comp = node.getElement().compareTo(element);
        //  comp = element - node.getElement(),
        if (comp > 0) {
            node.setLeft(insert(element, node.getLeft()));
        } else if (comp < 0) {
            node.setRight(insert(element, node.getRight()));
        } else {
            node.setElement(element);
        }
        return node;
    }
//****************************************************************

    /**
     * Removes an element from the tree maintaining its consistency as a Binary
     * Search Tree.
     *
     * @param element
     */
    public void remove(E element) {
        root = remove(element, root());
    }

    private Node<E> remove(E element, Node<E> node) {
        if (node == null) {
            return null;
        }
        if (node.getElement() == element) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            E min = smallestElement(node.getRight());
            node.setElement(min);
            node.setRight(remove(min, node.getRight()));
        } else if (node.getElement().compareTo(element) > 0) {
            node.setLeft(remove(element, node.getLeft()));
        } else {
            node.setRight(remove(element, node.getRight()));
        }
        return node;
    }

//****************************************************************
    /**
     * Returns the smallest element within the tree.
     *
     * @return the smallest element within the tree
     */
    public E smallestElement() {
        return smallestElement(root);
    }

    protected E smallestElement(Node<E> node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() != null) {
            return smallestElement(node.getLeft());
        } else {
            return node.getElement();
        }
    }
    //****************************************************************

    /**
     * Returns a map with a list of nodes by each tree level.
     *
     * @return a map with a list of nodes by each tree level
     */
    public Map<Integer, List<E>> nodesByLevel() {
        Map<Integer, List<E>> resultado = new HashMap<>();
        if(height()<-1) return null;
        for (int i = 0; i <= height(); i++) {
            List<E> nivel = new ArrayList<>();
            resultado.put(i, nivel);
        }
        processBstByLevel(root, resultado, 0);
        return resultado;
    }

    private void processBstByLevel(Node<E> node, Map<Integer, List<E>> result, int level) {
        if (level == 0) {
            if (node == null) {
                return;
            }
            result.get(level).add(node.getElement());
        }
        else{
        List<E> prevLevel = result.get(level - 1);
        List<E> actualLevel = result.get(level);
        for (E e : prevLevel) {
            Node<E> no = find(e, node);
            Node<E> leftNode = no.getLeft();
            Node<E> rightNode = no.getRight();
            if (leftNode != null) {
                actualLevel.add(leftNode.getElement());
            }
            if (rightNode != null) {
                actualLevel.add(rightNode.getElement());
            }

        }
        }
        if (level < height()) {
            processBstByLevel(node, result, level + 1);
        }
    }
    //---------------------------------------------------------------   

    /**
     * Returns the height of the tree
     *
     * @return
     */
    public int height() {
        return height(root);
    }

    /**
     * Returns the height of the subtree rooted at Node node.
     *
     * @param node A valid Node within the tree
     * @return
     */
    protected int height(Node<E> node) {
        if (node == null) {
            return -1;
        }
        int alturaEsquerda = height(node.getLeft());
        int alturaDireita = height(node.getRight());

        if (alturaEsquerda == -1 && alturaDireita == -1) {
            return 0;
        }
        if (alturaEsquerda > alturaDireita) {
            return alturaEsquerda + 1;
        } else {
            return alturaDireita + 1;
        }

    }

//****************************************************************
    /**
     * Returns the Node containing a specific Element, or null otherwise.
     *
     * @param element the element to find
     * @return the Node that contains the Element, or null otherwise
     *
     * This method despite not being essential is very useful. It is written
     * here in order to be used by this class and its subclasses avoiding
     * recoding. So its access level is protected
     */
    protected Node<E> find(E element, Node<E> node) {
       if(node == null) return null;
       int comp = element.compareTo(node.getElement());
       if(comp == 0){
       return node;
       }else if (comp > 0){
           return find(element, node.getRight());
       }else
           return find(element, node.getLeft());
    }
//****************************************************************

    /**
     * Returns an iterable collection of elements of the tree, reported in
     * in-order.
     *
     * @return iterable collection of the tree's elements reported in in-order
     */
    public Iterable<E> inOrder() {
        List<E> snapshot = new ArrayList<>();
        inOrderSubtree(root, snapshot);
        return snapshot;
    }

    /**
     * Adds elements of the subtree rooted at Node node to the given snapshot
     * using an in-order traversal
     *
     * @param node Node serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void inOrderSubtree(Node<E> node, List<E> snapshot) {
        if (node == null) {
            return;
        }

        inOrderSubtree(node.getLeft(), snapshot);
        snapshot.add(node.getElement());
        inOrderSubtree(node.getRight(), snapshot);

    }

    /**
     * Returns an iterable collection of elements of the tree, reported in
     * pre-order.
     *
     * @return iterable collection of the tree's elements reported in pre-order
     */
    public Iterable<E> preOrder() {
        List<E> snapshot = new ArrayList<>();
        preOrderSubtree(root, snapshot);
        return snapshot;
    }

    /**
     * Adds elements of the subtree rooted at Node node to the given snapshot
     * using an pre-order traversal
     *
     * @param node Node serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void preOrderSubtree(Node<E> node, List<E> snapshot) {
        if (node == null) {
            return;
        }
        snapshot.add(node.getElement());
        preOrderSubtree(node.getLeft(), snapshot);
        preOrderSubtree(node.getRight(), snapshot);
    }

    /**
     * Returns an iterable collection of elements of the tree, reported in
     * post-order.
     *
     * @return iterable collection of the tree's elements reported in post-order
     */
    public Iterable<E> postOrder() {
        List<E> snapshot = new ArrayList<>();
        postOrderSubtree(root, snapshot);
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Node node to the given snapshot
     * using an post-order traversal
     *
     * @param node Node serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void postOrderSubtree(Node<E> node, List<E> snapshot) {
        if (node == null) {
            return;
        }
        postOrderSubtree(node.getLeft(), snapshot);
        postOrderSubtree(node.getRight(), snapshot);
        snapshot.add(node.getElement());

    }

//#########################################################################
    //---------------- nested Node class ----------------
    /**
     * Nested static class for a binary search tree node.
     */
    protected static class Node<E> {

        private E element;          // an element stored at this node
        private Node<E> left;       // a reference to the left child (if any)
        private Node<E> right;      // a reference to the right child (if any)

        /**
         * Constructs a node with the given element and neighbors.
         *
         * @param e the element to be stored
         * @param leftChild reference to a left child node
         * @param rightChild reference to a right child node
         */
        public Node(E e, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            left = leftChild;
            right = rightChild;
        }

        // accessor methods
        public E getElement() {
            return element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        // update methods
        public void setElement(E e) {
            element = e;
        }

        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
    } //----------- end of nested Node class -----------

//#########################################################################
//#########################################################################
    /**
     * Returns a string representation of the tree. Draw the tree horizontally
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, 0, sb);
        return sb.toString();
    }

    private void toStringRec(Node<E> root, int level, StringBuilder sb) {
        if (root == null) {
            return;
        }
        toStringRec(root.getRight(), level + 1, sb);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                sb.append("|\t");
            }
            sb.append("|-------" + root.getElement() + "\n");
        } else {
            sb.append(root.getElement() + "\n");
        }
        toStringRec(root.getLeft(), level + 1, sb);
    }

} //----------- end of BST class -----------

