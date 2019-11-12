/*************************
 *
 *  Pace University
 *
 *  Course: CS 242 Algorithms and Computing Theory
 *  Author: 
 *  Collaborators: Poorva Shelake, Pooja Panchakshari, Garry 
 *  References: 
 *
 *  Assignment: 1
 *  Problem: Testing running times of Brute Force and Divide and Conquer Method
 *  Description: This Problem measures running time of Brute Force method and Divide and Conquer Method
 *					to find out the maximum sub array sum
 *
 *  Input: array size
 *  Output: running times to find maximum sub array sum
 *
 *  Visible data fields:
 * none.
 *
 *  Visible methods:
 * public static void main(String args[])
 * public static int max_sum(int arr[])
 * public static void findMaximumSubArray(int arr[],int low,int high)
 * public static void findMaxCrossingSubArray(int arr[],int low,int mid,int high)
 *
 *
 *   Remarks
 *   -------
 *
 *   Chart of running times observed in nanoseconds:
 *
 *   Size     |    Skewed Tree		    |    Balanced Tree	
 *  ------------------------------------------------------------
 *  1000      |        1326157          |   1035352	 
 *  ------------------------------------------------------------
 *  10000     |        2755806          |   1155950	
 *  ------------------------------------------------------------
 *  50000     |        1143121372       |   6642755	
 *  ------------------------------------------------------------
 *  100000    |        4059438824       |   10075537		
 *  ------------------------------------------------------------
 *  500000    |        123014599264     |   36343350
 *  ------------------------------------------------------------
 *
 * Observation:
 *************************/

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// *******PUBLIC OPERATIONS********
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// *******ERRORS***********
// Throws UnderflowException as appropriate

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
import java.util.Random;
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    /*public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
   /* public AnyType findMax( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMax( root ).element;
    }
    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<AnyType>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


      /** The tree root. */
    private BinaryNode<AnyType> root;


        // Test program
    public static void main( String [ ] args )
    {
        BinarySearchTree<Integer> t = new BinarySearchTree<Integer>( );
        final int NUMS = 8000;
        final int GAP  = 1;
		int rand;

        System.out.println( "Checking... (no more output means success)" );

		//Skewed Tree
        for( int i = 1; i <= NUMS; i++ )
            t.insert( i );
	
        /*if( NUMS < 400 )
		{
			System.out.println( "Tree is :" );
            t.printTree( );
		}*/
		
		long startTime = System.nanoTime();
	
		System.out.println("\nSkewed Tree: ");
		
		if( !t.contains( NUMS+1 ) )
			 System.out.println( "Element Not Found!" );
		
		System.out.println("\nThe time taken by it is " + (System.nanoTime() - startTime) + " nanoseconds.");
		
		for( int i = 1; i <= NUMS; i++ )
        	    t.remove( i );

		//Balanced Tree
		Random rand1 = new Random();	
		for( int i = 0; i < NUMS ; i++)	
		{
			rand = rand1.nextInt(Integer.MAX_VALUE) % NUMS + 1;
            t.insert(rand);
		}
     
        /*if( NUMS < 400 )
		{
			System.out.println( "Tree is :" );
            t.printTree( );
		}
		*/
		
		startTime = System.nanoTime();
	
		System.out.println("\nBalanced Tree: ");
		
		
		if( !t.contains( NUMS+1 ) )
			 System.out.println( "Element Not Found!" );
		
		System.out.println("\nThe time taken by it is " + (System.nanoTime() - startTime) + " nanoseconds.");


    }
}