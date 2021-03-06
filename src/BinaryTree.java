public class BinaryTree<E extends Comparable<E>>
{
    //field
    private Node<E> mRoot;
    public BinaryTree()
    {
        mRoot = null;
    }

    public void clear()
    {
        mRoot = null;
        //Request garbage collection
        System.gc();
    }

    public boolean add(E element)
    {
        //Calls recursive add, starting at the root
        addRecursive(mRoot, element);
        return true;
    }

    @Override
    public String toString()
    {
        
    }

    private Node<E> addRecursive(Node<E> current, E element)
    {
        //when the current node is null
        //we've reached a leaf node and we can insert the new node in that position
        if(current == null)
            current = new Node(element);


        //if the element is less than the current node's data
        //we go to the left child
        else if(element.compareTo(current.mData)<0)
            return addRecursive(current.mLeft, element);


        //if the element is greater than the current node's data
        //we got to the right child
        else if(element.compareTo(current.mData)>0)
            return addRecursive(current.mRight, element);

        else
            return current;


    }

    //Nested Inner Class
    private class Node<E extends Comparable<E>>
    {
        private Node<E> mLeft;
        private E mData;
        private Node<E> mRight;

        public Node(E data, Node<E> left, Node<E> right)
        {
            //
            mData = data;
            mLeft = left;
            mRight = right;
        }
        public Node(E data)
        {
            this(data, null, null);
        }

        public boolean isLeaf()
        {
            return mLeft == null && mRight == null;
        }
    }

}
