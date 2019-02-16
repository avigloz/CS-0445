import java.io.*;
import java.util.*;

public class CDLL_JosephusList<T>
{
	private CDLL_Node<T> head;  // pointer to the front (first) element of the list
	private int count=0;
	public CDLL_JosephusList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}
	// LOAD LINKED LIST FORM INCOMING FILE
	public CDLL_JosephusList( String infileName ) throws Exception
	{
		BufferedReader infile = new BufferedReader( new FileReader( infileName ) );	
		while ( infile.ready() )
		{	@SuppressWarnings("unchecked") 
			T data = (T) infile.readLine(); // CAST CUASES WARNING (WHICH WE CONVENIENTLY SUPPRESS)
			insertAtTail( data ); 
		}
		infile.close();
	}
	// ########################## Y O U   W R I T E / F I L L   I N   T H E S E   M E T H O D S ########################
	// TACK ON NEW NODE AT END OF LIST
	@SuppressWarnings("unchecked")
	public void insertAtTail(T data)
	{
        CDLL_Node<T> newNode = new CDLL_Node(data,null,null);
        if (head == null) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
			head = newNode;
			count++;
            return;
        }
        CDLL_Node tail = head.getPrev();

        newNode.setNext(head);
        newNode.setPrev(tail);
        head.setPrev(newNode);
        tail.setNext(newNode);

        count++;
	}
	public int size()
	{	
		return count;
	}
    // RETURN REF TO THE FIRST NODE CONTAINING  KEY. ELSE RETURN NULL
    @SuppressWarnings("unchecked")
	public CDLL_Node<T> search( T key )
	{	
        if (head == null)
            return null;
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
        CDLL_Node<T> curr = head;
        do {
            toString += (curr.getData());
            if (curr.getNext() != head)
                toString += "<=>";
            curr = curr.getNext();
		} while (curr != head);
        return toString;
	}
	void removeNode( CDLL_Node<T> deadNode )
	{
        if (head == null)
            return;
        // if (deadNode == head) {
		// 	CDLL_Node<T> prev = head.getPrev();
		// 	head = head.getNext();
		// 	head.setPrev(prev);
		// 	prev.setNext(head);
		// 	count--;
		// 	return;
		// }
		CDLL_Node<T> prev = deadNode.getPrev();
		CDLL_Node<T> next = deadNode.getNext();
		prev.setNext(next);
		next.setPrev(prev);
        count--;
	}
	public void executeRitual( T first2Bdeleted, int skipCount )
	{
		if (size() < 1 ) return;
		CDLL_Node<T> curr = search( first2Bdeleted );
		if ( curr==null ) return;
		// OK THERE ARE AT LEAST 2 NODES AND CURR IS SITING ON first2Bdeleted
		do
		{
			CDLL_Node<T> deadNode = curr;
			T deadName = deadNode.getData();

			System.out.println("stopping on " + deadName + " to delete " + deadName);
			removeNode(deadNode);		
			boolean clockwise = (skipCount > 0) ? true : false;
			if (clockwise)
				curr = deadNode.getNext();
			else
				curr = deadNode.getPrev();
			if (head == deadNode)
				head = curr;

			System.out.println("deleted. list now:   " + toString());

			if (size() == 1)
				break;


			T name = curr.getData();
			if (clockwise){
				System.out.println("resuming at " + name + ", skipping " + name + " + " + (skipCount - 1) + " CLOCKWISE after");
				for (int skips = 0; skips < skipCount; skips++)
					curr = curr.getNext();
			}
			else {
				System.out.println("resuming at " + name + ", skipping " + name + " + " + (-skipCount - 1) + " COUNTER_CLOCKWISE after");
				for (int skips = 0; skips < -skipCount; skips++)
					curr = curr.getPrev();
			}
		}
		while (size() > 1 );

	}
	
} // END CDLL_LIST CLASS