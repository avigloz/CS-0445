public class SignedFraction extends Fraction
{
	private int sign;

	// FULL CONSTRUCTOR - STORES SIGN OF THE FRACTION THEN SETS BOTH number and denom POSITIVE
	public SignedFraction( int n, int d )
	{
		//super(n, d);
		setSign(1);
		if (n < 0 || d < 0){
			if (!(n < 0 && d < 0))
				setSign(-1);
			else
				setSign(1);
		}
		n = Math.abs(n);
		d = Math.abs(d);

		// Why not just call super(n, d)? The parent does all the gcd, absolute values, etc. already.

		int gcd = gcd( n, d );
		setNumer(n/gcd);
		setDenom(d/gcd);
	}

	private void setSign( int s )
	{
		if (s!=1 && s!=-1) // THE ONLY POSSIBLE LEAGAL VALUES FOR THE SIGN
		{
			System.out.println( "FATAL ERROR: Attempt to assign invalid sign value: " + s );
			System.exit(0);
		}
		sign = s;
	}

	private int getSign()
	{
		return sign;
	}

	// OVERWRITE/RIDE PARENT toString
	public String toString()
	{
		return (getSign() * getNumer()) + "/" + getDenom() + "\t=" + (getSign() * (double)getNumer()/(double)getDenom());  // REPLACE WITH YOUR CODE
	}

}// EOF
