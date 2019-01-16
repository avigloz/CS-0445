public class Fraction
{
	private int numer;
	private int denom;

	// ACCESSORS (SETTERS)
	public int getNumer()
	{	return numer;
	}
	public int getDenom()
	{	return denom;
	}
	// MUTATORS (GETTERS)
	public void setNumer( int n )
	{	numer = n;
	}
	public void setDenom( int d )
	{
		if (d==0) { System.out.println("Can't have 0 in denom"); System.exit(0); }
		else denom=d;
	}

	// FULL CONSTRUCTOR - an arg for each class data member
	public Fraction( int n, int d )
	{	int gcd = gcd( Math.abs(n), Math.abs(d) );
		setNumer(n/gcd);
		setDenom(d/gcd);
	}

	// DEFULT CONSTRUCTOR - 0/1
	public Fraction( )
	{
		this( 0, 1 ); // DEFER TO FULL C'TOR
	}

	//  GIVING YOU A WORKING (ITERATIVE) GCD J.I.C. YOU HAVE NEVER WRITTEN ONE
	public int gcd( int n, int d )
	{	int gcd = n<d ? n : d;    // same as => if (n<d) gcd=n; else gcd=d;
		while( gcd > 0 )
		{	if (n%gcd==0 && d%gcd==0)
				return gcd;
			else --gcd;
		}
		return 1; // they were co-prime no GCD exceopt 1 :(
	}

	public String toString() // USE AS IS. DO NOT DELETE OR MODIFY
	{
		return getNumer() +  "/" + getDenom() + "\t=" +  + ((double)getNumer()/(double)getDenom());
	}
}// EOF
