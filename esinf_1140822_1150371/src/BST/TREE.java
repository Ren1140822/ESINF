
package BST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 *
 * @author DEI-ESINF
 * @param <E>
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
public E smallestElement()
public Iterable<E> inOrder()
public Iterable<E> preOrder()
public Iterable<E> postOrder()
public Map<Integer,List<E>> nodesByLevel()
++++++++++++++++++++++++++++++
public Iterator<E> iterator()

public List<E> ascdes()


*/
public class TREE<E extends Comparable<E>> extends BST<E>{


//****************************************************************
    public Iterator<E> iterator() {
        return new BSTIterator();
    }  
//#########################################################################
//#########################################################################
//---------------------------------------------------------------   
/**
 * Returns the tree without leaves.
 *
 * @return tree without leaves
 */
public BST<E> autumnTree() {
      throw new UnsupportedOperationException("Not supported yet.");
}
private Node<E> copyRec(Node<E> node){
      throw new UnsupportedOperationException("Not supported yet.");
}
    
//#########################################################################
//#########################################################################  
private class BSTIterator implements Iterator<E>{
    private final Stack<Node<E>> stack;
    E curElement;       //current element
    boolean canRemove;  //to enable remove()
    
    public BSTIterator() {
        stack=new Stack<>();
        Node<E> cur=(Node<E>)root();
        while(cur!=null){
            stack.push(cur);
            cur=cur.getLeft();
        }
        curElement=null;
        canRemove=false;
    }
 
    /** @return whether we have a next smallest element */
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
    /** @return the next smallest element */
    @Override
    public E next() {
        throw new UnsupportedOperationException("Not supported yet.");
    }  

    /** remove the current element */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }  
    }    
//#########################################################################
//######################################################################### 
 /**
   * build a list with all elements of the tree. The elements in the 
   * left subtree in ascending order and the elements in the right subtree 
   * in descending order. 
   *
   * @return    returns a list with the elements of the left subtree 
   * in ascending order and the elements in the right subtree is descending order.
   */
public Iterable<E> ascdes(){
        throw new UnsupportedOperationException("Not supported yet.");
}

private void ascSubtree(Node<E> node, List<E> snapshot) {
        throw new UnsupportedOperationException("Not supported yet.");
}
private void desSubtree(Node<E> node, List<E> snapshot) {
        throw new UnsupportedOperationException("Not supported yet.");
}
 
}
