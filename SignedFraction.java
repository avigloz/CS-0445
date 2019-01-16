public class SignedFraction extends Fraction
{
	private int sign;

	// FULL CONSTRUCTOR - STORES SIGN OF THE FRACTION THEN SETS BOTH number and denom POSITIVE
	public SignedFraction( int n, int d )
	{
		// FYI: JAVA JUST CALLED YOUR PARENT'S DEFAULT CONSTRUCTOR. YOU ARE 0/1 NOW
		// WE'LL FIX THAT SOON ENUF
		if (n < 0 || d < 0){
			if (!(n < 0 && d < 0))
				setSign(-1);
			else
				setSign(1);
		}
		else
			setSign(1);
		n = Math.abs(n);
		d = Math.abs(d);
		// SET YOUR sign TO EITHER -1 OR 1 BASED ON INCOMING n AND d
		// ASSIGN IN TO n AND D, THEIR abs VALUES. i.e. FLIP EM POSITIVE

		// NOW DO EXACTLY AS YOUR PARENT DID AT THIS POINT
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
		return "";  // REPLACE WITH YOUR CODE
	}

}// EOF
