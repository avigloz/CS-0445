import java.io.*;
import java.util.*;

public class LinkedList<T>
{
	private Node<T> head;  // pointer to the front (first) element of the list

	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FORM INCOMING FILE
	public LinkedList( String fileName, boolean orderedFlag )
	{
		head=null;
		try
		{
			BufferedReader infile = new BufferedReader( new FileReader( fileName ) );
			while ( infile.ready() )
			{
				if (orderedFlag)
					insertInOrder( (T)infile.readLine() );  // WILL INSERT EACH ELEM INTO IT'S SORTED POSITION
				else
					insertAtTail( (T)infile.readLine() );  // TACK EVERY NEWELEM ONTO END OF LIST. ORIGINAL ORDER PRESERVED
			}
			infile.close();
		}
		catch( Exception e )
		{
			System.out.println( "FATAL ERROR CAUGHT IN C'TOR: " + e );
			System.exit(0);
		}
	}

	//-------------------------------------------------------------

	// inserts new elem at front of list - pushing old elements back one place

	public void insertAtFront(T data)
	{
		head = new Node<T>(data,head);
	}

	// we use toString as our print

	public String toString()
	{
		String toString = "";

		for (Node curr = head; curr != null; curr = curr.getNext())
		{
			toString += curr.getData();		// WE ASSUME OUR T TYPE HAS toString() DEFINED
			if (curr.getNext() != null)
				toString += " ";
		}

		return toString;
	}

	// ########################## Y O U   W R I T E    T H E S E    M E T H O D S ########################

	public int size()
	{
        int counter = 0;
        for (Node curr = head; curr.getNext() != null; curr = curr.getNext())
            counter++;
        return counter;
	}
	public boolean empty()
	{
		return (size() == 0) ? true : false;
	}
	public boolean contains( T key )
	{
		return (search(key) != null) ? true : false;
	}
	public Node<T> search( T key )
	{
        for (Node curr = head; curr.getNext() != null; curr = curr.getNext())
        if (curr.getData().equals(key))
			return curr;
        return null;
	}
	public void insertAtTail(T data) // TACK A NEW NODE (CABOOSE) ONTO THE END OF THE LIST
	{
		if (size() == 0)
        	insertAtFront(data);
        else {
            Node<T> temp = head;
            while (true){
                if (temp.getNext() != null)
                    temp = temp.getNext();
                else {
                    temp.setNext(new Node<T>(data));
                    break;
                }
            }
        }
	}
	public void insertInOrder(T  data) // PLACE NODE IN LIST AT ITS SORTED ORDER POSTIOPN
	{
		// if (size() == 0)
        // 	insertAtFront(data);
        // else {
        //     Node<T> temp = head;
        //     while (true){
        //         if (temp.getNext() != null && temp.compareTo(temp.getNext()) <= 0)
        //             temp = temp.getNext();
        //         else {
        //             temp.setNext(new Node<T>(data));
        //             break;
        //         }
        //     }
        // }
	}
	public boolean remove(T key) // FIND/REMOVE 1st OCCURANCE OF A NODE CONTAINING KEY
	{
		return false;
	}
	public boolean removeAtTail()	// RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{
		return false; // CHANGE TO YOUR CODE
	}
	public boolean removeAtFront() // RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{
		return false; // CHANGE TO YOUR CODE
	}
	public LinkedList<T> union( LinkedList<T> other )
	{
		return  null; // CHANGE TO YOUR CODE
	}
	public LinkedList<T> inter( LinkedList<T> other )
	{
		return  null; // CHANGE TO YOUR CODE
	}
	public LinkedList<T> diff( LinkedList<T> other )
	{
		return  null; // CHANGE TO YOUR CODE
	}
	public LinkedList<T> xor( LinkedList<T> other )
	{
		return  null; // CHANGE TO YOUR CODE
	}

} //END LINKEDLIST CLASS
