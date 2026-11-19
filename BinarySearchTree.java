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
        if(this.isEmpty())
            return 0;
        if(this.root.getLeft()==null&&this.root.getLeft()==null)
            return 1;

        BinarySearchTree<T> left = new BinarySearchTree<>();
        BinarySearchTree<T> right = new BinarySearchTree<>();
        if(root.getLeft()!=null)
            left.setRoot(root.getLeft());
        if(root.getRight()!=null)
            right.setRoot(root.getRight());
        return 1+left.size()+right.size();
    }

    // Adds element to this BST. The tree retains its BST property.
    public void add (T element)
    {
        if(isEmpty())
        {
            root = new BinaryNode<T>(element);
            return;
        }
        BinaryNode<T> curNode = root;
        while(true)
        {
            if((element).compareTo(curNode.getInfo())<=0)
            {
                if(curNode.getLeft()==null)
                {
                    curNode.setLeft(new BinaryNode<T>(element));
                    return;
                }
                else{
                    curNode=curNode.getLeft();
                }
            }
            else
            {
                if(curNode.getRight()==null)
                {
                    curNode.setRight(new BinaryNode<T>(element));
                    return;
                }
                else{
                    curNode=curNode.getRight();
                }
            }
        }
    }

    // Returns true if this BST contains an element e such that 
    // e.compareTo(element) == 0; otherwise, returns false.
    public boolean contains (T element)
    {
        BinaryNode<T> curNode = root;
        while(curNode!=null)
        {
            if(curNode.getInfo().compareTo(element)<0)
            {
                curNode = curNode.getRight();
            }
            else if(curNode.getInfo().equals(element))
            {
                return true;
            }
            else
            {
                curNode = curNode.getLeft();
            }
        }
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
        if(this.isEmpty())
            return null;
        if(root.getLeft()==null&&root.getRight()==null)
        {
            List<T> list = new ArrayList<>();
            list.add(root.getInfo());
            return list; // return a list of info that is just the root
        }
        ArrayList<T> list = new ArrayList<>();
        list.add(root.getInfo());
        BinarySearchTree<T> leftTree = new BinarySearchTree<>();
        leftTree.setRoot(root.getLeft());
        List<T> left = leftTree.preorderTraverse();
        BinarySearchTree<T> rightTree = new BinarySearchTree<>();
        rightTree.setRoot(root.getRight());
        List<T> right = rightTree.preorderTraverse();
        if(left!=null)
        {
            for(int i = 0; i < left.size(); i++)
            {
                list.add(left.get(i));
            }
        }
        if(right!=null)
        {
            for(int i = 0; i < right.size(); i++)
            {
                list.add(right.get(i));
            }
        }
        return list;
    }

    // Returns a list of elements from an inorder traversal
    public List<T> inorderTraverse()
    {
        if(this.isEmpty())
            return null;
        if(root.getLeft()==null&&root.getRight()==null)
        {
            List<T> list = new ArrayList<>();
            list.add(root.getInfo());
            return list; // return a list of info that is just the root
        }
        ArrayList<T> list = new ArrayList<>();
        BinarySearchTree<T> leftTree = new BinarySearchTree<>();
        leftTree.setRoot(root.getLeft());
        List<T> left = leftTree.inorderTraverse();
        BinarySearchTree<T> rightTree = new BinarySearchTree<>();
        rightTree.setRoot(root.getRight());
        List<T> right = rightTree.inorderTraverse();
        if(left!=null)
        {
            for(int i = 0; i < left.size(); i++)
            {
                list.add(left.get(i));
            }
        }
        list.add(root.getInfo());
        if(right!=null)
        {
            for(int i = 0; i < right.size(); i++)
            {
                list.add(right.get(i));
            }
        }
        return list;
    }

    // Returns a list of elements from a postorder traversal
    public List<T> postorderTraverse()
    {
        if(this.isEmpty())
            return null;
        if(root.getLeft()==null&&root.getRight()==null)
        {
            List<T> list = new ArrayList<>();
            list.add(root.getInfo());
            return list; // return a list of info that is just the root
        }
        ArrayList<T> list = new ArrayList<>();
        BinarySearchTree<T> leftTree = new BinarySearchTree<>();
        leftTree.setRoot(root.getLeft());
        List<T> left = leftTree.postorderTraverse();
        BinarySearchTree<T> rightTree = new BinarySearchTree<>();
        rightTree.setRoot(root.getRight());
        List<T> right = rightTree.postorderTraverse();
        if(left!=null)
        {
            for(int i = 0; i < left.size(); i++)
            {
                list.add(left.get(i));
            }
        }
        if(right!=null)
        {
            for(int i = 0; i < right.size(); i++)
            {
                list.add(right.get(i));
            }
        }
        list.add(root.getInfo());
        return list;
    }

    // Removes an element e from this BST such that e.compareTo(element) == 0
    public void remove (T element)
    {
        BinaryNode<T> curNode = root;
        BinaryNode<T> parentNode = curNode;
        if(root.getInfo().equals(element))
        {
            if(root.getLeft()==null)
            {
                root = root.getRight();
                return;
            }
            else if(root.getRight()==null)
            {
                root = root.getLeft();
                return;
            }
            else
            {
                curNode = curNode.getLeft();
                while(curNode.getRight()!=null)
                {
                    parentNode = curNode;
                    curNode = curNode.getRight();
                }
                parentNode.setRight(curNode.getLeft());
                root.setInfo(curNode.getInfo());
                return;
            }
        }
        while(curNode!=null)
        {
            
            if(curNode.getInfo().compareTo(element)<0)
            {
                parentNode = curNode;
                curNode = curNode.getRight();
            }
            else if(curNode.getInfo().equals(element))
            {
                break;
            }
            else
            {
                parentNode = curNode;
                curNode = curNode.getLeft();
            }
        }
        if(curNode==null)
            //node not found
            return;
        else if(parentNode==curNode)
            //size==1
            root = null;
        else
        {
            //node found, remove it

            //node has no links
            if(curNode.getLeft()==null&&curNode.getRight()==null)
            {
                if(parentNode.getInfo().compareTo(curNode.getInfo())<=0)
                {
                    parentNode.setRight(null);
                }
                else
                {
                    parentNode.setLeft(null);
                }
            }
            //node has one link
            else if((curNode.getLeft()==null&&curNode.getRight()!=null)||(curNode.getLeft()!=null&&curNode.getRight()==null))
            {
                if(parentNode.getInfo().compareTo(curNode.getInfo())<=0)
                {
                    if(curNode.getLeft()!=null)
                        parentNode.setRight(curNode.getLeft());
                    else
                        parentNode.setRight(curNode.getRight());
                }
                else
                {
                     if(curNode.getLeft()!=null)
                        parentNode.setLeft(curNode.getLeft());
                    else
                        parentNode.setLeft(curNode.getRight());
                }
            }
            //node has two links, hardest case
            else
            {
                BinaryNode<T> removeNode = curNode;
                curNode = curNode.getLeft();
                while(curNode.getRight()!=null)
                {
                    parentNode = curNode;
                    curNode = curNode.getRight();
                }
                removeNode.setInfo(curNode.getInfo());
                parentNode.setRight(curNode.getLeft());
            }
        }
    }

    // Restructures this BST to be optimally balanced
    public void balance()
    {
        if(root==null)
            return;
        else if(root.getLeft()==null&&root.getRight()==null)
            return;
        List<T> tree = inorderTraverse();
        root = new BinaryNode<T>(tree.get( (int) (tree.size()/2) ));

    }

    //OPTIONAL METHOD
    public void setRoot(BinaryNode<T> newRoot)
    {
        root = newRoot;
    }
}