class BSTNode<T>
{
	private T key;
	private BSTNode<T> left,right;
	public BSTNode( T key, BSTNode<T> left, BSTNode<T> right )
	{
		setKey( key );
		setLeft( left );
		setRight( right ); 
	}
	public T getKey()
	{
		return key;
	}
	public void setKey( T key )
	{
		this.key=key;
	}
	
	public void setLeft( BSTNode<T> left)
	{
		this.left=left;
	}
	public void setRight( BSTNode<T> right)
	{
		this.right=right;
	}
	
	public BSTNode<T> getLeft()
	{
		return left;
	}
	public BSTNode<T> getRight()
	{
		return right;
	}	
}