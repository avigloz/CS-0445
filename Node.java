public class Node<T>
{
  private T  data;
  private Node next;

  public Node()
  {
    this( null, null );
  }

  public Node(T data)
  {
    this( data, null );
  }

  public Node(T data, Node next)
  {
    setData( data );
    setNext( next );
  }

  public T getData()
  {
    return data;
  }

  public Node getNext()
  {
    return next;
  }

  public void setData(T data)
  {
     this.data = data;
  }

  public void setNext(Node next)
  {
    this.next = next;
  }
  public String toString()
  {
	  return ""+getData();
  } 
	 
} //EOF