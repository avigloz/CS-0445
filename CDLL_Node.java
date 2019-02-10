public class CDLL_Node<T>
{
  private T data;
  private CDLL_Node<T> prev, next; // EACH CDLL_Node PTS TO ITS PREV  & NEXT

  public CDLL_Node()
  {
    this( null, null, null );  // 3 FIELDS TO INIT
  }

  public CDLL_Node(T data)
  {
    this( data, null, null);
  }

  public CDLL_Node(T data, CDLL_Node<T> prev, CDLL_Node<T> next)
  {
    setData( data );
	setPrev( prev );
    setNext( next );
  }

  public T getData()
  {
    return data;
  }

  public CDLL_Node<T> getPrev()
  {
    return prev;
  }
  public CDLL_Node<T> getNext()
  {
    return next;
  }

  public void setData(T data)
  {
     this.data = data;
  }

  public void setNext(CDLL_Node<T> next)
  {
    this.next = next;
  }
  
  public void setPrev(CDLL_Node<T> prev)
  {
    this.prev = prev;
  }
 
  public String toString()
  {
	  return ""+getData();
  } 
	 
} //EOF