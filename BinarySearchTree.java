import java.util.*;

/**
 * This BinarySearchTree object defines a reference based binary search tree
 * 
 * @author  
 * @version 
 */

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{
    protected BinaryNode<T> root;      // reference to the root of this BST

    // Creates an empty Binary Search Tree object
    public BinarySearchTree()
    {
        root = null;
    }

    // Returns true if this BST is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return root==null;
    }

    // Returns the number of elements in this BST.
    public int size()
    {
        //TODO
        return -1;
    }

    // Adds element to this BST. The tree retains its BST property.
    public void add (T element)
    {
        //TODO
        if(isEmpty())
            root = new BinaryNode<T>(element);
        BinaryNode<T> curNode = root;
        while(true)
        {
            if(element.compareTo(curNode)<=0)
            {

            }
        }
    }

    // Returns true if this BST contains an element e such that 
    // e.compareTo(element) == 0; otherwise, returns false.
    public boolean contains (T element)
    {
        //TODO
        return false;
    }

    // Returns a graphical representation of the tree
    public String toString()
    {
        return toString(root, 0);
    }

    private String toString(BinaryNode<T> tree, int level)
    {
        String str = "";
        if (tree != null)
        {
            str += toString(tree.getRight(), level + 1);
            for (int i = 1; i <= level; ++i)
                str = str + "| ";
            str += tree.getInfo().toString() + "\n";
            str += toString(tree.getLeft(), level + 1);
        }
        return str;
    }

    // Returns a list of elements from a preorder traversal
    public List<T> preorderTraverse()
    {
        //TODO
        return null;
    }

    // Returns a list of elements from an inorder traversal
    public List<T> inorderTraverse()
    {
        //TODO
        return null;
    }

    // Returns a list of elements from a postorder traversal
    public List<T> postorderTraverse()
    {
        //TODO
        return null;
    }

    // Removes an element e from this BST such that e.compareTo(element) == 0
    public void remove (T element)
    {
        //TODO
    }

    // Restructures this BST to be optimally balanced
    public void balance()
    {
        //TODO
    }
}