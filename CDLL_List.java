import java.io.*;
import java.util.*;

public class CDLL_List<T>
{
	private CDLL_Node<T> head;  // pointer to the front (first) element of the list
	private int count=0;
	
	public CDLL_List()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FORM INCOMING FILE
	
	public CDLL_List( String fileName, String insertionMode ) throws Exception
	{
			BufferedReader infile = new BufferedReader( new FileReader( fileName ) );	
			while ( infile.ready() )
			{	@SuppressWarnings("unchecked") 
				T data = (T) infile.readLine(); // CAST CUASES WARNING (WHICH WE CONVENIENTLY SUPPRESS)
				if ( insertionMode.equals("atFront") )
					insertAtFront( data ); 	
				else if ( insertionMode.equals( "atTail" ) )
					insertAtTail( data ); 
				else
					die( "FATAL ERROR: Unrecognized insertion mode <" + insertionMode + ">. Aborting program" );
			}
			infile.close();
	}	
	
	private void die( String errMsg )
	{
		System.out.println( errMsg );
		System.exit(0);
	}
		
	// ########################## Y O U   W R I T E / F I L L   I N   T H E S E   M E T H O D S ########################

	// OF COURSE MORE EFFICIENT TO KEEP INTERNAL COUNTER BUT YOU COMPUTE IT DYNAMICALLY WITH A TRAVERSAL LOOP
	public int size()
	{
        // int num = 0;
        // if (head == null)
        //     return num;
        // for (CDLL_Node curr = head; curr.getNext() != head; curr = curr.getNext())
        //     num ++;
		// return num + 1;
		return count + 1;
	}


	// TACK A NEW NODE ONTO THE FRONT OF THE LIST
	@SuppressWarnings("unchecked")
	public void insertAtFront(T data)
	{
		// BASE CASE WRITTEN FOR YOU
		CDLL_Node<T> newNode = new CDLL_Node( data,null,null);
		if (head==null)
		{
			newNode.setNext( newNode );
			newNode.setPrev( newNode );
			head = newNode;
			return;
		}
		CDLL_Node<T> tail = head.getPrev();
		newNode.setNext(head);
		head.setPrev(newNode);
		head = newNode;
		head.setPrev(tail);
		tail.setNext(head);
		count++;
		// NOT EMPTY. INSERT NEW NODE  BETWEEN HEAD POINTER AND 1ST NODE
		// MAKE HEAD POINT TO NEW NODE
	}
	
	// TACK ON NEW NODE AT END OF LIST
	@SuppressWarnings("unchecked")
	public void insertAtTail(T data)
	{
        // BASE CASE WRITTEN FOR YOU
        if (head == null){
			insertAtFront(data);
			return;
		}
		CDLL_Node<T> newNode = new CDLL_Node(data,null,null);
		CDLL_Node tail = head.getPrev();

		newNode.setNext(head);
		newNode.setPrev(tail);
		head.setPrev(newNode);
		tail.setNext(newNode);

		count++;
		// NOT EMPTY. INSERT NEW NODE AFTER THE LAST/TAIL NODE
	}

	// RETURN TRUE/FALSE THIS LIST CONTAINS A NODE WITH DATA EQUALS KEY
	public boolean contains( T key )
	{
		return (search(key) != null) ? true : false;
	}
	// RETURN REF TO THE FIRST NODE (SEARCH CLOCKWISE FOLLOWING next) THAT CONTAINS THIS KEY. DO -NOT- RETURN REF TO KEY ISIDE NODE
    // RETURN NULL IF NOT FOUND
    @SuppressWarnings("unchecked")
	public CDLL_Node<T> search( T key )
	{
		CDLL_Node curr = head;
		do {
			if (curr.getData().equals(key))
				return curr;
			curr = curr.getNext();
		} while (curr != head);
        return null;
	}
	// RETURNS CONCATENATION OF CLOCKWISE TRAVERSAL
	public String toString()
	{
        if (head == null)
            return null;
        String toString = "";
        CDLL_Node curr = head;
        do {
            toString += (curr.getData());
            if (curr.getNext() != head)
                toString+="<=>";
            curr = curr.getNext();
		} while (curr != head);
        return toString;
	}
} // END CDLL_LIST CLASS